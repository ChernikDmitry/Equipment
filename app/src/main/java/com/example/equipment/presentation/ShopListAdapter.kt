package com.example.equipment.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.equipment.R
import com.example.equipment.domain.ShopItem

class ShopListAdapter : RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {
    var count = 0
    var shopList = listOf<ShopItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var onShopItemLongClickListener:((ShopItem)->Unit)? = null
    var onShopItemClickListener:((ShopItem)->Unit)? = null
    var onShopItemSwipeListener: ((ShopItem)->Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        Log.d("ShopListAdapter", "onCreateViewHolder, count: ${++count}")
        val layout = when (viewType){
            VIEW_TYPE_ENABLED->R.layout.item_shop_enabled
            VIEW_TYPE_DISABLED->R.layout.item_shop_disabled
            else->throw RuntimeException("Unknown view type: $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(
            layout,
            parent,
            false
        )
        return ShopItemViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ShopItemViewHolder, position: Int) {
        val shopItem = shopList[position]
        viewHolder.tvName.text = shopItem.name
        viewHolder.tvCount.text = shopItem.count.toString()
        viewHolder.view.setOnLongClickListener {
            onShopItemLongClickListener?.invoke(shopItem)
            true
        }
        viewHolder.view.setOnClickListener {
            onShopItemClickListener?.invoke(shopItem)
            true
        }
    }

//    override fun onViewRecycled(viewHolder: ShopItemViewHolder) {
//        super.onViewRecycled(viewHolder)
//        viewHolder.tvName.setTextColor(ContextCompat.getColor(viewHolder.view.context,android.R.color.white))
//    }

    override fun getItemCount(): Int {
        return shopList.size
    }

    override fun getItemViewType(position: Int): Int {
        val item = shopList[position]
        return if (item.enabled) {
            VIEW_TYPE_ENABLED
        } else {
            VIEW_TYPE_DISABLED
        }
    }

    class ShopItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tvName = view.findViewById<TextView>(R.id.tv_name)
        val tvCount = view.findViewById<TextView>(R.id.tv_count)
    }

//    interface OnShopItemLongClickListener{
//        fun onShopItemLongClick(shopItem: ShopItem)
//    }


    companion object{
        const val VIEW_TYPE_ENABLED =1
        const val VIEW_TYPE_DISABLED = 0
        const val MAX_POOL_SIZE = 15
    }
}