package com.example.operatorbz2.ui.theme.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.operatorbz2.R
import com.example.operatorbz2.app.App
import com.example.operatorbz2.ui.theme.OperatorBZ2Theme
import com.example.operatorbz2.ui.theme.viewmodels.GeneralViewModel
import com.example.operatorbz2.utils.Factory


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabScreen(
    viewModel: GeneralViewModel = viewModel(factory = Factory {
        App.appComponent.generalComponent().viewModel()
    })
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val itemListState by viewModel.observeUi().collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = stringResource(R.string.top_name)) }) }
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
                    text = { Text("Хим.растворы") }
                )
                Tab(
                    selected = selectedTabIndex == 1,
                    onClick = { selectedTabIndex = 1 },
                    text = { Text("Тех.операции") }
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
                        ListItem(item)
                    }
                }

                1 -> LazyColumn {
                    viewModel.setSecondList()
                    val items = itemListState.items
                    items(items.size) { index ->
                        val item = items[index]
                        ListItem(item)
                    }
                }
            }
        }
    }
}