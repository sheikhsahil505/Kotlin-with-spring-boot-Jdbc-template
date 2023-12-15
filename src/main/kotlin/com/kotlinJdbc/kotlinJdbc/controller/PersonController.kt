package com.kotlinJdbc.kotlinJdbc.controller
import com.kotlinJdbc.kotlinJdbc.dto.Person
import com.kotlinJdbc.kotlinJdbc.exception.UserNotFoundException
import com.kotlinJdbc.kotlinJdbc.service.PersonService
import com.kotlinJdbc.kotlinJdbc.service.impl.PersonServiceImpl
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/persons")
class PersonController(private val personService: PersonService) {

    @GetMapping
    fun getAllPersons(): List<Person> {
        return personService.getAllPersons()
    }

    @GetMapping("/{id}")
    fun getPersonById(@PathVariable id: Long): Person? {
        return try {
            personService.getPersonById(id) ?: throw UserNotFoundException("User with ID $id not found")
        } catch (e: UserNotFoundException) {
            throw e
        } catch (e: Exception) {
            throw RuntimeException("Internal Server Error")
        }
    }

    @PostMapping
    fun savePerson(@RequestBody person: Person):String {
        personService.savePerson(person)
        return "User Saved"
    }



    @DeleteMapping("/{id}")
    fun deletePerson(@PathVariable id: Long): String {
        return personService.deletePerson(id)
    }
}
