package com.example.sharedpreference.demo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedpreference.MainActivity
import com.example.sharedpreference.R

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
	private lateinit var session : SessionManager
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_splashctivity)
		session = SessionManager(applicationContext)
		val isLoggedIn = session.checkSession()
		
		Handler(Looper.getMainLooper()).postDelayed(
			{
				startActivity(
					Intent(this, MainActivity::class.java).putExtra(
						"isLoggedIn", isLoggedIn
					)
				).also {
					finish()
				}
			},3000
		)
		
		
	}
}