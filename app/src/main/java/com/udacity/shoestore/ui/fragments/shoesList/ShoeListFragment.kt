package com.udacity.shoestore.ui.fragments.shoesList

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesBinding
import com.udacity.shoestore.databinding.ItemShoeLayoutBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewModel.fragment.ShoeViewModel


class ShoeListFragment : Fragment() {

    private val binding by lazy { FragmentShoesBinding.inflate(layoutInflater) }
    private val viewModel by activityViewModels<ShoeViewModel>()

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


    private fun bindUI(): Unit = with(binding) {
        lifecycleOwner = this@ShoeListFragment
        viewModelBinding = this@ShoeListFragment.viewModel


        fab.setOnClickListener {
            val action = ShoeListFragmentDirections.actionToFragmentShoeDetails()
            it.findNavController().navigate(action)
        }
    }

    private fun observeShoesList(): Unit = with(viewModel) {
        shoeList.observe(viewLifecycleOwner, {
            it?.let { shoeItem ->
                for (item in shoeItem) {
                    val inflater = layoutInflater
                    val view = ItemShoeLayoutBinding.inflate(inflater)
                    view.shoe = item
                    binding.linearLayout.addView(view.root)
                }
            }
        })
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

