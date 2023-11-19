package com.music.app.modules.favorites.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.music.app.R
import com.music.app.databinding.RowFavoritesBinding
import com.music.app.modules.favorites.`data`.model.FavoritesRowModel
import kotlin.Int
import kotlin.collections.List

class FavoritesAdapter(
  var list: List<FavoritesRowModel>
) : RecyclerView.Adapter<FavoritesAdapter.RowFavoritesVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowFavoritesVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_favorites,parent,false)
    return RowFavoritesVH(view)
  }

  override fun onBindViewHolder(holder: RowFavoritesVH, position: Int) {
    val favoritesRowModel = FavoritesRowModel()
    // TODO uncomment following line after integration with data source
    // val favoritesRowModel = list[position]
    holder.binding.favoritesRowModel = favoritesRowModel
  }

  override fun getItemCount(): Int = 5
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<FavoritesRowModel>) {
    list = newData
    notifyDataSetChanged()
  }

  fun setOnItemClickListener(clickListener: OnItemClickListener) {
    this.clickListener = clickListener
  }

  interface OnItemClickListener {
    fun onItemClick(
      view: View,
      position: Int,
      item: FavoritesRowModel
    ) {
    }
  }

  inner class RowFavoritesVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowFavoritesBinding = RowFavoritesBinding.bind(itemView)
    init {
      binding.linearFavouritesOption.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, FavoritesRowModel())
      }
    }
  }
}
