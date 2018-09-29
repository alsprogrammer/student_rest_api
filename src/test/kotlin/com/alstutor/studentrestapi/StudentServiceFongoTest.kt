package com.alstutor.studentrestapi

import com.alstutor.studentrestapi.repository.StudentRepository
import com.alstutor.studentrestapi.repository.GroupRepository
import com.alstutor.studentrestapi.model.GroupInfo
import com.alstutor.studentrestapi.model.Group
import com.alstutor.studentrestapi.model.Student
import com.alstutor.studentrestapi.model.StudentInfo
import org.junit.Before
import org.junit.After
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
abstract class StudentServiceFongoTest(val initializeTestData: Boolean = true) {
    //@get:Rule
    //val FongoRule = FongoRule()

    @Autowired
    lateinit var studentRepository: StudentRepository
    @Autowired
    lateinit var groupRepository: GroupRepository

    @Before
    fun setupTestDatabase() {
        if (initializeTestData) {
            studentRepository.save(TEST_STUDENT1)
            studentRepository.save(TEST_STUDENT2)
            studentRepository.save(TEST_STUDENT3)

            TEST_GROUP1.students.add(StudentInfo(TEST_STUDENT1))
            TEST_GROUP1.students.add(StudentInfo(TEST_STUDENT2))
            TEST_GROUP2.students.add(StudentInfo(TEST_STUDENT3))

            groupRepository.save(TEST_GROUP1)
            groupRepository.save(TEST_GROUP2)
        }
    }

    @After
    fun cleanUpTestDatabase() {
        studentRepository.delete(TEST_STUDENT1)
        studentRepository.delete(TEST_STUDENT2)
        studentRepository.delete(TEST_STUDENT3)

        groupRepository.delete(TEST_GROUP1)
        groupRepository.delete(TEST_GROUP2)
    }

    companion object {
        var TEST_GROUP1 = Group(name="БКБ16-01", creationYear=2016, term=1)
        private val TEST_GROUP1_INFO = GroupInfo(TEST_GROUP1)

        var TEST_GROUP2 = Group(name="БКБ17-01", creationYear=2017, term=1)
        private val TEST_GROUP2_INFO = GroupInfo(TEST_GROUP2)

        val TEST_STUDENT1 = Student(firstName="Иван", surName="Петрович", lastName="Сидоров", group=TEST_GROUP1_INFO)
        val TEST_STUDENT2 = Student(firstName="Петр", surName="Иванович", lastName="Сидоров", group=TEST_GROUP1_INFO)
        val TEST_STUDENT3 = Student(firstName="Сидор", surName="Петрович", lastName="Иванов", group=TEST_GROUP2_INFO)
    }
}