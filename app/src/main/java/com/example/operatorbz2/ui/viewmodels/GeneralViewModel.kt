package com.example.operatorbz2.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.operatorbz2.domain.Item
import com.example.operatorbz2.domain.Note
import com.example.operatorbz2.domain.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class GeneralViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val state = MutableStateFlow(ViewState())
    fun observeUi() = state.asStateFlow()

    fun setFirstList() {
        val list = repository.getFirstList()
        state.update {
            it.copy(items = list)
        }
    }

    fun setSecondList() {
        val list = repository.getSecondList()
        state.update {
            it.copy(items = list)
        }
    }

    suspend fun setThirdList() {
        val list = repository.getAllNotes()
        state.update {
            it.copy(notes = list)
        }
    }

    suspend fun deleteNote(note: Note) {
        repository.deleteNote(note)
        val list = repository.getAllNotes()
        state.update {
            it.copy(notes = list)
        }
    }
}


data class ViewState(
    val items: List<Item> = emptyList(),
    val notes: List<Note> = emptyList()
)