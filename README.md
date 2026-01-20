# Heytap-OAID的Mock服务

用于解决Oppo、一加设备刷入非国产系统后无法获取到OAID进而导致的一些问题

模拟一个`OPEN_ID_SERVICE`返回一个随机字符串，生成规则没有与真正的服务匹配

此项目仅用于学习、研究，不可用于生产环境

## 低版本的使用说明

由于三方系统没有将此应用添加到`forceQueryable`列表中，API30+ 如果应用没有显示声明`<queries>`，则会导致`isSupport=false`

所以需要你的应用声明`<queries> <package name="com.heytap.openid" />`，或直接粗暴简单的声明`<uses-permission android:name="android.permission.QUERY_ALL_PACKAGES" />`

如果你的设备支持`xposed`，可以直接开启此模块并勾选允许`System Framework`

## 效果

| APP | OAID |
| --- | --- |
|![app](img/app.png) | ![oaid](img/oaid.png) |
