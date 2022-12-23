package com.example.notesappbyfsa.app

import androidx.room.Room
import com.example.notesappbyfsa.data.local.NotesDataManager
import com.example.notesappbyfsa.data.local.NotesDataManagerImpl
import com.example.notesappbyfsa.data.local.NotesDatabase
import com.example.notesappbyfsa.ui.createNote.NoteViewModel
import com.example.notesappbyfsa.ui.notesList.NotesViewModel
import org.koin.dsl.module
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel


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

    viewModel{
        NotesViewModel(get())
    }
    viewModel{

        NoteViewModel(get())
    }
}