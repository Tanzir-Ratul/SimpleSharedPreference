package com.example.sharedpreference.demo

import android.content.Context

class SessionManager(context: Context) {
	private val sharedPreferences =
		context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
	private val editor = sharedPreferences.edit()
	
	fun createSession(name: String, phoneNo: String, email: String) {
		editor.putString(NAME, name)
		editor.putString(PHONE_NO, phoneNo)
		editor.putString(EMAIL, email)
		editor.putBoolean(KEY_IN_LOGGED_IN, true)
		editor.commit()
	}
	
	fun logOutSession(exit: Boolean = false) {
		if (exit) {
			editor.clear()
			editor.commit()
		}
		
	}
	
	fun getSessionDetails(key: String): String? {
		return sharedPreferences.getString(key, null)
	}
	
	
	fun checkSession(): Boolean {
		return sharedPreferences.contains(KEY_IN_LOGGED_IN)
	}
	
	companion object {
		const val PREF_FILE_NAME = "SHARED_PREF"
		const val NAME = "NAME"
		const val PHONE_NO = "PHONE_NO"
		const val EMAIL = "EMAIL"
		var KEY_IN_LOGGED_IN = "KEY_SESSION_IF_LOGGED_IN"
		
	}
}