// IOpenID.aidl
package com.heytap.openid; // 包名应与远程服务匹配

interface IOpenID {
    String getSerID(String pkgName, String sign, String type);
}