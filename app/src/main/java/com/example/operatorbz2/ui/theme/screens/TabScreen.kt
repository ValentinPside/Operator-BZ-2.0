package com.example.operatorbz2.ui.theme.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.operatorbz2.app.App
import com.example.operatorbz2.ui.theme.viewmodels.GeneralViewModel
import com.example.operatorbz2.utils.Factory
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TabScreen(
    viewModel: GeneralViewModel = viewModel(factory = Factory {
        App.appComponent.generalComponent().viewModel()
    })
) {
    val scope = rememberCoroutineScope()
    val pageState = rememberPagerState(pageCount = { 3 })
    val selectedTabIndex = remember { derivedStateOf { pageState.currentPage } }
    val itemList = viewModel.observeUi().value.items
    viewModel.setFirstList()

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Home") }) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding())
        ) {
            TabRow(
                selectedTabIndex = selectedTabIndex.value,
                modifier = Modifier.fillMaxWidth()
            ) {
                HomeTabs.entries.forEachIndexed { index, currentTab ->
                    Tab(
                        selected = selectedTabIndex.value == index,
                        selectedContentColor = MaterialTheme.colorScheme.primary,
                        unselectedContentColor = MaterialTheme.colorScheme.outline,
                        onClick = {
                            scope.launch {
                                pageState.animateScrollToPage(currentTab.ordinal)
                            }
                        },
                        text = { Text(text = currentTab.text) }
                    )
                }
            }
            when (selectedTabIndex.value) {
                0 -> viewModel.setFirstList()
                1 -> viewModel.setSecondList()
            }
        }
        HorizontalPager(
            state = pageState,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                itemsIndexed(itemList) { _, item ->
                    ListItem(item)
                }
            }
        }
    }
}


enum class HomeTabs(
    val text: String
) {
    Chemistry(
        text = "Хим.растворы"
    ),
    Technical(
        text = "Тех.операции"
    ),
    Notes(
        text = "Заметки"
    )
}