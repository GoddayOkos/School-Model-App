package dev.decagon

import org.junit.Test

import org.junit.Assert.*

class NonAcademicStaffTest {

    @Test
    fun roles() {
        val worker = NonAcademicStaff("Clem", "Okoro", "Cleaner")
        fun test(){
            println("My name is Clem Okoro, I'm a staff in this school.")
            println("I function as the ${worker.role} of this school and I do not teach.")
        }
        assertEquals(test(), worker.roles())
    }

}