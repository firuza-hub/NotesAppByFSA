package com.example.notesappbyfsa.app

import androidx.room.Room
import com.example.notesappbyfsa.data.local.NotesDataManager
import com.example.notesappbyfsa.data.local.NotesDataManagerImpl
import com.example.notesappbyfsa.data.local.NotesDatabase
import org.koin.dsl.module
import org.koin.android.ext.koin.androidContext


val dataModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            NotesDatabase::class.java,
            "learn-kotlin-flow"
        )
            .createFromAsset("database/notesapp.db")
            .build()
    }

    single { get<NotesDatabase>().notesDao() }


    single<NotesDataManager> {
        NotesDataManagerImpl(
            notesDao = get()
        )
    }
}