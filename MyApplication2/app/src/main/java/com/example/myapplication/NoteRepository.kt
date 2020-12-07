package com.example.myapplication

import android.content.Context
import android.text.TextUtils
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*


object NoteRepository {
    private val NOTE_LIST: MutableMap<Long, Note?> =
        HashMap<Long, Note?>()

    fun initialize(context: Context) {
        try {
            BufferedReader(InputStreamReader(context.assets.open("notes.txt")))
                .use { reader ->
                    var date = reader.readLine()
                    var text = reader.readLine()
                    var id: Long = 0
                    while (!TextUtils.isEmpty(text)) {
                        NOTE_LIST[id] = Note(id, text, date)
                        ++id

                        date = reader.readLine()
                        text = reader.readLine()
                    }
                }
        } catch (e: IOException) { }
    }

    val noteList: List<Note?>
        get() = ArrayList(NOTE_LIST.values)

    fun getNoteById(id: Long): Note? {
        return NOTE_LIST[id]
    }
}