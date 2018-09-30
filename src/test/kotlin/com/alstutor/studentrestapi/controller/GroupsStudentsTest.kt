package com.alstutor.studentrestapi.controller

import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import com.google.gson.Gson

class GroupsStudentsTest : StudentsTestFakeMongoDBMockMVC() {
    @Test
    fun checkGroupStudents() {
        logger.info("Begin students of group test")

        val gson = Gson()

        val expectedJson = gson.toJson(TEST_GROUP1.students).trimMargin()
        logger.debug("Expected JSON is $expectedJson")

        mvc.perform(MockMvcRequestBuilders.get("/studentsofgroup/${TEST_GROUP1.id}"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content().json(expectedJson))
    }

    companion object {
        val logger: Logger = LoggerFactory.getLogger(GroupsStudentsTest::class.java)
    }
}