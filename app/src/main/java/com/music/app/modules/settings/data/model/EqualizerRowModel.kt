package com.music.app.modules.settings.`data`.model

import com.music.app.R
import com.music.app.appcomponents.di.MyApp
import kotlin.String

data class EqualizerRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtDBCounter: String? = MyApp.getInstance().resources.getString(R.string.lbl_4_db)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHzCounter: String? = MyApp.getInstance().resources.getString(R.string.lbl_100_hz)

)
