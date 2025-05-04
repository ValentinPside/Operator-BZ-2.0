package com.example.operatorbz2.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.operatorbz2.domain.Note

@Dao
interface Dao {

    @Upsert
    suspend fun upsertTaskTable(taskEntity: NoteEntity)

    @Query("SELECT * FROM noteTable")
    suspend fun getAllNotes(): List<NoteEntity>

    @Query("SELECT * FROM noteTable WHERE id = :noteId")
    suspend fun getNote(noteId: Int): NoteEntity

    @Delete
    suspend fun deleteNote(noteEntity: NoteEntity)

}