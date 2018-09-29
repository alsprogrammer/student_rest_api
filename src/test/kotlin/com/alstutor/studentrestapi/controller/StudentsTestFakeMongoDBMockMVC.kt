package com.alstutor.studentrestapi.controller

import com.alstutor.studentrestapi.StudentServiceFongoTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.test.web.servlet.MockMvc

@AutoConfigureMockMvc
abstract class StudentsTestFakeMongoDBMockMVC(itializeTestData: Boolean = true) :
        StudentServiceFongoTest(itializeTestData) {
    @Autowired
    lateinit var mvc: MockMvc
}