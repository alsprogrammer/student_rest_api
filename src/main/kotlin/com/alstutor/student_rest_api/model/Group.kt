package com.alstutor.student_rest_api.model

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import java.util.*

import com.alstutor.student_rest_api.model.Student

@TypeAlias("Group")
data class Group(@Id val id: String,
                 val name: String,
                 val creationYear: Int,
                 val term: Int,
                 val students: List<StudentInfo>) {

}

data class StudentInfo(val id: String, val name: String) {
    
}