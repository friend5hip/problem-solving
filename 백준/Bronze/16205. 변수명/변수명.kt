fun main() {
    val input = readLine()!!.split(" ")
    val type = input[0].toInt()
    val variableName = input[1]

    val camelCase: String
    val snakeCase: String
    val pascalCase: String

    when (type) {
        1 -> { // 카멜 표기법
            camelCase = variableName
            snakeCase = camelToSnake(variableName)
            pascalCase = camelToPascal(variableName)
        }
        2 -> { // 스네이크 표기법
            camelCase = snakeToCamel(variableName)
            snakeCase = variableName
            pascalCase = camelToPascal(camelCase)
        }
        3 -> { // 파스칼 표기법
            pascalCase = variableName
            camelCase = pascalToCamel(variableName)
            snakeCase = camelToSnake(camelCase)
        }
        else -> throw IllegalArgumentException("Invalid input type")
    }

    println(camelCase)
    println(snakeCase)
    println(pascalCase)
}

// 카멜 -> 스네이크
fun camelToSnake(input: String): String {
    return input.fold(StringBuilder()) { acc, c ->
        if (c.isUpperCase()) acc.append("_").append(c.lowercaseChar()) else acc.append(c)
    }.toString()
}

// 카멜 -> 파스칼
fun camelToPascal(input: String): String {
    return input.replaceFirstChar { it.uppercase() }
}

// 스네이크 -> 카멜
fun snakeToCamel(input: String): String {
    return input.split("_").joinToString("") { it.replaceFirstChar { char -> char.uppercase() } }
        .replaceFirstChar { it.lowercase() }
}

// 파스칼 -> 카멜
fun pascalToCamel(input: String): String {
    return input.replaceFirstChar { it.lowercase() }
}
