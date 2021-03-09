package dev.decagon

import org.hamcrest.Matchers.`is`
import org.junit.Test

import org.junit.Assert.*

class ApplicantTest {

    @Test
    fun getFirstName() {
        val class1 = Classes("Science", 55)
        val sch = School("Excellent Academy", "Secondary School","Private")
        val appli = Applicant("Ajah", "Okoro",
                20, 2, class1, sch)
        assertEquals("Ajah", appli.getFirstName())
    }

    @Test
    fun getLastName() {
        val class1 = Classes("Science", 55)
        val sch = School("Excellent Academy", "Secondary School","Private")
        val appli = Applicant("Ajah", "Okoro",
                20, 2, class1, sch)
        assertEquals("Okoro", appli.getLastName())
    }

    @Test
    fun getAge() {
        val class1 = Classes("Science", 55)
        val sch = School("Excellent Academy", "Secondary School","Private")
        val appli = Applicant("Ajah", "Okoro",
                20, 2, class1, sch)
        assertEquals(20, appli.getAge())
    }

    @Test
    fun getYearOfStudy() {
        val class1 = Classes("Science", 55)
        val sch = School("Excellent Academy", "Secondary School","Private")
        val appli = Applicant("Ajah", "Okoro",
                20, 2, class1, sch)
        assertEquals(2, appli.getYearOfStudy())
    }

    @Test
    fun getApplicantID() {
        val class1 = Classes("Science", 55)
        val sch = School("Excellent Academy", "Secondary School","Private")
        val appli = Applicant("Ajah", "Okoro",
                20, 2, class1, sch)
        assertTrue(appli.getApplicantID().toInt() in 200000..299999)
    }


    @Test
    fun getClass() {
        val class1 = Classes("Science", 55)
        val sch = School("Excellent Academy", "Secondary School","Private")
        val appli = Applicant("Ajah", "Okoro",
                20, 2, class1, sch)
        assertEquals(class1, appli.getClass())
    }

    @Test
    fun getSchool() {
        val class1 = Classes("Science", 55)
        val sch = School("Excellent Academy", "Secondary School","Private")
        val appli = Applicant("Ajah", "Okoro",
                20, 2, class1, sch)
        assertThat(sch, `is`(appli.getSchool()))
    }

    @Test
    fun details() {
        val class1 = Classes("Science", 55)
        val sch = School("Excellent Academy", "Secondary School","Private")
        val appli = Applicant("Ajah", "Okoro",
                20, 2, class1, sch)
        assertEquals( println("Name: Ajah Okoro\nApplicant ID: ${appli.getApplicantID()}\nAge: 20 years\n" +
                "Class Applied to: Science\nYear of Study: 2"), appli.details())
    }
}