package com.music.app.modules.settings.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.music.app.modules.settings.`data`.model.EqualizerRowModel
import com.music.app.modules.settings.`data`.model.SettingsModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class SettingsVM : ViewModel(), KoinComponent {
  val settingsModel: MutableLiveData<SettingsModel> = MutableLiveData(SettingsModel())

  var navArguments: Bundle? = null

  val equalizerList: MutableLiveData<MutableList<EqualizerRowModel>> =
      MutableLiveData(mutableListOf())
}
