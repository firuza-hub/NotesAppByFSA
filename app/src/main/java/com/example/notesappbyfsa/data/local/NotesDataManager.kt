package com.example.notesappbyfsa.data.local

import com.example.notesappbyfsa.data.local.entities.Note
import kotlinx.coroutines.flow.Flow

interface NotesDataManager {

    fun getAll(): Flow<List<Note>>
    suspend fun createNote(newNote: Note)
    suspend fun deleteNote(id: Int)
}