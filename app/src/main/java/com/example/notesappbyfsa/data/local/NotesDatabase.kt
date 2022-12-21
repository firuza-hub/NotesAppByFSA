package com.example.notesappbyfsa.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.notesappbyfsa.data.local.entities.Note
import com.example.notesappbyfsa.utils.RoomConverters

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(RoomConverters::class)
abstract class NotesDatabase: RoomDatabase() {

    abstract fun notesDao(): NotesDao
}

