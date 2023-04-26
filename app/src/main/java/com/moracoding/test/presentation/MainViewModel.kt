package com.moracoding.test.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moracoding.test.domain.entities.ProductEntity
import com.moracoding.test.domain.usecases.product.GetProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getProductUseCase: GetProductUseCase
): ViewModel(){
    private val _products = MutableLiveData(emptyList<ProductEntity>())
    val products: LiveData<List<ProductEntity>> = _products

    fun getProducts() = viewModelScope.launch(Main){
        getProductUseCase().fold({products->
            _products.setValue(products)
        }, onFailure = {
            Log.e("Error", it.message.toString())
        })
    }
}