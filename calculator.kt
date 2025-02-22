fun main() {
    print("Enter first number: ")
    val num1 = readLine()!!.toDouble()

    print("Enter an operator (+, -, *, /): ")
    val operator = readLine()!!.first()

    print("Enter second number: ")
    val num2 = readLine()!!.toDouble()

    val result = when (operator) {
        '+' -> num1 + num2
        '-' -> num1 - num2
        '*' -> num1 * num2
        '/' -> if (num2 != 0.0) num1 / num2 else {
            println("Error: Division by zero is not allowed.")
            return
        }
        else -> {
            println("Invalid operator!")
            return
        }
    }

    println("Result: $result")
}
