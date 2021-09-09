package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        setHasOptionsMenu(true)

        viewModel.shoeList.observe(viewLifecycleOwner, Observer {
            val iterator = it.listIterator()
            for (item in iterator) {
                val name = TextView(this.context)
                name.text = item.name

                val size = TextView(this.context)
                size.text = item.size

                val company = TextView(this.context)
                company.text = item.company

                val description = TextView(this.context)
                description.text = item.description

                val parentLayout = LinearLayout(requireContext())
                val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
                )
                params.setMargins(5, 0, 5, 25)

                parentLayout.apply {
                    orientation = LinearLayout.VERTICAL
                    setBackgroundColor(
                        ContextCompat.getColor(
                            requireContext(),
                            android.R.color.darker_gray
                        )
                    )
                    name.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.colorPrimaryDark
                        )
                    )
                    size.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.colorPrimaryDark
                        )
                    )
                    company.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.colorPrimaryDark
                        )
                    )
                    description.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.colorPrimaryDark
                        )
                    )
                    setPadding(16, 8, 16, 8)
                    addView(name)
                    addView(size)
                    addView(company)
                    addView(description)
                }

                binding.shoeListView.addView(parentLayout, params)
            }
        })

        binding.createShoeButton.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(ShoeListFragmentDirections.actionShoeListFragmentToCreateShoeFragment())
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}
