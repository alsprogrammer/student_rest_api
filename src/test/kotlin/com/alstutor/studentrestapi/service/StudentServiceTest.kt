package com.alstutor.studentrestapi.service

import com.alstutor.studentrestapi.StudentServiceFongoTest
import com.alstutor.studentrestapi.model.Student
import com.alstutor.studentrestapi.model.StudentInfo
import com.alstutor.studentrestapi.model.Group
import com.alstutor.studentrestapi.model.GroupInfo
import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import kotlin.test.assertEquals

class StudentServiceTest : StudentServiceFongoTest() {
    @Autowired
    lateinit var studentService: StudentService

    @Test
    fun testGroups() {
        logger.info("Begin with groups")
        val firstTermGroups: List<Group> = studentService.groupsByTerm(1)
        assertEquals(firstTermGroups.size, 2, "There should be 2 groups of the fisrt term")
    }

    companion object {
        val logger: Logger =
                LoggerFactory.getLogger(StudentServiceTest::class.java)
    }
}