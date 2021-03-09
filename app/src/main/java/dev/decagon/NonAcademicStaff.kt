package dev.decagon

// Non Academic Staff extends Staffs and overrides the role method from the base class
class NonAcademicStaff(firstName: String, lastName: String, var role: String): Staffs(firstName, lastName) {
    @Override
    override fun roles() {
        super.roles()
        println("I function as the $role of this school and I do not teach.")
    }
}