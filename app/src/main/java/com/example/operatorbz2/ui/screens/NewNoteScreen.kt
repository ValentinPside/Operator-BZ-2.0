package com.example.operatorbz2.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.operatorbz2.ui.theme.OperatorBZ2Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewNoteScreen(/*navController: NavHostController*/) {
    var noteTitle by remember { mutableStateOf("") }
    var noteContent by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Создание новой заметки") },
                navigationIcon = {
                    IconButton(onClick = { /*navController.popBackStack() */}) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    TextField(
                        value = noteTitle,
                        onValueChange = { noteTitle = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        placeholder = { Text("Введите название заметки") },
                    )
                    TextField(
                        value = noteContent,
                        onValueChange = { noteContent = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        placeholder = { Text("Введите текст заметки") },
                    )
                    Button(
                        onClick = { /* функция записи в бд из viewmodel */},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                    ) {
                        Text("Сохранить заметку", fontSize = 18.sp)
                    }
                }
            }
        }
    )
}

@Preview
@Composable
private fun PreviewCardDark() {
    OperatorBZ2Theme(darkTheme = true) {
        NewNoteScreen()
    }
}

@Preview
@Composable
private fun PreviewCardLight() {
    OperatorBZ2Theme(darkTheme = false) {
        NewNoteScreen()
    }
}