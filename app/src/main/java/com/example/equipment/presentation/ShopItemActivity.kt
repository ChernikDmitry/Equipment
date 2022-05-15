package com.example.equipment.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.equipment.R

class ShopItemActivity: AppCompatActivity() {
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_item)
    }
}