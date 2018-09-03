package com.alstutor.student_rest_api.repository

import com.alstutor.student_rest_api.model.Student

import org.springframework.data.repository.CrudRepository

interface StudentRepository : CrudRepository<Student, String> {
    fun findByFirstnameAndSurnameAndLastnameIgnoreCase(fistName: String, surName: String, lastName: String): List<Student>
}