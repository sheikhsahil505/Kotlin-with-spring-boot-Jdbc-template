package com.kotlinJdbc.kotlinJdbc.repository
import com.kotlinJdbc.kotlinJdbc.dto.Person
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class PersonRepository(private val jdbcTemplate: NamedParameterJdbcTemplate) {

    fun getAllPersons(): List<Person> {
        val sql = "SELECT * FROM person"
        return jdbcTemplate.query(sql, personRowMapper)
    }

    fun getPersonById(id: Long): Person? {
        val sql = "SELECT * FROM person WHERE id = :id"
        val params = mapOf("id" to id)
        return jdbcTemplate.query(sql, params, personRowMapper).firstOrNull()
    }

    fun savePerson(person: Person) {
        val sql = "INSERT INTO person(name, age) VALUES (:name, :age)"
        val params = mapOf("name" to person.name, "age" to person.age)
        val update = jdbcTemplate.update(sql, params)


    }

    fun deletePerson(id: Long):String {
        var msg:String
        val findSql = "SELECT * FROM person WHERE id = :id"
        val sql = "DELETE FROM person WHERE id = :id"
        val params = mapOf("id" to id)
        val firstOrNull = jdbcTemplate.query(findSql, params, personRowMapper).firstOrNull()
        msg = if (firstOrNull!=null){
            jdbcTemplate.update(sql, params)
            "User $id Deleted Successfully  "
        }else{
            "User not found with user id $id"
        }
        return msg
    }

    private val personRowMapper = RowMapper { rs, _ ->
        Person(
            id = rs.getLong("id"),
            name = rs.getString("name"),
            age = rs.getInt("age")
        )
    }
}
