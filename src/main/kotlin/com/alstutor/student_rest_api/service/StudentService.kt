package com.alstutor.student_rest_api.service

import com.alstutor.student_rest_api.model.Student
import com.alstutor.student_rest_api.model.Group
import com.alstutor.student_rest_api.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

interface StudentService {
    fun studentById(id: String): Student
    fun studentByName(lastName: String, firstName: String, surName: String): List<Student>
    fun studentByNameAndGroup(lastName: String, firstName: String, surName: String, group: Group): List<Student>
    fun studentsOfGroup(group: Group): List<Student>
}

@Service("StudentService")
class StudentServiceImpl : StudentService {
    @Autowired
    lateinit var studentRepository: StudentRepository

    override fun studentById(id: String): Student = studentRepository.getById(id)
    override fun studentByName(lastName: String, firstName: String, surName: String): List<Student> = 
                    studentRepository.findByLastNameAndFirstNameAndSurNameAllIgnoreCase(lastName, firstName, surName)
    override fun studentByNameAndGroup(lastName: String, firstName: String, surName: String, group: Group): List<Student> = 
                    studentRepository.findByLastNameAndFirstNameAndSurNameAllIgnoreCaseAndGroup(lastName, firstName, surName, group)
    override fun studentsOfGroup(group: Group): List<Student> = 
                    studentRepository.findByGroupOrderByLastNameAscFirstNameAscSurNameAsc(group)
}