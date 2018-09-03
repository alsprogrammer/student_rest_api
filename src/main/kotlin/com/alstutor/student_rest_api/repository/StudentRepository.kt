package com.alstutor.student_rest_api.repository

import com.alstutor.student_rest_api.model.Student
import com.alstutor.student_rest_api.model.Group

import org.springframework.data.repository.CrudRepository

interface StudentRepository : CrudRepository<Student, String> {
    fun getById(id: String): List<Student>
    fun findByLastNameAndFirstNameAndSurNameAllIgnoreCase(lastName: String, firstName: String, surName: String): List<Student>
    fun findByLastNameAndFirstNameAndSurNameAllIgnoreCaseAndGroup(lastName: String, firstName: String, surName: String): List<Student>
    fun findByGroupOrderByLastNameAscFirstNameAscSurNameAsc(group: Group)
}