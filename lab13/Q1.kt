
fun main() {

    // Q1. Hello World
    println("Hello Kotlin!!!")

    // Q2. Employee Bonus Calculation
    print("\nEnter department code (IT/HR/FINANCE): ")
    val deptCode = readLine()!!.uppercase()

    print("Enter years of experience: ")
    val years = readLine()!!.toInt()

    print("Enter employee salary: ")
    val salary = readLine()!!.toDouble()

    val bonusPercentage = when {
        deptCode == "IT" && years > 5 -> 20
        deptCode == "HR" && years > 3 -> 15
        deptCode == "FINANCE" && years > 5 -> 18
        else -> 10
    }

    val bonus = salary * bonusPercentage / 100

    println("Bonus Percentage: $bonusPercentage%")
    println("Employee Bonus Amount: $bonus")

    // Q3. Average of Individual Digits
    print("\nEnter an integer: ")
    var num = kotlin.math.abs(readLine()!!.toInt())

    var sum = 0
    var count = 0

    while (num > 0) {
        val digit = num % 10
        sum += digit
        count++
        num /= 10
    }

    if (count > 0) {
        val average = sum.toDouble() / count
        println("Average of digits: $average")
    } else {
        println("Average of digits: 0.0")
    }
}
