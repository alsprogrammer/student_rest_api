package com.alstutor.studentrestapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StudentRestApiApplication

fun main(args: Array<String>) {
    runApplication<StudentRestApiApplication>(*args)
}
