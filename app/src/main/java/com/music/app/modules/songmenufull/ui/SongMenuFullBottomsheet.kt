package com.music.app.modules.songmenufull.ui

import android.view.View
import androidx.fragment.app.viewModels
import com.music.app.R
import com.music.app.appcomponents.base.BaseBottomsheetDialogFragment
import com.music.app.databinding.BottomsheetSongMenuFullBinding
import com.music.app.modules.songmenufull.`data`.model.OptionsRowModel
import com.music.app.modules.songmenufull.`data`.viewmodel.SongMenuFullVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class SongMenuFullBottomsheet :
    BaseBottomsheetDialogFragment<BottomsheetSongMenuFullBinding>(R.layout.bottomsheet_song_menu_full)
    {
  private val viewModel: SongMenuFullVM by viewModels<SongMenuFullVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = arguments
    val optionsAdapter = OptionsAdapter(viewModel.optionsList.value?:mutableListOf())
    binding.recyclerOptions.adapter = optionsAdapter
    optionsAdapter.setOnItemClickListener(
    object : OptionsAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : OptionsRowModel) {
        onClickRecyclerOptions(view, position, item)
      }
    }
    )
    viewModel.optionsList.observe(requireActivity()) {
      optionsAdapter.updateData(it)
    }
    binding.songMenuFullVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  fun onClickRecyclerOptions(
    view: View,
    position: Int,
    item: OptionsRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "SONG_MENU_FULL_BOTTOMSHEET"

  }
}
