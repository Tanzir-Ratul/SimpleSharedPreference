package com.example.sharedpreference.demo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sharedpreference.R
import com.example.sharedpreference.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {
	private lateinit var binding: FragmentRegisterBinding
	private lateinit var session: SessionManager
	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
	): View {
		binding = FragmentRegisterBinding.inflate(inflater).apply {
			lifecycleOwner = viewLifecycleOwner
		}
		return binding.root
	}
	
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		session = SessionManager(requireContext())
		
		click()
	}
	
	private fun click() {
		binding.registerBtn.setOnClickListener {
			register()
			parentFragmentManager.beginTransaction().apply {
				replace(R.id.fragmentContainerView, ProfileFragment())
				commit()
			}
		}
		binding.alreadyRegBtn.setOnClickListener {
			parentFragmentManager.beginTransaction().apply {
				replace(R.id.fragmentContainerView, LoginFragment())
				commit()
			}
		}
	}
	
	private fun register() {
		session.createSession(
			binding.nameET.text.toString(),
			binding.phoneNumberET.text.toString(),
			binding.emailET.text.toString(),
		)
	}
	
	
}