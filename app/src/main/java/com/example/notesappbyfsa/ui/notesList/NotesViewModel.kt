package com.example.notesappbyfsa.ui.notesList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesappbyfsa.data.local.NotesDataManager
import com.example.notesappbyfsa.data.local.entities.Note
import kotlinx.coroutines.launch

class NotesViewModel(private val dataManager: NotesDataManager) : ViewModel() {


    private val _showLoader= MutableLiveData<Boolean>(false)
    val showLoader: LiveData<Boolean>
        get() = _showLoader

    val notes = MutableLiveData<List<Note>>()

    init {
        fetchList()

    }

    fun fetchList() {
        viewModelScope.launch {
            _showLoader.value = true
            dataManager.getAll().collect {
                notes.postValue(it)
                _showLoader.value =false
            }
        }
    }

    fun deleteItem(id: Int) {
        viewModelScope.launch {
            _showLoader.postValue(true)
            dataManager.deleteNote(id)
            _showLoader.postValue(false)
            fetchList()
        }
    }


}