package com.example.operatorbz2.data.db

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(version = 1, entities = [NoteEntity::class], exportSchema = false)
abstract class MainDb : RoomDatabase() {
    abstract fun dao(): Dao
}