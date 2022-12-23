package com.example.notesappbyfsa.ui.createNote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesappbyfsa.data.local.NotesDataManager
import com.example.notesappbyfsa.data.local.entities.Note
import kotlinx.coroutines.launch
import java.util.*

class NoteViewModel(private val dataManager: NotesDataManager) : ViewModel() {

    var title: String = ""
    var content: String = ""

    fun saveNote(navigateBack:()->Unit) {
        viewModelScope.launch {
            val newNote = Note(0, title, content, Calendar.getInstance().time)
            dataManager.createNote(newNote)
            navigateBack()
        }
    }

}