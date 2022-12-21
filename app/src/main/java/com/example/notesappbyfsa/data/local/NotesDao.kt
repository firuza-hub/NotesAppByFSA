package com.example.notesappbyfsa.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.notesappbyfsa.data.local.entities.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(list: List<Note>)

    @Query("SELECT * from Notes WHERE id=:id")
    fun getById(id: Int): List<Note>

    @Query("SELECT * from Notes")
    fun getAll(): Flow<List<Note>>

    @Query("DELETE FROM Notes WHERE id=:id")
    fun clear(id: Int)
}