package dev.decagon

import org.junit.Test

import org.junit.Assert.*

class TeacherTest {

    @Test
    fun roles() {
        val course1 = Course("maths", "mth 101")
        val class1 = Classes("Science", 5)
        val teacher = Teacher("John", "Smith", course1, class1)

        assertEquals(println("My name is John Smith, I'm a staff in this school."), teacher.roles())
    }

    @Test
    fun addClass() {
        val course1 = Course("maths", "mth 101")
        val class1 = Classes("Science", 5)
        val teacher = Teacher("John", "Smith", course1, class1)
        val course2 = Course("english", "eng 101")
        val class2 = Classes("Art", 10)
        val myClasses: ArrayList<Classes> = ArrayList()
        val myCourses: ArrayList<Course> = ArrayList()
        assertTrue(teacher.addClass(class2))
    }

    @Test
    fun addCourse() {
        val course1 = Course("maths", "mth 101")
        val class1 = Classes("Science", 5)
        val teacher = Teacher("John", "Smith", course1, class1)
        val course2 = Course("english", "eng 101")
        val class2 = Classes("Art", 10)
        val myClasses: ArrayList<Classes> = ArrayList()
        val myCourses: ArrayList<Course> = ArrayList()
        assertTrue(teacher.addCourse(course2))
    }

    @Test
    fun teach() {
        val course1 = Course("maths", "mth 101")
        val class1 = Classes("Science", 5)
        val teacher = Teacher("John", "Smith", course1, class1)
        assertEquals(println("Don't disturb me, I'm teaching my students in the classroom."), teacher.teach())
    }

    @Test
    fun viewInfo() {
        val course1 = Course("maths", "mth 101")
        val class1 = Classes("Science", 5)
        val teacher = Teacher("John", "Smith", course1, class1)
       // val course2 = Course("english", "eng 101")
       // val class2 = Classes("Art", 10)
        val myClasses: ArrayList<Classes> = ArrayList()
        val myCourses: ArrayList<Course> = ArrayList()

        fun display() {
            println("\tTEACHER'S PROFILE")
            println("==========================")
            println("Name: John Smith\nRole: Teacher\nClasses Assigned: ")
            println("\tScience")
            println("Courses Assigned: ")
            println("\tMTH 101 ==> MATHS")
            println("==========================")
            println()
        }

        assertEquals(display(), teacher.viewInfo())
    }
}