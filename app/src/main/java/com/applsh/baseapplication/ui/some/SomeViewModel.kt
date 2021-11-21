package com.applsh.baseapplication.ui.some

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class SomeViewModel @Inject constructor(

) : ViewModel() {

    val flow = MutableStateFlow<String?>(null)


}