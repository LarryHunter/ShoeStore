package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeScreenBinding

class WelcomeScreenFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_welcome_screen, container, false)

        binding.welcomeGoButton.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(WelcomeScreenFragmentDirections.actionWelcomeScreenFragmentToInstructionsFragment())
        }

        return binding.root
    }
}
