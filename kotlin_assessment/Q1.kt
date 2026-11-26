
data class Student(
    val id: Int,
    val name: String,
    val email: String?
)

data class Course(
    val courseName: String,
    val fee: Double,
    val instructor: String?
)

data class Registration(
    val student: Student,
    val course: Course,
    val marks: Int?
)

// Extension function 1: Check whether student passed
fun Registration.isPassed(): Boolean {
    return (marks ?: 0) >= 40
}

// Extension function 2: Display student details
fun Student.displayDetails(): String {
    return "Name: $name, Email: ${email ?: "Not Provided"}"
}

// Simple DSL for generating a report
class Report {
    private val lines = mutableListOf<String>()

    fun heading(title: String) {
        lines.add("\n===== $title =====")
    }

    fun addLine(text: String) {
        lines.add(text)
    }

    fun show() {
        lines.forEach { println(it) }
    }
}

fun report(block: Report.() -> Unit) {
    val r = Report()
    r.block()
    r.show()
}

fun main() {

    // Creating students
    val s1 = Student(1, "Kanak", "kanak@gmail.com")
    val s2 = Student(2, "Rahul", null)
    val s3 = Student(3, "Priya", "priya@gmail.com")

    // Creating courses
    val c1 = Course("Kotlin", 3000.0, "Amit")
    val c2 = Course("Python", 2500.0, "Neha")

    // Creating registrations
    val registrations = listOf(
        Registration(s1, c1, 85),
        Registration(s2, c2, 35),
        Registration(s3, c1, 75)
    )

    // 1. MAP: Get student names
    val names = registrations.map { it.student.name }
    println("Student Names: $names")

    // 2. FILTER: Get passed students
    val passed = registrations.filter { it.isPassed() }
    println("\nPassed Students:")
    passed.forEach { println(it.student.name) }

    // 3. REDUCE: Calculate total course fees
    val totalFees = registrations
        .map { it.course.fee }
        .reduce { total, fee -> total + fee }

    println("\nTotal Fees: $totalFees")

    // 4. GROUPBY: Group registrations by course
    val grouped = registrations.groupBy { it.course.courseName }

    println("\nRegistrations By Course:")
    grouped.forEach { (course, students) ->
        println("$course: ${students.size} students")
    }

    // Using extension function
    println("\nStudent Details:")
    println(s1.displayDetails())
    println(s2.displayDetails())

    // Using DSL to generate report
    report {
        heading("COURSE REGISTRATION REPORT")
        addLine("Total Registrations: ${registrations.size}")
        addLine("Passed Students: ${passed.size}")
        addLine("Total Fees: $totalFees")
        addLine("Available Courses: ${grouped.keys}")
    }
}
