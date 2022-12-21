package com.example.notesappbyfsa.data.local

import com.example.notesappbyfsa.data.local.entities.Note
import kotlinx.coroutines.flow.Flow

class NotesDataManagerImpl(private val notesDao: NotesDao): NotesDataManager {
    override fun getAll(): Flow<List<Note>> {
        return notesDao.getAll()
    }
}