package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList


class NoteAdapter : RecyclerView.Adapter<NoteViewHolder?>() {
    interface Listener {
        fun onNoteClick(id: Long)
    }

    private var noteList: List<Note> = ArrayList<Note>()
    private var listener: com.example.myapplication.NoteAdapter.Listener? = null
    fun setListener(listener: com.example.myapplication.NoteAdapter.Listener?) {
        this.listener = listener
    }

    fun setNoteList(noteList: List<Note>) {
        this.noteList = noteList
        notifyDataSetChanged()
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): NoteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view: View = layoutInflater.inflate(
            R.layout.note_list_item,
            parent,
            false
        )
        return NoteViewHolder(view, listener)
    }

    override fun onBindViewHolder(@NonNull holder: NoteViewHolder, position: Int) {
        holder.bind(noteList[position])
    }

    override fun getItemCount(): Int {
        return noteList.size
    }
}