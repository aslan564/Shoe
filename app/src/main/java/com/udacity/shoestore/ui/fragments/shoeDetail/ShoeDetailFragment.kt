package com.udacity.shoestore.ui.fragments.shoeDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailShoeBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewModel.fragment.ShoeViewModel

class ShoeDetailFragment : Fragment() {

    private val binding by lazy { FragmentDetailShoeBinding.inflate(layoutInflater) }
    private val viewModel by activityViewModels<ShoeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(false)
        bindUI()
    }

    private fun bindUI(): Unit = with(binding) {
        lifecycleOwner = this@ShoeDetailFragment
        cancelButton.setOnClickListener {
            val navController = it.findNavController()

            if (!navController.popBackStack()) {
                // Call finish() or popBackStack() on your Activity or fragment
                navController.popBackStack()
            }


        }
        saveButton.setOnClickListener {

            val name = etShoeName.text.toString()
            val size = etShoeSize.text.toString()
            val company = etShoeCompany.text.toString()
            val desc = etShoeDesc.text.toString()
            val imageList =
                listOf("dasfsdffdsaf", "dasfsdffdsaf", "dasfsdffdsaf", "dasfsdffdsaf")
            println("bindUI: $name")
            when ("") {
                name -> {
                    etShoeName.error = "Required"
                }
                company -> {
                    etShoeCompany.error = "Required"
                }
                desc -> {
                    etShoeDesc.error = "Required"
                }
                size -> {
                    etShoeSize.error = "Required"
                }
                else -> {
                    val navController = this@ShoeDetailFragment.findNavController()
                    val shoe = Shoe(name, size.toDouble(), company, desc, imageList)
                    viewModel.addShoeList(shoe, true)
                    if (!navController.popBackStack()) {
                        // Call finish() or popBackStack() on your Activity or fragment
                        navController.popBackStack()
                    }
                }
            }
        }
    }

}