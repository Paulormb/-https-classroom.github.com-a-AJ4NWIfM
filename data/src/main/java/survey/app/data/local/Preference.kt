package survey.app.data.local

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class Preference @Inject constructor(mApp: Application) : IPreference {

    private val mPref: SharedPreferences

    init {
        mPref = mApp.getSharedPreferences(SHARED_REFERENCE_NAME, Context.MODE_PRIVATE)
    }

    companion object {

        /**
         * normal configurations
         */
        private val SHARED_REFERENCE_NAME = "Application Config"
        const val PREF_TOKEN = "pref_token"
    }

    override var token: String
        get() = mPref.getString(PREF_TOKEN, "") ?: ""
        set(value) {
            mPref.edit().putString(PREF_TOKEN, value).apply()
        }
}
