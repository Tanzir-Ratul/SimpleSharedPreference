package com.example.sharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.example.sharedpreference.databinding.ActivityMainBinding
import com.example.sharedpreference.demo.LoginFragment
import com.example.sharedpreference.demo.ProfileFragment

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding
	private var doubleBackToExitPressedOnce = false
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		
		if (intent.getBooleanExtra("isLoggedIn", true)) {
			supportFragmentManager.beginTransaction().apply {
				replace(R.id.fragmentContainerView, ProfileFragment())
				commit()
			}
		}else{
			supportFragmentManager.beginTransaction().apply {
				replace(R.id.fragmentContainerView, LoginFragment())
				commit()
			}
		}
	}
	
	@Deprecated("Deprecated in Java")
	override fun onBackPressed() {
		if(doubleBackToExitPressedOnce){
			super.onBackPressed()
			return
		}
		this.doubleBackToExitPressedOnce = true
		Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show()
		Handler(Looper.getMainLooper()).postDelayed(
			{
				doubleBackToExitPressedOnce = false
			},2000
		)
	}
	
}