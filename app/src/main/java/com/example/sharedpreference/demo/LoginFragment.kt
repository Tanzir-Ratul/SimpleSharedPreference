package com.example.sharedpreference.demo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.sharedpreference.R
import com.example.sharedpreference.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
	private lateinit var binding: FragmentLoginBinding
	private lateinit var session: SessionManager
	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		return FragmentLoginBinding.inflate(inflater).apply {
			lifecycleOwner = viewLifecycleOwner
			binding = this
		}.root
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		session = SessionManager(requireContext())
		onClick()
	}
	
	private fun onClick() {
		binding.notRegBtn.setOnClickListener {
			if (session.getSessionDetails(SessionManager.EMAIL).isNullOrEmpty())
				parentFragmentManager.beginTransaction().apply {
					replace(R.id.fragmentContainerView, RegisterFragment())
					commit()
				}
		}
		binding.login.setOnClickListener {
			if(binding.emailET.text.toString() == "r@r.com" &&
				binding.passwordET.text.toString() == "123") {
				session.createSession("ratul", "01700000000", "r@r.com")
				parentFragmentManager.beginTransaction().apply {
					replace(R.id.fragmentContainerView, ProfileFragment())
					commit()
				}
			}else
			{
				Toast.makeText(requireContext(), "Wrong email or password", Toast.LENGTH_SHORT).show()
			}
		}
	}
	
}