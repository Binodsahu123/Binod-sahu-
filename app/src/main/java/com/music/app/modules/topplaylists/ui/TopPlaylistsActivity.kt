package com.music.app.modules.topplaylists.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.music.app.R
import com.music.app.appcomponents.base.BaseActivity
import com.music.app.databinding.ActivityTopPlaylistsBinding
import com.music.app.modules.list.ui.ListActivity
import com.music.app.modules.topplaylists.`data`.model.TopplaylistRowModel
import com.music.app.modules.topplaylists.`data`.viewmodel.TopPlaylistsVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class TopPlaylistsActivity :
    BaseActivity<ActivityTopPlaylistsBinding>(R.layout.activity_top_playlists) {
  private val viewModel: TopPlaylistsVM by viewModels<TopPlaylistsVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val topPlaylistAdapter =
    TopPlaylistAdapter(viewModel.topPlaylistList.value?:mutableListOf())
    binding.recyclerTopPlaylist.adapter = topPlaylistAdapter
    topPlaylistAdapter.setOnItemClickListener(
    object : TopPlaylistAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : TopplaylistRowModel) {
        onClickRecyclerTopPlaylist(view, position, item)
      }
    }
    )
    viewModel.topPlaylistList.observe(this) {
      topPlaylistAdapter.updateData(it)
    }
    binding.topPlaylistsVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowLeft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerTopPlaylist(
    view: View,
    position: Int,
    item: TopplaylistRowModel
  ): Unit {
    when(view.id) {
      R.id.imageRenaissance1 ->  {
        val destIntent = ListActivity.getIntent(this, null)
        startActivity(destIntent)
      }
    }
  }

  companion object {
    const val TAG: String = "TOP_PLAYLISTS_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, TopPlaylistsActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
