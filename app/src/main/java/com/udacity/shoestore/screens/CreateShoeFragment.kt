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
import com.udacity.shoestore.models.Shoe

class CreateShoeFragment : Fragment() {

    private lateinit var binding: FragmentCreateShoeBinding
    private val viewModel: ShoeListViewModel by activityViewModels()
    private val shoe: Shoe = Shoe(name = "", size = "", company = "", description = "")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_shoe, container, false)

        binding.shoe = shoe

        binding.saveButton.setOnClickListener { _ ->
            binding.shoe?.let { it ->
                viewModel.addShoe(
                    it.name,
                    it.size,
                    it.company,
                    it.description
                )
            }
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
