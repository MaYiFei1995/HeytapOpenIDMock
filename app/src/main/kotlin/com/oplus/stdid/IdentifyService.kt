package com.oplus.stdid

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.heytap.openid.OaidProvider

class IdentifyService : Service() {
    private var mBinder: OaidProvider? = null

    override fun onCreate() {
        super.onCreate()
        mBinder = OaidProvider(this)
        Log.i(TAG, "MockIdentifyService has been created.")
    }

    override fun onBind(intent: Intent): IBinder? {
        Log.i(TAG, "A client is binding to MockIdentifyService with action: " + intent.action)
        return mBinder
    }

    override fun onUnbind(intent: Intent): Boolean {
        Log.i(TAG, "A client has unbound from MockIdentifyService.")
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        Log.i(TAG, "MockIdentifyService is being destroyed.")
        super.onDestroy()
    }

    companion object {
        private const val TAG = "MockIdentifyService"
    }

}