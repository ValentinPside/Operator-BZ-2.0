package com.example.operatorbz2.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.operatorbz2.domain.Item
import com.example.operatorbz2.domain.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class NewNoteViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val state = MutableStateFlow(NewNoteState())
    fun observeUi() = state.asStateFlow()

    fun saveNewNote(text: String){


    }
}


data class NewNoteState(
    val text: String = "",
)