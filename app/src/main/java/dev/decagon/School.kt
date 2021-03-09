package dev.decagon

import java.util.*
import kotlin.collections.ArrayList

class School(private val name: String, private val description: String, private val schoolType: String) {
    private val schoolStudents: ArrayList<Student> = ArrayList()
    private val schoolStaffs: ArrayList<Staffs> = ArrayList()
    private val availableCourses: ArrayList<Course> = ArrayList()
    private val availableClasses: ArrayList<Classes> = ArrayList()
    private val applicants: ArrayList<Applicant> = ArrayList()

    // This method displays the school's profile
    fun info() {
        println("\t\t\t\t\t\tSCHOOL PROFILE")
        println("========================================================================")
        println("Welcome to $name. Below are some useful information about us.\nName: $name\n" +
                "Description: $description\nSchool Type: $schoolType\nAvailable Classes: ")
        viewClasses()
        println("For more information, contact us on: info@${name.toLowerCase().replace(" ", "")}.com")
        println("=========================================================================")
        println()
    }

    // Getter for school name
    fun getSchoolName() = name

    // This method adds students to list of school student
    fun addStudent(student: Student) = schoolStudents.add(student)

    // This method adds staffs to list of school staffs
    fun addStaff(staffs: Staffs) = schoolStaffs.add(staffs)

    // This method is used to add courses to the school
    fun addCourse(course: Course) = availableCourses.add(course)

    // This method adds classes to the list of classes in the school
    fun addClass(classes: Classes) = availableClasses.add(classes)

    // This method adds applicants to the list of applicants
    fun addApplicants(applicant: Applicant) = applicants.add(applicant)

    // This method removes applicants from the list of applicants
    fun removeApplicants(applicant: Applicant) = applicants.remove(applicant)

    // This method remove students from the list of school students
    fun removeStudent(student: Student) = schoolStudents.remove(student)


    // This method is use to display the list of applicants
    fun viewApplicants() {
        println("\t\t\tAPPLICATION PORTAL")
        println("====================================================")
        println("The following persons applied to $name: ")
        for (applicant in applicants) {
             applicant.details()
            println()
        }
        println("====================================================")
        println()
    }

    // This method display the list of students admitted into the school
    fun viewStudents() {
        println("\t\t\tADMISSION PORTAL")
        println("====================================================")
        println("The following persons have been admitted into $name: ")
        for (students in schoolStudents) {
            students.viewInfo()
            println()
        }
        println("====================================================")
        println()
    }

     /**
      * This method is used to check if a student exists in the school.
      * if it finds the given name, it returns the student object else
      * it returns null
    */
    fun findStudent(fullName: String): Student? {
        for (students in schoolStudents) {
            if (fullName.equals(students.getStudentFullName(),ignoreCase = true)) {
                return students
            }
        }
        return null
    }


    // This method display the available classes in the school
    private fun viewClasses() {
        for (classes in availableClasses) {
            println("\t${classes.getClassName()}")
        }
    }

    // This method is use to add students to the respective classes they applied to. It called by the principal when admitting students
    fun addStudentToClass(): Boolean{
       for (students in schoolStudents) {
           for (classes in availableClasses) {
               if (students.getStudentClass().getClassName() == classes.getClassName() && students !in classes.admittedStudents()) {
                   classes.addStudent(students)
               }
            }

        }
        return true
    }

    // This method is use to remove student from their respective classes. It is called by the principal when expelling student
    fun removeStudentFromClass(student: Student): Boolean{
        for (students in schoolStudents) {
            for (classes in availableClasses) {
                if (students.getStudentClass().getClassName() == classes.getClassName() && students == student) {
                    classes.removeStudent(students)
                }
            }

        }
        return true
    }

}