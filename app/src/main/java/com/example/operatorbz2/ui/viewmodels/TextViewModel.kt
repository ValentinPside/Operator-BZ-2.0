package com.example.operatorbz2.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.operatorbz2.R
import com.example.operatorbz2.domain.Item
import com.example.operatorbz2.domain.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class TextViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val state = MutableStateFlow(ViewStateText())
    fun observeUi() = state.asStateFlow()

    fun getItem(id: String) {
        if (id.contains("A")) {
            val index = id.trim('A').toInt()
            val newItem = repository.getFirstList()[index]
            state.update {
                it.copy(item = newItem)
            }
        } else {
            val index = id.trim('B').toInt()
            val newItem = repository.getSecondList()[index]
            state.update {
                it.copy(item = newItem)
            }
        }
    }
}


data class ViewStateText(
    val item: Item = Item("", R.string.string_holder, 0, R.string.string_holder)
)