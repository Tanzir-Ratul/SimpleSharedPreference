package com.example.sharedpreference.demo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sharedpreference.R
import com.example.sharedpreference.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
	private lateinit var binding: FragmentProfileBinding
	private lateinit var session: SessionManager
	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		return FragmentProfileBinding.inflate(inflater).apply {
			lifecycleOwner = viewLifecycleOwner
			binding = this
		}.root
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		session = SessionManager(requireContext())
		session.getSessionDetails(SessionManager.NAME).let { Log.d("getSessionDetails","$it") }
		session.getSessionDetails(SessionManager.EMAIL).let { Log.d("getSessionDetails","$it") }
		session.getSessionDetails(SessionManager.PHONE_NO).let { Log.d("getSessionDetails","$it") }
		binding.logoutBtn.setOnClickListener {
			session.logOutSession(true)
			parentFragmentManager.beginTransaction().apply {
				replace(R.id.fragmentContainerView, LoginFragment())
				commit()
			}
		}
	}
	
}