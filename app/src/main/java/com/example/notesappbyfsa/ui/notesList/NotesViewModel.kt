package com.example.notesappbyfsa.ui.notesList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesappbyfsa.data.local.NotesDataManager
import com.example.notesappbyfsa.data.local.entities.Note
import kotlinx.coroutines.launch

class NotesViewModel(dataManager: NotesDataManager): ViewModel() {

    val notes = MutableLiveData<List<Note>>()
    init {

        viewModelScope.launch {
            dataManager.getAll().collect {
                notes.postValue(it)}

        }
    }

}