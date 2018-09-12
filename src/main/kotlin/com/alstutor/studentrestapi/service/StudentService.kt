package com.alstutor.studentrestapi.service

import com.alstutor.studentrestapi.model.Student
import com.alstutor.studentrestapi.model.Group
import com.alstutor.studentrestapi.repository.StudentRepository
import com.alstutor.studentrestapi.repository.GroupRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

interface StudentService {
    fun studentById(id: String): Student
    fun studentByName(lastName: String, firstName: String, surName: String): List<Student>
    fun studentByNameAndGroup(lastName: String, firstName: String, surName: String, group: Group): List<Student>
    fun studentsOfGroup(group: Group): List<Student>
    fun groupById(id: String): Group
    fun groupsByCreationYear(year: Int): List<Group>
    fun groupsByTerm(term: Int): List<Group>
    fun groupsByYearAndTerm(year: Int, term: Int): List<Group>
}

@Service("StudentService")
class StudentServiceImpl : StudentService {
    @Autowired
    lateinit var studentRepository: StudentRepository
    lateinit var groupRepository: GroupRepository

    override fun studentById(id: String): Student = studentRepository.getById(id)
    override fun studentByName(lastName: String, firstName: String, surName: String): List<Student> = 
                    studentRepository.findByLastNameAndFirstNameAndSurNameAllIgnoreCase(lastName, firstName, surName)
    override fun studentByNameAndGroup(lastName: String, firstName: String, surName: String, group: Group): List<Student> = 
                    studentRepository.findByLastNameAndFirstNameAndSurNameAllIgnoreCaseAndGroup(lastName, firstName, surName, group)
    override fun studentsOfGroup(group: Group): List<Student> = 
                    studentRepository.findByGroupOrderByLastNameAscFirstNameAscSurNameAsc(group)
    override fun groupById(id: String): Group = groupRepository.getById(id)
    override fun groupsByCreationYear(year: Int): List<Group> = groupRepository.findByCreationYear(year)
    override fun groupsByTerm(term: Int): List<Group> = groupRepository.findByTerm(term)
    override fun groupsByYearAndTerm(year: Int, term: Int): List<Group> = groupRepository.findByCreationYearAndTerm(year, term)
}