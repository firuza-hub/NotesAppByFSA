package com.example.notesappbyfsa.ui.createNote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.notesappbyfsa.R
import com.example.notesappbyfsa.databinding.FragmentCreateNoteBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateNoteFragment : Fragment() {

    private val viewModel by viewModel<NoteViewModel>()
    private lateinit var binding: FragmentCreateNoteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_note, container, false)

        binding.btnSave.setOnClickListener{
            viewModel.title = binding.etTitle.text.toString()
            viewModel.content = binding.etContent.text.toString()
            viewModel.saveNote( navigateBack()) {
                Toast.makeText(requireActivity(), it, Toast.LENGTH_SHORT).show()
            }

        }
        return binding.root
    }


    private fun navigateBack()= {findNavController().navigate(CreateNoteFragmentDirections.actionCreateNoteFragmentToNotesListFragment())}

}