package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentCreateShoeBinding
import kotlinx.android.synthetic.main.fragment_create_shoe.*

class CreateShoeFragment : Fragment() {

    private lateinit var binding: FragmentCreateShoeBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_shoe, container, false)

        binding.saveButton.setOnClickListener {
            viewModel.addShoe(
                nameBox.text.toString(),
                sizeBox.text.toString(),
                companyBox.text.toString(),
                descriptionBox.text.toString()
            )
            NavHostFragment.findNavController(this)
                .navigate(CreateShoeFragmentDirections.actionCreateShoeFragmentToShoeListFragment())
        }

        binding.cancelButton.setOnClickListener {
            binding.nameBox.text.clear()
            binding.sizeBox.text.clear()
            binding.companyBox.text.clear()
            binding.descriptionBox.text.clear()

            NavHostFragment.findNavController(this)
                .navigate(CreateShoeFragmentDirections.actionCreateShoeFragmentToShoeListFragment())
        }

        return binding.root
    }
}
