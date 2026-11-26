
data class Student(val name: String, val percentage: Double)

fun main() {

    // 1. List - Mutable and Read-only

    println("----- LIST -----")

    val readOnlyList = listOf(10, 20, 30)
    println("Read-only List: $readOnlyList")
    println("Contains 20: ${readOnlyList.contains(20)}")
    println("Get element at index 1: ${readOnlyList[1]}")

    val mutableList = mutableListOf(10, 20, 30)
    mutableList.add(40)
    mutableList.remove(20)
    println("Mutable List after add and remove: $mutableList")
    println("Contains 10: ${mutableList.contains(10)}")
    println("Get element at index 0: ${mutableList[0]}")


    // 2. Set - Mutable and Read-only

    println("\n----- SET -----")

    val readOnlySet = setOf(10, 20, 30)
    println("Read-only Set: $readOnlySet")
    println("Contains 20: ${readOnlySet.contains(20)}")

    val mutableSet = mutableSetOf(10, 20, 30)
    mutableSet.add(40)
    mutableSet.remove(20)
    println("Mutable Set after add and remove: $mutableSet")
    println("Contains 10: ${mutableSet.contains(10)}")


    // 3. Map - Mutable and Read-only

    println("\n----- MAP -----")

    val readOnlyMap = mapOf(1 to "Apple", 2 to "Banana", 3 to "Mango")
    println("Read-only Map: $readOnlyMap")
    println("Get value for key 2: ${readOnlyMap[2]}")
    println("Contains key 1: ${readOnlyMap.containsKey(1)}")

    val mutableMap = mutableMapOf(1 to "Apple", 2 to "Banana")
    mutableMap[3] = "Mango"
    mutableMap.remove(2)
    println("Mutable Map after add and remove: $mutableMap")
    println("Get value for key 1: ${mutableMap[1]}")
    println("Contains key 3: ${mutableMap.containsKey(3)}")


    // 4. Functional Transformations

    println("\n----- FUNCTIONAL TRANSFORMATIONS -----")

    val numbers = listOf(1, 2, 3, 4, 5)

    val mapped = numbers.map { it * 2 }
    println("Original List: $numbers")
    println("After map (multiply by 2): $mapped")

    val filtered = numbers.filter { it > 2 }
    println("After filter (greater than 2): $filtered")

    val reduced = numbers.reduce { total, num -> total + num }
    println("After reduce (sum): $reduced")


    // 5. Sorting Student Objects

    println("\n----- SORTING STUDENTS -----")

    val students = listOf(
        Student("kanak", 85.5),
        Student("siya", 92.0),
        Student("ananya", 78.5),
        Student("Priya", 88.0)
    )

    val sortedStudents = students.sortedBy { it.percentage }

    println("Students sorted by percentage:")
    sortedStudents.forEach {
        println("${it.name} - ${it.percentage}%")
    }


    // 6. Grouping using groupBy

    println("\n----- GROUPING USING GROUPBY -----")

    val groupedStudents = students.groupBy {
        if (it.percentage >= 85) "Above 85%"
        else "Below 85%"
    }

    groupedStudents.forEach { (group, studentList) ->
        println("$group: ${studentList.map { it.name }}")
    }
}
