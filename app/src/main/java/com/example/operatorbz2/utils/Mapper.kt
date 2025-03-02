package com.example.operatorbz2.utils

import com.example.operatorbz2.data.db.NoteEntity
import com.example.operatorbz2.domain.Note

fun NoteEntity.asNote() = Note(
    id = this.id,
    name = this.name,
    text = this.text
)

fun List<NoteEntity>.asNoteList() = this.map { it.asNote() }

fun Note.asNoteEntity() = NoteEntity(
    id = this.id,
    name = this.name,
    text = this.text
)

fun List<Note>.asNoteEntityList() = this.map { it.asNoteEntity() }