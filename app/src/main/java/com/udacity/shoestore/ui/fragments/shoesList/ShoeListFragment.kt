package com.udacity.shoestore.ui.fragments.shoesList

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesBinding
import com.udacity.shoestore.databinding.ItemShoeLayoutBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewModel.fragment.ShoeViewModel
import timber.log.Timber


class ShoeListFragment : Fragment() {


    private val binding by lazy { FragmentShoesBinding.inflate(layoutInflater) }
    private  val viewModel by viewModels<ShoeViewModel> ()
    private val newShoeList:ArrayList<Shoe> = arrayListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        println("onCreateView:")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        bindUI()
        observeShoesList()
        println("onViewCreated: ")
    }

    override fun onStart() {
        super.onStart()
        println("onStart")
    }

    private fun observeShoesList(): Unit = with(viewModel) {
        getShoeList()

        arguments?.let {
            val shoe = ShoeListFragmentArgs.fromBundle(it).shoeItem
            shoe?.let {
                addViewItem(shoe)
            }
        }
        shoeList.observe(viewLifecycleOwner, {
            it?.let { shoeList ->
               // newShoeList.addAll(shoeList)
                for (item in shoeList) {
                    addViewItem(item)
                }
            }
        })
    }

    private fun addViewItem(item: Shoe) {
        newShoeList.add(item)
        for (newItem in newShoeList) {
            val inflater = layoutInflater
            val view = ItemShoeLayoutBinding.inflate(inflater)

            view.shoe = newItem
            binding.linearLayout.addView(view.root)
        }

    }


    private fun bindUI(): Unit = with(binding) {
        lifecycleOwner = this@ShoeListFragment
        viewModelBinding = this@ShoeListFragment.viewModel

        fab.setOnClickListener {
            val action = ShoeListFragmentDirections.actionToFragmentShoeDetails()
            it.findNavController().navigate(action)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.shop_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.nav_logout -> {
                val action = ShoeListFragmentDirections.actionFragmentShoeListToLoginFragment()
                requireView().findNavController().navigate(action)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }


}

