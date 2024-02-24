package com.example.disapp

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddPesronDialog(context: Context, private val listener: OnPersonAddedListener) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_person)

        val nameEdit = findViewById<EditText>(R.id.firstNameEditText)
        val surnameEdit = findViewById<EditText>(R.id.lastNameEditText)
        val patronymicEdit = findViewById<EditText>(R.id.patronymicEditText)
        val specEdit = findViewById<EditText>(R.id.specEditText)
        val saveButton = findViewById<Button>(R.id.saveButton)

        saveButton.setOnClickListener {
            val name = nameEdit.text.toString()
            val surname = surnameEdit.text.toString()
            val patronymic = patronymicEdit.text.toString()
            val spec = specEdit.text.toString()
            listener.onPersonAdded(Person(name, surname, patronymic, spec))
            dismiss()
        }
    }
    interface OnPersonAddedListener {
        fun onPersonAdded(person: Person)
    }
}