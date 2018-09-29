package com.alstutor.studentrestapi.controller

import com.alstutor.studentrestapi.model.Student
import com.alstutor.studentrestapi.model.GroupInfo
import com.alstutor.studentrestapi.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import kotlin.streams.toList

import com.google.gson.Gson

@RestController
class StudentController {
    @Autowired
    lateinit var studentService: StudentService
    val gson = Gson()

    @GetMapping("/studentsofgroup/{group}")
    fun getStudents(@PathVariable groupId: String): String {
        val students: List<Student> = studentService.studentsOfGroup(studentService.groupById(groupId))
        val studentsJsonList = students.stream().map { gson.toJson(it) }.toList()
        return gson.toJson(studentsJsonList)
    }


}
