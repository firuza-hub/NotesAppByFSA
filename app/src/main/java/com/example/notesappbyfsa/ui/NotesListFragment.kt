package com.example.notesappbyfsa.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.example.notesappbyfsa.R
import com.example.notesappbyfsa.data.local.NotesDataManager
import com.example.notesappbyfsa.data.local.NotesDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject


class NotesListFragment : Fragment() {

    private val dbHelper by inject<NotesDataManager>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notes_list, container, false)

        // Inflate the layout for this fragment
        val text = view.findViewById<TextView>(R.id.tv_List)

        val liveText =MutableLiveData<String>()
        CoroutineScope(Dispatchers.IO).launch{
            dbHelper.getAll().collect{liveText.postValue(it.first().title)}
        }

        liveText.observe(requireActivity()){text.text = liveText.value}
        return view
    }

}