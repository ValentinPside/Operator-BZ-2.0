package com.example.operatorbz2.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.operatorbz2.app.App
import com.example.operatorbz2.ui.theme.viewmodels.TextViewModel
import com.example.operatorbz2.utils.Factory


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextScreen(
    navController: NavHostController,
    itemId: String,
    viewModel: TextViewModel = viewModel(factory = Factory {
        App.appComponent.textComponent().viewModel()
    })
) {
    val scrollState = rememberScrollState()
    viewModel.getItem(itemId)
    val itemState by viewModel.observeUi().collectAsState()
    val item = itemState.item

    Column(
        modifier = Modifier
            .padding(8.dp)
            .verticalScroll(scrollState)
    ) {
        TopAppBar(
            title = { Text(text = stringResource(item.name)) },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
        Image(
            painter = painterResource(id = item.icon),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 4.dp)
                .fillMaxSize(),
            alignment = Alignment.Center
        )
        Text(
            text = stringResource(item.text),
            modifier = Modifier.padding(top = 4.dp, bottom = 16.dp)
                .fillMaxSize(),
            textAlign = TextAlign.Unspecified
        )
    }
}