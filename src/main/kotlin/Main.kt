fun main() {
    println("Введите массив слов через пробел:")
    val input = readLine()?.split(" ") ?: emptyList()

    val groupedWords = groupWordsByLetters(input)

    println("Группы слов:")
    for (group in groupedWords) {
        println(group.joinToString(", "))
    }
}

fun groupWordsByLetters(words: List<String>): List<List<String>> {
    val groupsMap = mutableMapOf<String, MutableList<String>>()

    for (word in words) {
        val sortedWord = word.toCharArray().sorted().joinToString("")
        groupsMap.getOrPut(sortedWord) { mutableListOf() }.add(word)
    }

    return groupsMap.values.toList()
}
