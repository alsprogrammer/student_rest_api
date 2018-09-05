package com.alstutor.student_rest_api.model

import com.alstutor.student_rest_api.model.Group
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import java.util.*

@TypeAlias("student")
data class Student(@Id val id: String = UUID.randomUUID().toString(), 
                   val firstName: String, 
                   val surName: String, 
                   val lastName: String,
                   val phone: String = "",
                   var group: GroupInfo) {
}

data class GroupInfo(val id: String, val name: String) {
    constructor(group: Group): this(group.id, group.name) {}
}