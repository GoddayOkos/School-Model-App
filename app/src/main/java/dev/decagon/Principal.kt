package dev.decagon

import dev.decagon.Student.Companion.createStudent

/**
 *                                  ASSUMPTION:
 *  There can be only one instance of principal in the school as such, the constructor is set to
 *  private to restrict access to principal's creation
 *  The principal can only admit applicants within the age range of 12 and 20
 *  The principal can expel students from the school
 *  The principal has a composition relationship with the school
 */

class Principal private constructor(firstName: String, lastName: String, school: School) : Staffs(firstName, lastName) {

       private val school: School = school

    companion object{
        private var instanceCount: Principal? = null        // The instanceCount is used to keep track and restrict the creation of principal instances

        // This method is use to make or create an instance of principal
        // This method returns either a principal object or null based on the value of the instanceCount
        fun makePrincipal(firstName: String, lastName: String, school: School): Principal? {
            return if (instanceCount == null) {
                instanceCount = Principal(firstName, lastName, school)
                instanceCount as Principal
            } else {
                println("ILLEGAL OPERATION! PRINCIPAL ALREADY EXIST!")
                null
            }
        }

    }
    // This method displays the principal's profile
    fun viewInfo() {
        println("\tPRINCIPAL'S PROFILE")
        println("============================")
        println("Name: $firstName $lastName\nRole: Principal\nResponsibility: School Management.")
        println("============================")
        println()
    }

    /**
    * This method is used by the principal to admit or reject applicants based on their age.
    * If an applicant meets the age specification, he/she is admitted and transformed into a
    * Student instance by calling on the Student's constructor via the createStudent() method and
    * the student is added to his/her proposed class via the school.addStudentToClass() method.
    * On the other hand, if the applicant fails the age requirement, he/she is denied admission,
    * removed from the applicants list and no longer considered as an applicant.
    */
    fun admitStudent(applicant: Applicant): Boolean {
        if (applicant.getAge() in 12..20) {
            println("\tADMISSION DECISION")
            println("==============================================")
            println("Congratulations ${applicant.getFirstName()}, you have been admitted into ${school.getSchoolName()}.\n" +
                    "Below is your offer letter.\nStudent Name: ${applicant.getFirstName()} ${applicant.getLastName()}\n" +
                    "Student ID: ${applicant.getApplicantID()}\nAdmission Status: Success!\nClass: ${applicant.getClass().getClassName()}\n" +
                    "Authorized By: The Principal")
            println("==============================================")
            println()
            createStudent(applicant)
            school.addStudentToClass()
            return true
        } else {
            println("\tADMISSION DECISION")
            println("==============================================")
            println("Sorry ${applicant.getFirstName()}, you are not eligible for admission into ${school.getSchoolName()}.\n" +
                    "Please see your details below.\nApplicant Name: ${applicant.getFirstName()} ${applicant.getLastName()}\n" +
                    "Applicant ID: ${applicant.getApplicantID()}\nAdmission Status: Failed!\nAuthorized By: The Principal")
            println("==============================================")
            println()
            school.removeApplicants(applicant)
            return false
        }
    }

    // This method expels student from the school
    fun expelStudent(student: Student) {
        println("${student.getStudentFirstName()}, has been expelled from ${school.getSchoolName()}")
        school.removeStudentFromClass(student)
        school.removeStudent(student)
    }

}