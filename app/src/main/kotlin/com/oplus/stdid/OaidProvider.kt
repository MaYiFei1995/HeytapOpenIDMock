package com.oplus.stdid

import android.content.Context
import android.os.RemoteException
import android.util.Log
import com.heytap.openid.getOAID

/**
 * 这是模拟服务的核心实现 (Binder的实现)。
 * 它继承自 AIDL 生成的 Stub 类，并提供了 getSerID 方法的具体逻辑。
 */
class OaidProvider(private val context: Context) : IStdID.Stub() {

    @Throws(RemoteException::class)
    override fun getSerID(pkgName: String, sign: String, type: String): String {
        if ("OUID" == type) {
            val mockOAID = context.getOAID()
            Log.d(TAG, "Mock service received a request for OAID.")
            Log.d(TAG, "Requesting package: $pkgName")
            Log.d(TAG, "Requesting signature: $sign")
            Log.d(TAG, "Requesting type: $type")
            Log.i(TAG, "Returning mock OAID: $mockOAID")
            return mockOAID
        }
        Log.d(TAG, "Mock service received a request for $type, ignore.")
        return ""
    }

    companion object {
        private const val TAG = "MockOaidProvider"
    }

}