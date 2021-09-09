package com.udacity.shoestore.screens

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    val shoeList = MutableLiveData<MutableList<Shoe>>()

    init {
        shoeList.value = ArrayList()
        addDefaultData()
    }

    fun addShoe(name: String, size: String, company: String, description: String) {
        val shoe = Shoe(name, size, company, description)
        shoeList.value?.add(shoe)
        shoeList.value = shoeList.value
    }

    private fun addDefaultData() {
        addShoe("Skate-Hi", "10.5", "Vans", "World's #1 skateboarding shoes")
        addShoe("Continentals", "11", "Adidas", "Running shoes")
    }
}
