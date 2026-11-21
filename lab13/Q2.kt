
// (1) Function with default parameters
fun displayDetails(name: String = "Kanak", age: Int = 20) {
    println("Name: $name")
    println("Age: $age")
}

// (3) Function with vararg
fun printNumbers(vararg numbers: Int) {
    println("Numbers:")
    for (num in numbers) {
        println(num)
    }
}

// (4) Higher-order function
fun applyOperation(numbers: List<Int>, operation: (Int) -> Int) {
    for (num in numbers) {
        println(operation(num))
    }
}

fun main() {

    // 1. Default arguments
    println("Default Parameters:")
    displayDetails()
    displayDetails("sanya", 22)

    // 2. Named arguments (out of order)
    println("\nNamed Arguments:")
    displayDetails(age = 25, name = "avinash")

    // 3. Vararg function
    println("\nVararg Function:")
    printNumbers(10, 20, 30, 40, 50)

    // 4. Higher-order function with lambda
    println("\nHigher-Order Function:")
    val numbers = listOf(1, 2, 3, 4, 5)

    applyOperation(numbers) { it * it }
}
