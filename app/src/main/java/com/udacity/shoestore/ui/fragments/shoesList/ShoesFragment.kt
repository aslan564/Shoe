package com.udacity.shoestore.ui.fragments.shoesList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesBinding
import com.udacity.shoestore.viewModel.fragment.ShoeViewModel


class ShoesFragment : Fragment() {

    private val binding by lazy { FragmentShoesBinding.inflate(layoutInflater) }
    private lateinit var viewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this@ShoesFragment).get(ShoeViewModel::class.java)


        bindUI()
        observeShoesList()
    }

    private fun observeShoesList(): Unit = with(viewModel) {
        arguments?.let {
            val shoe = ShoesFragmentArgs.fromBundle(it).shoeItem
            shoe?.let {
                addShoeList(shoe)
            }
        }
        shoeList.observe(viewLifecycleOwner, Observer {
            it?.let { shoeList ->
                for (item in shoeList) {
                    val textViewName: TextView =
                        View.inflate(requireContext(), R.layout.text_view_name, null) as TextView
                    val textViewDesc: TextView =
                        View.inflate(requireContext(), R.layout.text_view_desc, null) as TextView

                    textViewName.text = item.name
                    textViewDesc.text = item.description
                    binding.linearLayout.addView(textViewName)
                    binding.linearLayout.addView(textViewDesc)

                }

            }
        })
    }


    private fun bindUI(): Unit = with(binding) {
        lifecycleOwner = this@ShoesFragment


        fab.setOnClickListener {
            val action = R.id.action_to_fragment_shoe_details
            it.findNavController().navigate(action)
        }
    }
}

