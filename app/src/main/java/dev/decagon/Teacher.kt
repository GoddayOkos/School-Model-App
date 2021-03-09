package dev.decagon

// Teacher class extends Staffs and a teacher is composed of courses-taught and classes taken
// which are stored in their respective ArrayList

class Teacher(firstName: String, lastName: String, course: Course, classes: Classes) : Staffs(firstName, lastName) {

    private val myClasses: ArrayList<Classes> = ArrayList()
    private val myCourses: ArrayList<Course> = ArrayList()

    // The init block automatically add the course and class passed to the Teacher's constructor to
    // their respective list anytime a teacher instance is created
    init {
        addClass(classes)
        addCourse(course)
    }

    // This method is use to assign classes to the teacher
    fun addClass(extraClass: Classes) = myClasses.add(extraClass)

    // This method is use to assign courses to the teacher
    fun addCourse(extraCourse: Course) = myCourses.add(extraCourse)

    // This method just displays a teacher doing his/her job
    fun teach() {
        println("Don't disturb me, I'm teaching my students in the classroom.")
    }

    // This method displays the teacher's information
    fun viewInfo() {
        println("\tTEACHER'S PROFILE")
        println("==========================")
        println("Name: $firstName $lastName\nRole: Teacher\nClasses Assigned: ")
        viewClasses()
        println("Courses Assigned: ")
        viewCourses()
        println("==========================")
        println()
    }

    // This method displays the courses that have been assigned to the teacher
    private fun viewCourses() {
        for (courses in myCourses) {
            println("\t" + courses.getCourseCode() +" ==> "+ courses.getCourseName())
        }
    }

    // This method display the classes that have been assigned to the teacher
    private fun viewClasses() {
        for (classes in myClasses) {
            println("\t" + classes.getClassName())
        }
    }

}