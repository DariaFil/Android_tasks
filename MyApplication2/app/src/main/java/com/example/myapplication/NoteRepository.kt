package com.example.myapplication

import android.content.Context
import android.text.TextUtils
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.text.SimpleDateFormat
import java.util.*


object NoteRepository {
    private val NOTE_LIST: MutableMap<Long, Note?> =
        HashMap<Long, Note?>()

    fun initialize(context: Context) {
        var id: Long = 0
        val text = "Котики это мило"
        val date = "12.12.2020"
        val parser = SimpleDateFormat()
        val draw = 0
        while (id < 10) {
            NOTE_LIST[id] = Note(id, text, parser.parse(date), draw)
        }

    }

    val noteList: List<Note?>
        get() = ArrayList(NOTE_LIST.values)

    fun getNoteById(id: Long): Note? {
        return NOTE_LIST[id]
    }
}