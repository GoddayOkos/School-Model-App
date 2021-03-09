package dev.decagon

import dev.decagon.Principal.Companion.makePrincipal
import org.junit.Test

import org.junit.Assert.*

class PrincipalTest {

    @Test
    fun roles() {

        val sch = School("Excellent Academy", "Secondary School","Private")
        val principal = makePrincipal("Adams", "Williams", sch)
        if (principal != null) {
            assertEquals(println("My name is Adams Williams, I'm a staff in this school."), principal.roles())
        }

    }

    @Test
    fun viewInfo() {
        val sch = School("Excellent Academy", "Secondary School","Private")
        val principal = makePrincipal("Adams", "Williams", sch)
        fun display() {
            println("\tPRINCIPAL'S PROFILE")
            println("============================")
            println("Name: Adams Williams\nRole: Principal\nResponsibility: School Management.")
            println("============================")
            println()
        }
        if (principal != null) {
            assertEquals(display(), principal.viewInfo())
        }
    }

    @Test
    fun admitStudent() {
        val sch = School("Excellent Academy", "Secondary School", "Private")
        val principal = makePrincipal("Adams", "Williams", sch)
        val class1 = Classes("Science", 55)
        val appli = Applicant("Ajah", "Okoro",
                20, 2, class1, sch)
        if (principal != null) {
            assertEquals(true, principal.admitStudent(appli))
        }
    }

    @Test
    fun expelStudent() {
        val sch = School("Excellent Academy", "Secondary School", "Private")
        val principal = makePrincipal("Adams", "Williams", sch)
        val class1 = Classes("Science", 55)
        val appli = Applicant("Ajah", "Okoro",
                20, 2, class1, sch)
        val stu1 = Student.createStudent(appli)
        fun test() {
            println("Ajah, has been expelled from Excellent Academy")
            class1.removeStudent(stu1)
            sch.removeStudent(stu1)
        }
        if (principal != null) {
            assertEquals(test(), principal?.expelStudent(stu1))
        }
    }
}