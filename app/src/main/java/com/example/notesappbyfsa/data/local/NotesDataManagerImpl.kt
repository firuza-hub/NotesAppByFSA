package com.example.notesappbyfsa.data.local

import com.example.notesappbyfsa.data.local.entities.Note
import kotlinx.coroutines.flow.Flow

class NotesDataManagerImpl(private val notesDao: NotesDao): NotesDataManager {
    override fun getAll(): Flow<List<Note>> {
        return notesDao.getAll()
    }

    override suspend fun createNote(newNote: Note) {
        notesDao.createNote(newNote)
    }

    override suspend fun deleteNote(id: Int) {
        notesDao.delete(id)
    }
}