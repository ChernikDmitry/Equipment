package com.example.equipment.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.equipment.R
import com.example.equipment.domain.ShopItem

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.shopList.observe(this) {
            Log.e("MainActivityTest", it.toString())
//        if (count==0) {
//            count++
//            val item = it[0]
//            viewModel.changeEnableState(item)
//        }
        }
//            viewModel.changeEnableState(ShopItem("Name 2",1,true,2))
//            viewModel.deleteShopItem(ShopItem("Name 3",1,true,3))

    }
}