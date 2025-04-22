package com.example.operatorbz2.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface Dao {

    @Upsert
    suspend fun upsertTaskTable(taskEntity: NoteEntity)

    @Query("SELECT * FROM noteTable")
    suspend fun getAllNotes(): List<NoteEntity>

    @Delete
    suspend fun deleteNote(noteEntity: NoteEntity)

}