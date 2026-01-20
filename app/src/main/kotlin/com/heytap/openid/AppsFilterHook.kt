package com.heytap.openid

import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage

class AppsFilterHook : IXposedHookLoadPackage {

    @Throws(Throwable::class)
    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        // 目标是系统进程
        if (!lpparam.packageName.equals("android")) return

        // 根据 Android 版本不同，类名可能略有差异，通常是 AppsFilter 或 AppsFilterImpl
        XposedHelpers.findAndHookMethod(
            "com.android.server.pm.AppsFilter",  // Android 13+ 可能是 com.android.server.pm.AppsFilterImpl
            lpparam.classLoader,
            "shouldFilterApplication",
            Int::class.javaPrimitiveType,  // callingUid
            Any::class.java,  // callingSetting
            Any::class.java,  // targetPkgSetting
            Int::class.javaPrimitiveType,  // userId
            object : XC_MethodHook() {
                @Throws(Throwable::class)
                protected override fun afterHookedMethod(param: MethodHookParam) {
                    // 获取被查询方的包名信息
                    val targetPkgSetting: Any? = param.args[2]
                    if (targetPkgSetting == null) return

                    // 通过反射获取包名 (不同版本字段名可能为 pkg 或 packageName)
                    val targetPkgName =
                        XposedHelpers.getObjectField(targetPkgSetting, "name") as String?

                    // 强制返回 false（即不拦截，变为可见）
                    if ("com.heytap.openid" == targetPkgName || "com.coloros.mcs" == targetPkgName) {
                        param.setResult(false)
                    }
                }
            }
        )
    }

}