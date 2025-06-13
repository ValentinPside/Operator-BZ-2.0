package com.example.operatorbz2.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.operatorbz2.R
import com.example.operatorbz2.app.App
import com.example.operatorbz2.ui.viewmodels.GeneralViewModel
import com.example.operatorbz2.utils.Factory
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabScreen(
    navController: NavHostController,
    viewModel: GeneralViewModel = viewModel(factory = Factory {
        App.appComponent.generalComponent().viewModel()
    })
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val itemListState by viewModel.observeUi().collectAsStateWithLifecycle()
    val composableScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.top_name)) },
                actions = {
                    IconButton(onClick = {
                        navController.navigate("new_note_screen")
                    }) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }
                })
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding())
        ) {
            TabRow(
                modifier = Modifier.fillMaxWidth(),
                selectedTabIndex = selectedTabIndex,
            ) {
                Tab(
                    selected = selectedTabIndex == 0,
                    onClick = { selectedTabIndex = 0 },
                    text = { Text("Химия") }
                )
                Tab(
                    selected = selectedTabIndex == 1,
                    onClick = { selectedTabIndex = 1 },
                    text = { Text("Техника") }
                )
                Tab(
                    selected = selectedTabIndex == 2,
                    onClick = { selectedTabIndex = 2 },
                    text = { Text("Заметки") }
                )
            }

            when (selectedTabIndex) {
                0 -> LazyColumn {
                    viewModel.setFirstList()
                    val items = itemListState.items
                    items(items.size) { index ->
                        val item = items[index]
                        ListItem(item,
                            onClick = {
                                navController.navigate("text_screen/${item.id}")
                            })
                    }
                    item {
                        Spacer(modifier = Modifier.height(40.dp))
                    }
                }

                1 -> LazyColumn {
                    viewModel.setSecondList()
                    val items = itemListState.items
                    items(items.size) { index ->
                        val item = items[index]
                        ListItem(item,
                            onClick = {
                                navController.navigate("text_screen/${item.id}")
                            })
                    }
                    item {
                        Spacer(modifier = Modifier.height(40.dp))
                    }
                }

                2 -> LazyColumn {
                    composableScope.launch {
                        viewModel.setThirdList()
                    }
                    val notes = itemListState.notes
                    items(notes.size) { index ->
                        val note = notes[index]
                        NoteItem(note,
                            onClickDelete = {
                                composableScope.launch {
                                    viewModel.deleteNote(note)
                                }
                            },
                            onClick = {
                                navController.navigate("note_screen/${note.id}")
                            })
                    }
                    item {
                        Spacer(modifier = Modifier.height(40.dp))
                    }
                }
            }
        }
    }
}