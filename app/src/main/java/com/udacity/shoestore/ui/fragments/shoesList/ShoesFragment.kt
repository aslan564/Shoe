package com.udacity.shoestore.ui.fragments.shoesList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.udacity.shoestore.databinding.FragmentShoesBinding


class ShoesFragment : Fragment() {

    private val binding by lazy { FragmentShoesBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindUI()
        observeShoesList()
    }

    private fun observeShoesList() {

    }

    private fun bindUI() {

    }

    companion object {

    }
}