package com.moracoding.test.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import coil.load
import com.moracoding.test.data.models.ProductsDto
import com.moracoding.test.databinding.ActivityMainBinding
import com.moracoding.test.domain.entities.ProductEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    private var listProducts = emptyList<ProductEntity>()
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.getProducts()
        setupObservers()
    }

    private fun setupObservers() = with(mainViewModel){
        products.observe(this@MainActivity){ products ->
            listProducts = products
            if(products.isNotEmpty()) updateView(listProducts[index])
        }
    }

    private fun updateView(product: ProductEntity) {
        binding.apply {
            btnPrevious.text = "Previous"
            btnNext.text = "Next"
            btnPrevious.visibility = if (index == 0)  View.GONE else View.VISIBLE
            tvTitle.text = product.title
            tvRating.text = "Rating: ${product.rating}"
            ivProduct.load(product.thumbnail)
            tvPrice.text = "Price: $ ${product.price}"
            tvStock.text = "Stock: ${product.stock}"
            tvDiscount.text = "Discount: ${product.discountPercentage} %"
            tvBrand.text = "Brand: ${product.brand}"
            tvCategory.text = "Category: ${product.category}"
            tvDescription.text = product.description
            btnPrevious.setOnClickListener {
                index--
                updateView(listProducts[index])
            }
            btnNext.setOnClickListener {
                index++
                if (index==listProducts.size) index=0
                updateView(listProducts[index])
            }
        }
    }
}