package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class NoteListActivity : AppCompatActivity(), NoteAdapter.Listener {
    override fun onNoteClick(id: Long) {
        startActivity(NoteDetailActivity.getIntent(this, id))
    }

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)
        val recyclerView: RecyclerView = findViewById(R.id.noteRecyclerView)
        recyclerView.setLayoutManager(LinearLayoutManager(this))
        recyclerView.setHasFixedSize(true)
        recyclerView.getRecycledViewPool().setMaxRecycledViews(0, 5)
        val adapter = NoteAdapter()
        recyclerView.setAdapter(adapter)
        adapter.setNoteList(NoteRepository.noteList as List<Note>)
        adapter.setListener(this)
    }
}