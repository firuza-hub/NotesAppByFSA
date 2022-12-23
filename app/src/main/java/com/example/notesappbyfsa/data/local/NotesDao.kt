package com.example.notesappbyfsa.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.notesappbyfsa.data.local.entities.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {

    @Query("SELECT * from Notes WHERE id=:id ")
    suspend fun getById(id: Int): List<Note>

    @Query("SELECT * from Notes ORDER BY dateUpdated desc")
    fun getAll(): Flow<List<Note>>

    @Query("DELETE FROM Notes WHERE id=:id")
    suspend fun delete(id: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createNote(newNote: Note)
}