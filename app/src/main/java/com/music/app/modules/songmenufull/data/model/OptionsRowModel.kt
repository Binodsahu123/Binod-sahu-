package com.music.app.modules.songmenufull.`data`.model

import com.music.app.R
import com.music.app.appcomponents.di.MyApp
import kotlin.String

data class OptionsRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtAddToPlaylist: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_add_to_playlist)

)
