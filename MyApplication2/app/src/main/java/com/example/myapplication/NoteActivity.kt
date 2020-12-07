package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.NoteRepository.getNoteById


class NoteDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)
        val id = intent.getLongExtra(ID_KEY, -1)
        val note = getNoteById(id)
        val textTextView = findViewById<TextView>(R.id.noteTextTextView)
        textTextView.text = note!!.text
        val dateTextView = findViewById<TextView>(R.id.noteDateTextView)
        dateTextView.text = note.text
    }

    companion object {
        private const val ID_KEY = "ID_KEY"
        fun getIntent(context: Context?, id: Long): Intent {
            val intent = Intent(context, NoteDetailActivity::class.java)
            intent.putExtra(ID_KEY, id)
            return intent
        }
    }
}