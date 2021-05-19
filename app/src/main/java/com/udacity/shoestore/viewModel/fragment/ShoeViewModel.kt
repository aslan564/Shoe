package com.udacity.shoestore.viewModel.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList


    fun addShoeList(shoeItem: Shoe?, added: Boolean) {
        val mutableList= mutableListOf<Shoe>()
        if (added && shoeItem != null) {
            mutableList.add(shoeItem)
            _shoeList.postValue(mutableList)
        }
    }
}