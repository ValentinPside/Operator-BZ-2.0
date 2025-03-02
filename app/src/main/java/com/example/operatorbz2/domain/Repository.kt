package com.example.operatorbz2.domain

import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getFirstList(): List<Item>
    fun getSecondList(): List<Item>
    suspend fun createNewNote(note: Note)
    fun getAllNotes(): Flow<List<Note>>
    suspend fun deleteNote(note: Note)
}