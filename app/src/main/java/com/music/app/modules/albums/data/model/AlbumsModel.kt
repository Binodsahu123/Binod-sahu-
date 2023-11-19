package com.music.app.modules.albums.`data`.model

import com.music.app.R
import com.music.app.appcomponents.di.MyApp
import kotlin.String

data class AlbumsModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtTransfer: String? = MyApp.getInstance().resources.getString(R.string.lbl_albums)

)
