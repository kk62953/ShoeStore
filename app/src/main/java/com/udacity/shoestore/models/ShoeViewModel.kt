package com.udacity.shoestore.models


import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.BR


class ShoeViewModel: ViewModel(),Observable{
    private val propertyChangeRegistry = PropertyChangeRegistry()

    private val shoesList = MutableLiveData<MutableList<Shoe>>(mutableListOf())

    @Bindable
    var shoe = Shoe()
        set(value) {
            if(value != field) {
                field = value
                propertyChangeRegistry.notifyChange(this, BR.shoe)
            }
        }

    fun getShoeLiveData(): LiveData<MutableList<Shoe>> = shoesList

    fun addShoe(item: Shoe?) {
        item?.let {
            shoesList.value?.add(item)
        }
    }


    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.remove(callback)
    }
}







