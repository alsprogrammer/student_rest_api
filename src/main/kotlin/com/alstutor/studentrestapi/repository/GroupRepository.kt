package com.alstutor.studentrestapi.repository

import com.alstutor.studentrestapi.model.Group

import org.springframework.data.repository.CrudRepository

interface GroupRepository : CrudRepository<Group, String> {
    fun getById(id: String): Group
    fun findByCreationYear(year: Int): List<Group>
    fun findByTerm(term: Int): List<Group>
    fun findByCreationYearAndTerm(year: Int, term: Int): List<Group>
}