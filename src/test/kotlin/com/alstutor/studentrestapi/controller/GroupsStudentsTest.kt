package com.alstutor.studentrestapi.controller

import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

class GroupsStudentsTest : StudentsTestFakeMongoDBMockMVC() {
    @Test
    fun checkGroupStudents() {
        logger.info("Begin students of group test")

        var result = mvc.perform(MockMvcRequestBuilders.get("/studentsofgroup/${TEST_GROUP1.id}"))

        result = result.andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())

        var index = 0
        for(student in TEST_GROUP1.students) {
            result = result.andExpect(MockMvcResultMatchers.jsonPath("$[$index].id")
                                      .value(TEST_GROUP1.students[index].id))
            index += 1
        }
    }

    companion object {
        val logger: Logger = LoggerFactory.getLogger(GroupsStudentsTest::class.java)
    }
}