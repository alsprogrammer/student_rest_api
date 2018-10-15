package com.alstutor.studentrestapi.controller

import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath

class GroupsStudentsTest : StudentsTestFakeMongoDBMockMVC() {
    @Test
    fun checkGroupStudents() {
        logger.info("Begin students of group test")

        val result = mvc.perform(MockMvcRequestBuilders.get("/studentsofgroup/${TEST_GROUP1.id}"))

        result.andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id")
                        .value(TEST_GROUP1.students[0].id))
    }

    companion object {
        val logger: Logger = LoggerFactory.getLogger(GroupsStudentsTest::class.java)
    }
}