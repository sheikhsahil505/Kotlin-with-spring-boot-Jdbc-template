package com.kotlinJdbc.kotlinJdbc.service

import com.kotlinJdbc.kotlinJdbc.dto.Person

interface PersonService {
    fun getAllPersons(): List<Person>

    fun getPersonById(id: Long): Person?

    fun savePerson(person: Person)
    fun deletePerson(id: Long) :String
}