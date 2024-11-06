package com.example.contador

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var etNoteContent: EditText
    private lateinit var recyclerView: RecyclerView
    private lateinit var btnAddNote: Button
    private lateinit var btnJoke: Button
    private lateinit var btnWeather: Button
    private lateinit var btnCamera: Button
    private lateinit var btnPhotos: Button

    private val notesList = mutableListOf<Note>()
    private lateinit var adapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNoteContent = findViewById(R.id.etNoteContent)
        recyclerView = findViewById(R.id.recyclerView)
        btnAddNote = findViewById(R.id.btnAddNote)
        btnJoke = findViewById(R.id.btnJoke)
        btnWeather = findViewById(R.id.btnWeather)
        btnCamera = findViewById(R.id.btnCamera)
        btnPhotos = findViewById(R.id.btnPhotos)

        // Configura el RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = NotesAdapter(notesList)
        recyclerView.adapter = adapter

        // Acción del botón "Agregar Nota"
        btnAddNote.setOnClickListener {
            val noteContent = etNoteContent.text.toString()
            if (noteContent.isNotEmpty()) {
                val newNote = Note("Nota", noteContent)
                notesList.add(newNote)
                adapter.notifyItemInserted(notesList.size - 1)
                etNoteContent.text.clear()
            } else {
                Toast.makeText(this, "Por favor ingresa el contenido de la nota", Toast.LENGTH_SHORT).show()
            }
        }

        // Acción del botón "Obtener Chiste"
        btnJoke.setOnClickListener {
            Toast.makeText(this, "Este es tu chiste: ¡Estás increíble!", Toast.LENGTH_SHORT).show()
        }

        // Acción del botón "Ver Clima"
        btnWeather.setOnClickListener {
            Toast.makeText(this, "El clima está perfecto hoy!", Toast.LENGTH_SHORT).show()
        }

        // Acción del botón "Abrir Cámara"
        btnCamera.setOnClickListener {
            // Aquí deberías manejar la apertura de la cámara
            Toast.makeText(this, "Cámara no implementada", Toast.LENGTH_SHORT).show()
        }

        // Acción del botón "Ver Fotos"
        btnPhotos.setOnClickListener {
            // Aquí deberías manejar la apertura de Google Photos
            Toast.makeText(this, "Fotos no implementadas", Toast.LENGTH_SHORT).show()
        }
    }
}
