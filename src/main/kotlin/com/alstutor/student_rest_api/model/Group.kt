package com.alstutor.student_rest_api.model

import com.alstutor.student_rest_api.model.Student
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import java.util.*

import com.alstutor.student_rest_api.model.Student

@TypeAlias("Group")
data class Group(@Id val id: String = UUID.randomUUID().toString(),
                 val name: String,
                 val creationYear: Int,
                 val term: Int,
                 val students: List<StudentInfo> = List<Student>()) {

}

data class StudentInfo(val id: String, val name: String) {
    constructor(student: Student): this(student.id, "$student.lastName $student.firstName $student.surName") {}
}