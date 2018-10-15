package com.alstutor.studentrestapi.controller

import com.alstutor.studentrestapi.model.Student
import com.alstutor.studentrestapi.model.GroupInfo
import com.alstutor.studentrestapi.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable

@RestController
class StudentController {
    @Autowired
    lateinit var studentService: StudentService

    @GetMapping("/studentsofgroup/{groupId}")
    fun getStudents(@PathVariable groupId: String): List<Student>  =
            studentService.studentsOfGroup(GroupInfo(studentService.groupById(groupId)))
}
