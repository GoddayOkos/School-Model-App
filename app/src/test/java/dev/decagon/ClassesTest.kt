package dev.decagon

import org.junit.Test

import org.junit.Assert.*

class ClassesTest {

    @Test
    fun getClassName() {
        val class1 = Classes("Science", 5)
        assertEquals("Science", class1.getClassName())
    }

    @Test
    fun admittedStudents() {
        val class1 = Classes("Science", 5)
        val admittedStudents: ArrayList<Student> = ArrayList()
        assertEquals(admittedStudents, class1.admittedStudents())
    }

    @Test
    fun removeStudent() {
        val class1 = Classes("Science", 5)
        val sch = School("hgh", "fds","hjg")
        val appli = Applicant("Ajah", "Okoro",
                18, 2006, class1, sch)
        val stu1 = Student.createStudent(appli)
        assertTrue(class1.removeStudent(stu1))
    }

    @Test
    fun addStudent() {
        val class1 = Classes("Science", 5)
        val sch = School("hgh", "fds","hjg")
        val appli = Applicant("Ajah", "Okoro",
                18, 2006, class1, sch)
        val stu1 = Student.createStudent(appli)
        assertTrue(class1.addStudent(stu1))

    }

    @Test
    fun viewClassDetails() {
        val class1 = Classes("Science", 5)
        val admittedStudents: ArrayList<Student> = ArrayList()
        val sch = School("hgh", "fds","hjg")
        val appli = Applicant("Ajah", "Okoro",
                18, 2006, class1, sch)
        val stu1 = Student.createStudent(appli)
        class1.addStudent(stu1)
        fun display() {
            println("\tSCIENCE CLASS DETAILS")
            println("==============================")
            println("Class Name : Science\nClass Capacity: 5\n" +
                    "Number of Admitted Students: 1\nStudents Information: ")
            println()
            for (students in admittedStudents) {
                stu1.viewInfo()
                println()
            }
            println("==============================")
            println()
        }
        assertEquals(display(), class1.viewClassDetails())
    }
}
