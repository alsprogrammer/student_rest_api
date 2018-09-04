package com.alstutor.student_test_api

import com.github.fakemongo.junit.FongoRule
import com.alstutor.student_test_api.model.Student
import com.alstutor.student_test_api.model.StudentInfo
import com.alstutor.student_test_api.model.Group
import com.alstutor.student_test_api.model.GroupInfo
import com.alstutor.student_test_api.repository.StudentRepository
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
abstract class StudentServiceFongoTest(val initializeTestData: Boolean = true) {
    @get:Rule
    val FongoRule = FongoRule()

    @Autowired
    lateinit var studentRepository: StudentRepository

    @Before
    fun setupTestDatabase() {
        if (initializeTestData) {
            studentRepository.save(TEST_STUDENT1)
            studentRepository.save(TEST_STUDENT2)
            studentRepository.save(TEST_STUDENT3)
        }
    }

    companion object {
        val TEST_GROUP_INFO1 = GroupInfo()
        val TEST_STUDENT1 = Student()
        val TEST_STUDENT2 = Student()
        val TEST_GROUP1 = Group()
    }
}