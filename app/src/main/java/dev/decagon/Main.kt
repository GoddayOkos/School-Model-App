package dev.decagon

import dev.decagon.Principal.Companion.makePrincipal


fun main() {

    // this app can model any school with full functionality, for testing sake, let's try and model Decagon Institute
    // create a school, classes, add the classes to the school and display the school's information/profile

    val school = School("Decagon Institute", "Elite Software Engineering Training Center", "Private")
    val classA = Classes("Android", 5)
    val classJ = Classes("Java", 4)
    val classP = Classes("Python", 3)
    val classN = Classes("Node", 2)
    school.addClass(classA)
    school.addClass(classJ)
    school.addClass(classP)
    school.addClass(classN)
    school.info()

    // create and add courses to the school

    val courseA = Course("Kotlin", "Kt 101")
    val courseAJ = Course("Java", "java 211")
    val courseN = Course("javascript", "js 111")
    val courseAG = Course("Agile", "AG 101")
    val courseALG = Course("Algorithm", "ago 111")
    school.addCourse(courseA)
    school.addCourse(courseAJ)
    school.addCourse(courseN)
    school.addCourse(courseALG)
    school.addCourse(courseAG)

    // add staffs to school
    // if no principal already exists in the school, this method will make   "Nkem" the principal otherwise, it notifies the user and return null.
    // Principal.makePrincipal()
    val principal = makePrincipal("Nkem", "Alozie", school)
    val mentor1 = Teacher("Ari", "Tamunomiebi", courseA, classA)
    val mentor2 = Teacher("Bond", "Akinmade", courseN, classN)
    val mentor3 = Teacher("Abdulrasaq", "Durosomo", courseAJ, classA)
    val mentor4 = Teacher("David", "Odoye", courseAJ, classJ)
    val mentor5 = Teacher("Solanke", "Olamilekan", courseAG, classP)
    val mentor6 = Teacher("Osehiase", "Ehilen", courseA, classA)
    val hr = NonAcademicStaff("Fatimath", "Bawa-Allah", "Program Associate")

    if (principal != null) school.addStaff(principal)
    school.addStaff(mentor1)
    school.addStaff(mentor2)
    school.addStaff(mentor3)
    school.addStaff(mentor4)
    school.addStaff(mentor5)
    school.addStaff(mentor6)
    school.addStaff(hr)

    // display staffs information
    principal?.viewInfo()
    mentor1.viewInfo()
    mentor2.viewInfo()
    mentor3.viewInfo()
    mentor4.viewInfo()
    mentor5.viewInfo()
    mentor6.viewInfo()

    // some actions
    mentor1.teach()
    println()
    hr.roles()

    // now that our school is ready, lets create some applicants. Applicants of age in 12..20 will be admitted.
    val applicant1 = Applicant("Godday", "Okoduwa", 15, 1, classA, school)
    val applicant2 = Applicant("Jesse", "Okoro", 13, 2, classA, school)
    val applicant3 = Applicant("Salifu","Abubarka", 20, 2, classJ, school)
    val applicant4 = Applicant("Shayo", "Abe", 20, 1, classN, school)
    val applicant5 = Applicant("Roland", "Chibueze", 18, 1, classP, school)
    val applicant6 = Applicant("John", "Obi", 25, 2, classJ, school) // John would be denied admission because of his age

    // lets view the school's application portal
    school.viewApplicants()

    //Now that we have some applicants, lets get the principal to work.
    //Admitted applicants are removed from the applicants portals as they become students after admission.
    //likewise, unsuccessful applicants are also removed from the applicants portal as they are no longer considered applicants after rejection.
    principal?.admitStudent(applicant1)
    principal?.admitStudent(applicant2)
    principal?.admitStudent(applicant3)
    principal?.admitStudent(applicant4)
    principal?.admitStudent(applicant5)
    principal?.admitStudent(applicant6)

    //Now that the principal has made admission decision, lets check our applicants portal to be sure that it is empty.
    school.viewApplicants()

    //Now lets see the successful applicants by viewing the school's admission portal
    school.viewStudents()

    //lets see if the students were added to their respective classes of choice. We don't want a situation whereby
    //someone who applied to android is added to the wrong class like node for instance.
    classA.viewClassDetails()
    classJ.viewClassDetails()
    classN.viewClassDetails()
    classP.viewClassDetails()

    // now that we confirmed the students were added to their classes of choice, they can now register for courses
    //but before then, we need to search the school with the students full name to see if the student really exit before they can register courses.
    val student1 = school.findStudent("Godday Okoduwa")
    student1?.registerCourse(courseA)
    student1?.registerCourse(courseAJ)
    student1?.registerCourse(courseAG)
    student1?.registerCourse(courseALG)

    val student2 = school.findStudent("Jesse Okoro")
    student2?.registerCourse(courseA)
    student2?.registerCourse(courseAG)
    student2?.registerCourse(courseALG)

    val student3 = school.findStudent("Salifu Abubarka")
    student3?.registerCourse(courseAJ)
    student3?.registerCourse(courseAG)
    student3?.registerCourse(courseALG)

    val student4 = school.findStudent("Shayo Abe")
    student4?.registerCourse(courseN)
    student4?.registerCourse(courseAG)
    student4?.registerCourse(courseALG)

    val student5 = school.findStudent("Roland Chibueze")
    student5?.registerCourse(courseAG)
    student5?.registerCourse(courseALG)

    // lets view the various classes again to see the if the courses registered by the students were successful
    classA.viewClassDetails()
    classJ.viewClassDetails()
    classN.viewClassDetails()
    classP.viewClassDetails()

    //Noticed there are currently two students in android class, Godday and Jesse.
    // assumed Jesse misbehaved and the principal decided to expel him from the school.
    if (student2 != null) principal?.expelStudent(student2)

    //lets view the android class more time to be sure Jesse was actually expelled.
    classA.viewClassDetails()

    //lastly, lets see the admission portal to confirm that Jesse is no longer on the list.
    school.viewStudents()

    // now, lets just try and create another principal and see what happens
    // a warning should be display telling us principal already exist
    val principal2 = makePrincipal("John", "Smith", school)



}
