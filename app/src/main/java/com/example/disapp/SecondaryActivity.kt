package com.example.disapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class SecondaryActivity : AppCompatActivity() {
    private val vets: PersonsList = PersonsList()
    private lateinit var adapter: PersonListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)

        val listView = findViewById<ListView>(R.id.listView)
        val addButton: Button =  findViewById(R.id.addButton)

        adapter = PersonListAdapter(this, vets.getSortedBySurname())
        listView.adapter = adapter


        listView.setOnItemLongClickListener { parent, view, position, id ->
            val selectedPerson = vets.getSortedPerson(position)
            AlertDialog.Builder(this)
                .setTitle("Удалить запись")
                .setMessage("Вы уверены, что хотите удалить запись?")
                .setPositiveButton("Да") {dialog, which ->
                    vets.removePerson(selectedPerson)
                    adapter.updateList(vets.getSortedBySurname())
                }
                .setNegativeButton("Нет", null)
                .show()
            true
        }

        addButton.setOnClickListener {
            showAddPersonDialog()
        }
    }

    private fun showAddPersonDialog() {
        val addPersonDialog = AddPesronDialog(this, object : AddPesronDialog.OnPersonAddedListener {
            override fun onPersonAdded(person: Person) {
                vets.addPerson(person)
                adapter.updateList(vets.getSortedBySurname())
            }
        })
        addPersonDialog.show()
    }
}