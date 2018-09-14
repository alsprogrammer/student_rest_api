package com.alstutor.studentrestapi.model

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import java.util.*

@TypeAlias("Group")
data class Group(@Id val id: String = UUID.randomUUID().toString(),
                 val name: String,
                 val creationYear: Int,
                 val term: Int,
                 val students: MutableList<StudentInfo> = mutableListOf()) {

    fun add(element: StudentInfo): Boolean = students.add(element)

    // To simplify the process of new element adding so we can add a Student instead of StudentInfo
    fun add(element: Student): Boolean {
        val result = students.add(StudentInfo(element))

        if (result) {
            element.group = GroupInfo(this)
        }
        return result
    }

    fun add(index: Int, element: StudentInfo) = students.add(index, element)

    // To simplify the process of new element adding so we can add a Student instead of StudentInfo
    fun add(index: Int, element: Student) {
        element.group = GroupInfo(this)
        return students.add(index, StudentInfo(element))
    }

    val size: Int = students.size

    fun containsAll(elements: Collection<StudentInfo>): Boolean = students.containsAll(elements)

    fun get(index: Int): StudentInfo = students[index]

    fun indexOf(element: StudentInfo): Int = students.indexOf(element)

    fun indexOf(element: Student): Int = students.indexOf(StudentInfo(element))

    fun isEmpty(): Boolean = students.isEmpty()

    fun iterator(): MutableIterator<StudentInfo> = students.iterator()

    fun lastIndexOf(element: StudentInfo): Int = students.lastIndexOf(element)

    fun lastIndexOf(element: Student): Int = students.lastIndexOf(StudentInfo(element))

    fun addAll(index: Int, elements: Collection<StudentInfo>): Boolean = students.addAll(index, elements)

    fun addAll(elements: Collection<StudentInfo>): Boolean = students.addAll(elements)

    fun clear() = students.clear()

    fun listIterator(): MutableListIterator<StudentInfo> = students.listIterator()

    fun listIterator(index: Int): MutableListIterator<StudentInfo> = students.listIterator(index)

    fun remove(element: StudentInfo): Boolean = students.remove(element)

    fun removeAll(elements: Collection<StudentInfo>): Boolean = students.removeAll(elements)

    fun removeAt(index: Int): StudentInfo = students.removeAt(index)

    fun retainAll(elements: Collection<StudentInfo>): Boolean = retainAll(elements)

    fun set(index: Int, element: StudentInfo): StudentInfo = set(index, element)

    fun subList(fromIndex: Int, toIndex: Int): MutableList<StudentInfo> = students.subList(fromIndex, toIndex)

    fun contains(element: StudentInfo): Boolean = students.contains(element)

    fun contains(element: Student): Boolean = students.contains(StudentInfo(element))
}

data class StudentInfo(val id: String, val name: String) {
    constructor(student: Student): this(student.id, "$student.lastName $student.firstName $student.surName")
}