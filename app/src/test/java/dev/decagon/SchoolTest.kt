package dev.decagon

import org.junit.Test

import org.junit.Assert.*

class SchoolTest {

    @Test
    fun info() {
        val sch = School("Excellent Academy", "Secondary School","Private")
        val class1 = Classes("Science", 55)
        sch.addClass(class1)

        fun display() {
            println("\t\t\t\t\t\tSCHOOL PROFILE")
            println("========================================================================")
            println("Welcome to Excellent Academy. Below are some useful information about us.\nName: Excellent Academy" +
                    "Description: Secondary School\nSchool Type: Private\nAvailable Classes: ")
            println("\tScience")
            println("For more information, contact us on: info@excellentacademy.com")
            println("=========================================================================")
            println()
        }
        assertEquals(display(), sch.info())
    }

    @Test
    fun getSchoolName() {
        val sch = School("Excellent Academy", "Secondary School","Private")
        assertEquals("Excellent Academy", sch.getSchoolName())
    }

    @Test
    fun addStudent() {
        val sch = School("Excellent Academy", "Secondary School","Private")
        val class1 = Classes("Science", 55)
        sch.addClass(class1)
        val appli = Applicant("Ajah", "Okoro",
                20, 2, class1, sch)
        val stu1 = Student.createStudent(appli)
        assertEquals(true, sch.addStudent(stu1))
    }

    @Test
    fun addStaff() {
        val sch = School("Excellent Academy", "Secondary School","Private")
        val class1 = Classes("Science", 55)
        val course1 = Course("maths", "mth 101")
        val teacher = Teacher("John", "Smith", course1, class1)
        assertEquals(true, sch.addStaff(teacher))
    }

    @Test
    fun addCourse() {
        val course1 = Course("maths", "mth 101")
        val sch = School("Excellent Academy", "Secondary School","Private")
        assertEquals(true, sch.addCourse(course1))
    }

    @Test
    fun addClass() {
        val sch = School("Excellent Academy", "Secondary School","Private")
        val class1 = Classes("Science", 55)
        assertEquals(true, sch.addClass(class1))
    }

    @Test
    fun addApplicants() {
        val sch = School("Excellent Academy", "Secondary School","Private")
        val class1 = Classes("Science", 55)
        val appli = Applicant("Ajah", "Okoro",
                20, 2, class1, sch)
        assertEquals(true, sch.addApplicants(appli))
    }

    @Test
    fun removeApplicants() {
        val sch = School("Excellent Academy", "Secondary School","Private")
        val class1 = Classes("Science", 55)
        val appli = Applicant("Ajah", "Okoro",
                20, 2, class1, sch)
        assertEquals(true, sch.removeApplicants(appli))
    }

    @Test
    fun removeStudent() {
        val sch = School("Excellent Academy", "Secondary School","Private")
        val class1 = Classes("Science", 55)
        sch.addClass(class1)
        val appli = Applicant("Ajah", "Okoro",
                20, 2, class1, sch)
        val stu1 = Student.createStudent(appli)
        assertEquals(true, sch.removeStudent(stu1))
    }

    @Test
    fun viewApplicants() {
        val sch = School("Excellent Academy", "Secondary School","Private")
        val class1 = Classes("Science", 55)
        val appli = Applicant("Ajah", "Okoro",
                20, 2, class1, sch)
        fun display() {
            println("\t\t\tAPPLICATION PORTAL")
            println("====================================================")
            println("The following persons applied to Excellent Academy: ")
            println("Name: Ajah Okoro\nApplicant ID: ${appli.getApplicantID()}\nAge: 20 years\n" +
                    "Class Applied to: Science\nYear of Study: 2")
            println()
        println("====================================================")
        println()
        }
        assertEquals(display(),sch.viewApplicants())
    }

    @Test
    fun viewStudents() {
        val sch = School("Excellent Academy", "Secondary School","Private")
        val class1 = Classes("Science", 55)
        val appli = Applicant("Ajah", "Okoro",
                20, 2, class1, sch)
        val stu1 = Student.createStudent(appli)
        val course1 = Course("maths", "mth 101")
        stu1.registerCourse(course1)
        fun display() {
            println("\t\t\tADMISSION PORTAL")
            println("====================================================")
            println("The following persons have been admitted into Excellent Academy: ")
            println("Name: Ajah Okoro\nStudent ID: ${appli.getApplicantID()}\nAge: 20 years\n" +
                    "Class: Science \nYear of Study: 2\nCourses Registered: ")
            println("\tMTH 101 ==> MATHS")
            println()
        println("====================================================")
        println()
        }
    }

    @Test
    fun findStudent() {
        val sch = School("Excellent Academy", "Secondary School","Private")
        val class1 = Classes("Science", 55)
        val appli = Applicant("Ajah", "Okoro",
                20, 2, class1, sch)
        val stu1 = Student.createStudent(appli)
        sch.addStudentToClass()
        if (stu1 != null) {
            assertEquals(stu1, sch.findStudent("Ajah Okoro"))
        }
    }

    @Test
    fun addStudentToClass() {
        val sch = School("Excellent Academy", "Secondary School","Private")
        val class1 = Classes("Science", 55)
        val appli = Applicant("Ajah", "Okoro",
                20, 2, class1, sch)
        val stu1 = Student.createStudent(appli)
        assertTrue(sch.addStudentToClass())
    }

    @Test
    fun removeStudentFromClass() {
        val sch = School("Excellent Academy", "Secondary School","Private")
        val class1 = Classes("Science", 55)
        val appli = Applicant("Ajah", "Okoro",
                20, 2, class1, sch)
        val stu1 = Student.createStudent(appli)
        assertTrue(sch.removeStudentFromClass(stu1))
    }
}