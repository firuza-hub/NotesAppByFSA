package com.example.notesappbyfsa.ui.notesList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.notesappbyfsa.R
import com.example.notesappbyfsa.data.local.entities.Note
import com.example.notesappbyfsa.databinding.FragmentNotesListItemBinding

class NotesListItemAdapter: RecyclerView.Adapter<NotesListItemAdapter.NotesListItemViewHolder>() {

    private var data = mutableListOf<Note>()
    class NotesListItemViewHolder(val binding: FragmentNotesListItemBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesListItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<FragmentNotesListItemBinding>( inflater, R.layout.fragment_notes_list_item, parent, false)

        return NotesListItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotesListItemViewHolder, position: Int) {
        val currentItem = data[position]
        holder.binding.tvTitle.text = currentItem.title
        holder.binding.tvDate.text = currentItem.dateUpdated
        println("NOTES_ADAPTER: $currentItem")
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(newData: List<Note>){
        data = newData as MutableList<Note>
        notifyDataSetChanged()
    }
}