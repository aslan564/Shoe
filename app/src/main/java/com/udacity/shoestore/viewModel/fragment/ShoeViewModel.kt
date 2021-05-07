package com.udacity.shoestore.viewModel.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    private val shoeMutableList= mutableListOf<Shoe>()


    init {
        getShoeList()
    }
    private fun getShoeList() {
        repeat(5) {
           if (it % 2 == 0) {
               val shoe=  Shoe("test$it",3.1*it,"My $it Company","$it version shoes", mutableListOf("asgdkjsd","hjagsdjkgasgdk","jkgasdghkjahsgdjkg"))
                shoeMutableList.add(shoe)
            }else{
               val shoe=  Shoe("test$it",3.1*it,"My $it Company","$it version shoes", mutableListOf("asgdkjsd","hjagsdjkgasgdk","jkgasdghkjahsgdjkg"))
               shoeMutableList.add(shoe)
            }
            _shoeList.postValue(shoeMutableList)
        }

    }

    fun addShoeList(shoeItem: Shoe) {
        shoeMutableList.add(shoeItem)
    }
}