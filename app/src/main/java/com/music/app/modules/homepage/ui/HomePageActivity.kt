package com.music.app.modules.homepage.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.music.app.R
import com.music.app.appcomponents.base.BaseActivity
import com.music.app.databinding.ActivityHomePageBinding
import com.music.app.modules.favorites.ui.FavoritesActivity
import com.music.app.modules.homepage.`data`.model.NewreleaseslistRowModel
import com.music.app.modules.homepage.`data`.viewmodel.HomePageVM
import com.music.app.modules.playlist.ui.PlaylistBottomsheet
import com.music.app.modules.topplaylists.ui.TopPlaylistsActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class HomePageActivity : BaseActivity<ActivityHomePageBinding>(R.layout.activity_home_page) {
  private val viewModel: HomePageVM by viewModels<HomePageVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val newReleasesListAdapter =
    NewReleasesListAdapter(viewModel.newReleasesListList.value?:mutableListOf())
    binding.recyclerNewReleasesList.adapter = newReleasesListAdapter
    newReleasesListAdapter.setOnItemClickListener(
    object : NewReleasesListAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : NewreleaseslistRowModel) {
        onClickRecyclerNewReleasesList(view, position, item)
      }
    }
    )
    viewModel.newReleasesListList.observe(this) {
      newReleasesListAdapter.updateData(it)
    }
    binding.homePageVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.txtViewAll.setOnClickListener {
      val destFragment = PlaylistBottomsheet.getInstance(null)
      destFragment.show(this.supportFragmentManager, PlaylistBottomsheet.TAG)
    }
    binding.linearFavorites.setOnClickListener {
      val destIntent = FavoritesActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearHome.setOnClickListener {
      // TODO please, add your navigation code here
    }
    binding.linearTop.setOnClickListener {
      val destIntent = TopPlaylistsActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  fun onClickRecyclerNewReleasesList(
    view: View,
    position: Int,
    item: NewreleaseslistRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "HOME_PAGE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, HomePageActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
