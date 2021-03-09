package dev.decagon

class Applicant(firstName: String, lastName: String, age: Int, year: Int, Class: Classes, school: School) {

    private val firstName = firstName.capitalize()
    private val lastName = lastName.capitalize()
    private val age = age
    private val yearOfStudy = year                        // applicants proposed year of study
    private var applicantID: String = ""                  // Unique 6 digits ID generated randomly and automatically for applicants
    private val Class: Classes = Class                    // The applicant's proposed class of study
    private val school: School = school                   // The school applied to


    // The init block automatically set the applicant ID
    // and adds the applicant to the list of applicants in the school applied to.
    init {
        setApplicantId()
        school.addApplicants(this)
    }

    // Getter for applicant's first name
    fun getFirstName() = firstName

    // Getter for applicant's last name
    fun getLastName() = lastName

    // Getter for applicant's age
    fun getAge() = age

    // Getter for applicant's year of study
    fun getYearOfStudy() = yearOfStudy

    // Getter for applicant's ID
    fun getApplicantID() = applicantID

    // Getter for applicant's Class
    fun getClass() = Class

    // Getter for applicant's school
    fun getSchool() = school

    // This method generates a random 6 digits ID each applicants starting with applicant's year of study.
    // The method is called by the init block anytime an instance of applicant is created
    private fun setApplicantId() {
        val id = ((Math.random() + 1) * 10000).toInt()
        applicantID = yearOfStudy.toString() + id
    }

    // This method display applicant details in the console
    fun details() {
        println("Name: $firstName $lastName\nApplicant ID: $applicantID\nAge: $age years\n" +
                "Class Applied to: ${Class.getClassName()} \nYear of Study: $yearOfStudy")
    }
}