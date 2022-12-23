package com.example.notesappbyfsa.ui.notesList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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
        nAdapter = NotesListItemAdapter(){ viewModel.deleteItem(it)}
        binding.lifecycleOwner = viewLifecycleOwner

        binding.rvNotes.apply {
            adapter = nAdapter
        }

        binding.btnCreateNote.setOnClickListener{
            findNavController().navigate(NotesListFragmentDirections.actionNotesListFragmentToCreateNoteFragment())
        }
        viewModel.notes.observe(requireActivity()){nAdapter.setData(it )}
        viewModel.showLoader.observe(requireActivity()){binding.loader.isVisible = it}
        return binding.root
    }


}