package dev.decagon

/**
 *                               ASSUMPTIONS:
 *  A new instance of student can only be created from the admitted applicants
 *  Only the principal of the school can admitted students, hence only the principal
 *  should have access to the Student class constructor
 *  The constructor for the Student class is private and can only accept an applicant as a parameter
*/
class Student private constructor(applicant: Applicant) {

    companion object {
        /**
         * This method takes an applicant as the argument and return an instance of Student
         * by calling the private constructor of the Student class.
         * This method is called when the principal wants to admit an applicant into the school.
        */
        fun createStudent(applicant: Applicant): Student {
            return Student(applicant)
        }
    }

    // On admission, an applicant becomes a student, hence,
    // the applicant's properties becomes the student properties.
    private val firstName = applicant.getFirstName()
    private val lastName = applicant.getLastName()
    private val studentID = applicant.getApplicantID()
    private val age = applicant.getAge()
    private val Class = applicant.getClass()
    private val yearOfStudy = applicant.getYearOfStudy()
    private val school: School = applicant.getSchool()
    private val myCourses: ArrayList<Course> = ArrayList()         // ArrayList to hold the courses registered by the student

    // Once a student instance is created, this init block automatically adds the student to the
    // list of admitted students in the school and removes the student from the applicant list
    init {
        school.addStudent(this)
        school.removeApplicants(applicant)
    }

    // This method is use to register courses by the students by adding courses to the ArrayList of courses
    fun registerCourse(course: Course) = myCourses.add(course)

    // Getter for student's first name
    fun getStudentFirstName() = firstName

    // Getter for student's full name
    fun getStudentFullName() = "$firstName $lastName"

    // Getter for student's Class
    fun getStudentClass() = Class

    // This method displays the course code and course name of the courses registered by the student
    private fun viewCourses() {
        for (courses in myCourses) {
            println("\t" + courses.getCourseCode() +" ==> "+ courses.getCourseName())
        }
    }

    // This method displays student information including registered courses
    fun viewInfo() {
        println("Name: $firstName $lastName\nStudent ID: $studentID\nAge: $age years\n" +
                "Class: ${Class.getClassName()} \nYear of Study: $yearOfStudy\nCourses Registered: ")
        viewCourses()
    }


}