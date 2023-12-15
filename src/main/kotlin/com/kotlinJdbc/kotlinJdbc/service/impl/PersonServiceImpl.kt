package com.kotlinJdbc.kotlinJdbc.service.impl
import com.kotlinJdbc.kotlinJdbc.dto.Person
import com.kotlinJdbc.kotlinJdbc.repository.PersonRepository
import com.kotlinJdbc.kotlinJdbc.service.PersonService
import org.springframework.stereotype.Service

@Service
class PersonServiceImpl(private val personRepository: PersonRepository) : PersonService {

    override fun getAllPersons(): List<Person>  = personRepository.getAllPersons()

    override fun getPersonById(id: Long): Person? = personRepository.getPersonById(id)

    override fun savePerson(person: Person) = personRepository.savePerson(person)

    override fun deletePerson(id: Long) :String = personRepository.deletePerson(id)
}
