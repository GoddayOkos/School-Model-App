package dev.decagon

import org.junit.Test

import org.junit.Assert.*

class CourseTest {

    @Test
    fun getCourseName() {
        val course1 = Course("maths", "mth 101")
        assertEquals("MATHS", course1.getCourseName())
    }

    @Test
    fun getCourseCode() {
        val course1 = Course("maths", "mth 101")
        assertEquals("MTH 101", course1.getCourseCode())
    }
}