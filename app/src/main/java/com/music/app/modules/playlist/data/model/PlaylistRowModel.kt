package com.music.app.modules.playlist.`data`.model

import com.music.app.R
import com.music.app.appcomponents.di.MyApp
import kotlin.String

data class PlaylistRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtRenaissance: String? = MyApp.getInstance().resources.getString(R.string.lbl_flashbacks)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPodvalCaplella: String? = MyApp.getInstance().resources.getString(R.string.lbl_emika)

)
