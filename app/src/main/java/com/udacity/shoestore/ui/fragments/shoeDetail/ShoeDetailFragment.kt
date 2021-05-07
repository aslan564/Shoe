package com.udacity.shoestore.ui.fragments.shoeDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentDetailShoeBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewModel.fragment.ShoeViewModel

class ShoeDetailFragment : Fragment() {

    private val binding by lazy { FragmentDetailShoeBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindUI()
    }

    private fun bindUI(): Unit = with(binding) {
        cancelButton.setOnClickListener {
            it.findNavController().popBackStack()
        }
        saveButton.setOnClickListener {

            val name = etShoeName.text.toString()
            val size = etShoeSize.text.toString()
            val company = etShoeCompany.text.toString()
            val desc = etShoeDesc.text.toString()
            val imageList =
                listOf<String>("dasfsdffdsaf", "dasfsdffdsaf", "dasfsdffdsaf", "dasfsdffdsaf")

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
                    val shoe = Shoe(name, size.toDouble(), company, desc, imageList)
                    it.findNavController().navigate(
                        ShoeDetailFragmentDirections.actionFragmentShoeDetailsToFragmentShoeList(
                            shoe
                        )
                    )
                }
            }
        }
    }
}