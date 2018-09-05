package com.alstutor.studentrestapi.model

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import java.util.*

@TypeAlias("Group")
data class Group(@Id val id: String = UUID.randomUUID().toString(),
                 val name: String,
                 val creationYear: Int,
                 val term: Int,
                 val students: MutableList<StudentInfo> = mutableListOf())

data class StudentInfo(val id: String, val name: String) {
    constructor(student: Student): this(student.id, "$student.lastName $student.firstName $student.surName")
}