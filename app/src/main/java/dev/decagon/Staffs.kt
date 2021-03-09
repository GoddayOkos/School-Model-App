package dev.decagon

abstract class Staffs(protected val firstName: String, protected val lastName: String) {
    //This method display the full name and role of the staff
    open fun roles() {
        println("My name is $firstName $lastName, I'm a staff in this school.")
    }
}