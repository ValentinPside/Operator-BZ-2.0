package com.example.operatorbz2.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.operatorbz2.domain.Note

@Composable
fun NoteItem(
    note: Note,
    onClickDelete: (Note) -> Unit,
    onClick: (Int) -> Unit
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                onClick(note.id)
            }
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = note.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(10.dp)
            )
            IconButton(onClick = {
                onClickDelete(note)
            }) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = null)
            }
        }
    }
}