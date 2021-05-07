package com.udacity.shoestore.ui.fragments.instruction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentInstructionBinding


class InstructionFragment : Fragment() {

    private val binding by lazy { FragmentInstructionBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View=binding.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindUI()
    }
    private fun bindUI(): Unit = with(binding) {
        lifecycleOwner = this@InstructionFragment
        buttonNext.setOnClickListener {
            val action= InstructionFragmentDirections.actionFragmentDetailsToFragmentShoeList()
            it.findNavController().navigate(action)
        }

    }
}