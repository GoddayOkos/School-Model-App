package dev.decagon

import dev.decagon.Student.Companion.createStudent
import org.junit.Test

import org.junit.Assert.*

class StudentTest {

    @Test
    fun registerCourse() {
        val class1 = Classes("Science", 55)
        val sch = School("Excellent Academy", "Secondary School","Private")
        val appli = Applicant("Ajah", "Okoro",
                20, 2, class1, sch)
        val course1 = Course("maths", "mth 101")
        val myCourses: ArrayList<Course> = ArrayList()
        val stu1 = createStudent(appli)
        assertEquals(myCourses.add(course1), stu1.registerCourse(course1))
    }

    @Test
    fun getStudentFirstName() {
        val class1 = Classes("Science", 55)
        val sch = School("Excellent Academy", "Secondary School","Private")
        val appli = Applicant("Ajah", "Okoro",
                20, 2, class1, sch)
        val course1 = Course("maths", "mth 101")
        val stu1 = createStudent(appli)
        assertEquals("Ajah", stu1.getStudentFirstName())
    }

    @Test
    fun getStudentFullName() {
        val class1 = Classes("Science", 55)
        val sch = School("Excellent Academy", "Secondary School","Private")
        val appli = Applicant("Ajah", "Okoro",
                20, 2, class1, sch)
        val course1 = Course("maths", "mth 101")
        val stu1 = createStudent(appli)
        assertEquals("Ajah Okoro", stu1.getStudentFullName())
    }

    @Test
    fun getStudentClass() {
        val class1 = Classes("Science", 55)
        val sch = School("Excellent Academy", "Secondary School","Private")
        val appli = Applicant("Ajah", "Okoro",
                20, 2, class1, sch)
        val course1 = Course("maths", "mth 101")
        val stu1 = createStudent(appli)
        assertEquals(class1, stu1.getStudentClass())
    }



    @Test
    fun viewInfo() {
        val class1 = Classes("Science", 55)
        val sch = School("Excellent Academy", "Secondary School","Private")
        val appli = Applicant("Ajah", "Okoro",
                20, 2, class1, sch)
        val course1 = Course("maths", "mth 101")
        val myCourses: ArrayList<Course> = ArrayList()
        val stu1 = createStudent(appli)
        myCourses.add(course1)

        fun display() {
            println("Name: Ajah Okoro\nStudent ID: ${appli.getApplicantID()}\nAge: 20 years\n" +
                    "Class: Science \nYear of Study: 2\nCourses Registered: ")
            println("\tMTH 101 ==> MATHS")
        }

        assertEquals(display(), stu1.viewInfo())
    }
}