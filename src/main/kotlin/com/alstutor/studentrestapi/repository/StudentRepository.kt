package com.alstutor.studentrestapi.repository

import com.alstutor.studentrestapi.model.Student
import com.alstutor.studentrestapi.model.Group

import org.springframework.data.repository.CrudRepository

interface StudentRepository : CrudRepository<Student, String> {
    fun getById(id: String): Student
    fun findByLastNameAndFirstNameAndSurNameAllIgnoreCase(lastName: String, firstName: String, surName: String): List<Student>
    fun findByLastNameAndFirstNameAndSurNameAllIgnoreCaseAndGroup(lastName: String, firstName: String, surName: String, group: Group): List<Student>
    fun findByGroupOrderByLastNameAscFirstNameAscSurNameAsc(group: Group): List<Student>
}