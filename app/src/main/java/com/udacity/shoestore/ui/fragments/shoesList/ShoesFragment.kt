package com.udacity.shoestore.ui.fragments.shoesList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.databinding.FragmentShoesBinding
import com.udacity.shoestore.ui.fragments.shoesList.adapter.ShoeAdapter
import com.udacity.shoestore.viewModel.fragment.ShoeViewModel


class ShoesFragment : Fragment() {

    private val binding by lazy { FragmentShoesBinding.inflate(layoutInflater) }
    private lateinit var viewModel: ShoeViewModel
    private lateinit var adapter: ShoeAdapter

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

        shoeList.observe(viewLifecycleOwner, Observer {
            it?.let { shoeList ->
                adapter = ShoeAdapter(shoeList = shoeList)
                binding.recyclerView.adapter = adapter
            }
        })

    }

    private fun bindUI(): Unit = with(binding) {
        lifecycleOwner = this@ShoesFragment
    }
}

