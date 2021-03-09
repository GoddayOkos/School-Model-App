package dev.decagon

class Classes(private val name: String, private var capacity: Int) {

    private val admittedStudents: ArrayList<Student> = ArrayList()            // ArrayList of students admitted into the class

    private var numberOfStudents = 0                                         // initial number of students in the class before admission

    // Getter for the class name
    fun getClassName() = name

    // Getter for the ArrayList of admitted students
    fun admittedStudents() = admittedStudents

    // This method is use to add admitted students to the classes depending on the slot/capacity of the class.
    fun addStudent(student: Student): Boolean {
        return if (numberOfStudents < capacity) {
            admittedStudents.add(student)
            numberOfStudents += 1
            true
        } else {
            println("CAPACITY EXCEEDED! Can't add more students to this class")
            false
        }

    }

    // This method is used to remove students from class.
    fun removeStudent(student: Student): Boolean {
        admittedStudents.remove(student)
        numberOfStudents--
        return true
    }

    // This method display the details of the class including the students information
    fun viewClassDetails() {
        println("\t${name.toUpperCase()} CLASS DETAILS")
        println("==============================")
        println("Class Name : $name\nClass Capacity: $capacity\nNumber of Admitted Students: $numberOfStudents\nStudents Information: ")
        println()
        for (students in admittedStudents) {
            students.viewInfo()
            println()
        }
        println("==============================")
        println()
    }
}