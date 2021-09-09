package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.signInButton.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeScreenFragment())
        }

        binding.signUpText.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToWelcomeScreenFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }

        return binding.root
    }
}
