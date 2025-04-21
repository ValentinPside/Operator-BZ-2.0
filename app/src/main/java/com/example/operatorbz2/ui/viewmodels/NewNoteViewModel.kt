package com.example.operatorbz2.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.operatorbz2.domain.Note
import com.example.operatorbz2.domain.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class NewNoteViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val state = MutableStateFlow(NewNoteState())
    fun observeUi() = state.asStateFlow()

    suspend fun saveNewNote(name: String, text: String){
        val note = Note(0, name, text)
        repository.createNewNote(note)
    }
}


data class NewNoteState(
    val text: String = "",
)