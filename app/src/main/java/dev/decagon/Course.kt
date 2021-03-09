package dev.decagon

class Course(courseName: String, courseCode: String){

    private val courseName = courseName.toUpperCase()
    private val courseCode = courseCode.toUpperCase()

    // Getter for course name
    fun getCourseName() = courseName
    // Getter for course code
    fun getCourseCode() = courseCode
}