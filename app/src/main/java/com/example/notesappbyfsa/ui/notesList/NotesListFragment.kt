package com.example.notesappbyfsa.ui.notesList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.notesappbyfsa.R
import com.example.notesappbyfsa.databinding.FragmentNotesListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class NotesListFragment : Fragment() {

    private val viewModel by viewModel<NotesViewModel>()
    private lateinit var binding: FragmentNotesListBinding

    private lateinit var nAdapter: NotesListItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_notes_list, container, false)
        nAdapter = NotesListItemAdapter()
        binding.lifecycleOwner = viewLifecycleOwner

        binding.rvNotes.apply {
            adapter = nAdapter
        }

        viewModel.notes.observe(requireActivity()){nAdapter.setData(it )}
        return binding.root
    }

}