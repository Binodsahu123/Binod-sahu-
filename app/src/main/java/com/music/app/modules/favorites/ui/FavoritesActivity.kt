package com.music.app.modules.favorites.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.music.app.R
import com.music.app.appcomponents.base.BaseActivity
import com.music.app.databinding.ActivityFavoritesBinding
import com.music.app.modules.artists.ui.ArtistsActivity
import com.music.app.modules.favorites.`data`.model.FavoritesRowModel
import com.music.app.modules.favorites.`data`.viewmodel.FavoritesVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class FavoritesActivity : BaseActivity<ActivityFavoritesBinding>(R.layout.activity_favorites) {
  private val viewModel: FavoritesVM by viewModels<FavoritesVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val favoritesAdapter = FavoritesAdapter(viewModel.favoritesList.value?:mutableListOf())
    binding.recyclerFavorites.adapter = favoritesAdapter
    favoritesAdapter.setOnItemClickListener(
    object : FavoritesAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : FavoritesRowModel) {
        onClickRecyclerFavorites(view, position, item)
      }
    }
    )
    viewModel.favoritesList.observe(this) {
      favoritesAdapter.updateData(it)
    }
    binding.favoritesVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowLeft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerFavorites(
    view: View,
    position: Int,
    item: FavoritesRowModel
  ): Unit {
    when(view.id) {
      R.id.linearFavouritesOption -> {
        val destIntent = ArtistsActivity.getIntent(this, null)
        startActivity(destIntent)
      }
    }
  }

  companion object {
    const val TAG: String = "FAVORITES_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, FavoritesActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
