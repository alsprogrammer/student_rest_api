package com.alstutor.student_rest_api.model

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import java.util.*

@TypeAlias("student")
data class Student(@Id val id: String, 
                   val firstName: String, 
                   val surName: String, 
                   val lastName: String,
                   var group: GroupInfo) {
}

data class GroupInfo(val id: String, val name: String) {

}