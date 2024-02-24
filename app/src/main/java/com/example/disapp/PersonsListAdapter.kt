package com.example.disapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class PersonListAdapter(private val context: Context, private var personList: List<Person>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.custom_list_item, parent, false)

        val mainText = view.findViewById<TextView>(R.id.mainText)
        val extraText = view.findViewById<TextView>(R.id.extraText)

        val person = personList[position]
        mainText.text = "${person.name} ${person.patronymic} ${person.surname}"
        extraText.text = "Должность: ${person.spec}"

        return view
    }

    override fun getItem(position: Int): Any {
        return personList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return personList.size
    }

    fun updateList(newList: List<Person>) {
        personList = newList
        notifyDataSetChanged()
    }
}
