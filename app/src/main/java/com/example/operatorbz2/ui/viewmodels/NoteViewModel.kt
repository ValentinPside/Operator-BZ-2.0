package com.example.operatorbz2.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.operatorbz2.domain.Note
import com.example.operatorbz2.domain.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class NoteViewModel @Inject
constructor(
    private val repository: Repository
) : ViewModel() {

    private val state = MutableStateFlow(ViewStateNote())
    fun observeUi() = state.asStateFlow()

    fun getNote(id: Int) {
        viewModelScope.launch {
            val note = repository.getNote(id)
            state.update {
                it.copy(note = note)
            }
        }
    }
}

data class ViewStateNote(
    val note: Note? = null
)