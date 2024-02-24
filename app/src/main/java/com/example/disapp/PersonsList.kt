package com.example.disapp

class PersonsList {
    private val personsList = mutableListOf<Person>()

    fun addPerson(person: Person) {
        personsList.add(person)
    }

    fun getSortedPerson(pos: Int) : Person {
        return personsList.sortedBy { it.surname }[pos]
    }

    fun removePerson(person: Person) {
        personsList.remove(person)
    }

    fun getSortedBySurname(): List<Person> {
        return personsList.sortedBy { it.surname }
    }
}