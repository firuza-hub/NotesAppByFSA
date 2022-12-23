package com.example.notesappbyfsa.ui.createNote

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesappbyfsa.data.local.NotesDataManager
import com.example.notesappbyfsa.data.local.entities.Note
import kotlinx.coroutines.launch
import java.util.*

class NoteViewModel(private val dataManager: NotesDataManager) : ViewModel() {

    var title: String = ""
    var content: String = ""

    fun saveNote(navigateBack: () -> Unit, showToaster: (message: String) -> Unit) {
        if(title.isNullOrEmpty() || content.isNullOrEmpty()){
            showToaster("Please fill all the fields")
            return
        }
        viewModelScope.launch {
            val newNote = Note(0, title, content, Calendar.getInstance().time)
            dataManager.createNote(newNote)
            navigateBack()
        }
    }

}