package com.udacity.shoestore.viewModel.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    private val shoeMutableList= mutableListOf<Shoe>()




    fun addShoeList(shoeItem: Shoe) {
        shoeMutableList.add(shoeItem)
        _shoeList.postValue(shoeMutableList)
    }
}