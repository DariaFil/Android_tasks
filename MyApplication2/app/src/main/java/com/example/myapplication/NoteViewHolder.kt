package com.example.myapplication

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class NoteViewHolder(
    itemView: View,
    listener: NoteAdapter.Listener?
) : RecyclerView.ViewHolder(itemView) {
    private val noteTextTextView: TextView
    private val noteDateTextView: TextView
    private var id: Long = 0
    private val listener: NoteAdapter.Listener? = null
    fun bind(note: Note) {
        noteTextTextView.setText(note.text)
        noteDateTextView.setText(note.date)
        id = note.id
    }

    init {
        noteTextTextView = itemView.findViewById(R.id.noteTextTextView)
        noteTextTextView.setOnClickListener {
            if (listener != null) {
                listener.onNoteClick(id)
            }
        }

        noteDateTextView = itemView.findViewById(R.id.noteDateTextView)
        noteDateTextView.setOnClickListener {
            if (listener != null) {
                listener.onNoteClick(id)
            }
        }
    }
}