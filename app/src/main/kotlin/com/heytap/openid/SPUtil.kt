package com.heytap.openid

import android.content.Context
import java.util.UUID

private const val SP_FILENAME = "MOCK_DB"

private const val KEY = "oaid"

fun Context.getOAID(): String {
    return getSharedPreferences(SP_FILENAME, Context.MODE_PRIVATE)
        .getString(KEY, "")!!
}

fun Context.resetOAID(): String {
    UUID.randomUUID().toString().replace("-", "").apply {
        getSharedPreferences(SP_FILENAME, Context.MODE_PRIVATE).edit().putString(KEY, this).apply()
        return this
    }
}