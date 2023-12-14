package com.kotlinJdbc.kotlinJdbc.service
import com.kotlinJdbc.kotlinJdbc.dto.Person
import com.kotlinJdbc.kotlinJdbc.repository.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonService(private val personRepository: PersonRepository) {

    fun getAllPersons(): List<Person>  = personRepository.getAllPersons()

    fun getPersonById(id: Long): Person? = personRepository.getPersonById(id)

    fun savePerson(person: Person) = personRepository.savePerson(person)

    fun deletePerson(id: Long) :String = personRepository.deletePerson(id)
}
