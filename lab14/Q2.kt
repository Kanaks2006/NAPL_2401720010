
fun main() {

    // 1. Nullable and Non-nullable Variables

    println("----- NULLABLE AND NON-NULLABLE VARIABLES -----")

    var name: String = "Kanak"
    var city: String? = null

    println("Non-nullable String: $name")
    println("Nullable String: $city")

    // name = null  // This gives a compile-time error
    city = "Delhi"
    println("Updated Nullable String: $city")


    // 2. Safe Call Operator (?.)

    println("\n----- SAFE CALL OPERATOR -----")

    var message: String? = "Hello Kotlin"

    println("Message length: ${message?.length}")

    message = null
    println("Message length when null: ${message?.length}")


    // 3. Elvis Operator (?:)

    println("\n----- ELVIS OPERATOR -----")

    var username: String? = null

    val result = username ?: "Guest"

    println("Username: $result")


    // 4. Not-null Assertion Operator (!!)

    println("\n----- NOT-NULL ASSERTION OPERATOR -----")

    var text: String? = null

    try {
        println("Text length: ${text!!.length}")
    } catch (e: NullPointerException) {
        println("Exception caught: NullPointerException")
    }

    println("Program continues after exception.")
}
