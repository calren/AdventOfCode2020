import java.io.File
import java.io.InputStream

/**
 * --- Day 1: Report Repair ---
 *
 * https://adventofcode.com/2020/day/1
 *
 */

fun main(args: Array<String>) {
//    part1()
    part2()
}

// Find the two entries that sum to 2020; what do you get if you multiply them together?
fun part1() {
    val entries = getExpenseReportEntries()
    val sortedEntries = entries.sorted()
    val target = 2020
    var pointer1 = 0
    var pointer2 = sortedEntries.size - 1

    while (pointer1 < pointer2) {
        val currentSum = sortedEntries[pointer1] + sortedEntries[pointer2]
        if (currentSum == target) {
            print(sortedEntries[pointer1] * sortedEntries[pointer2])
            return
        } else if (currentSum < target) {
            pointer1++
        } else {
            pointer2--
        }
    }

    print("No answer found")
}

// Find three numbers in your expense report that meet the same criteria.
fun part2() {
    val entries = getExpenseReportEntries()
    val sortedEntries = entries.sorted()
}

fun getExpenseReportEntries(): List<Int> {
    val rootPath = Thread.currentThread().contextClassLoader.getResource(".")?.path
    val inputStream: InputStream = File(rootPath + "Day1.txt").inputStream()

    val entries = mutableListOf<Int>()

    inputStream.bufferedReader().forEachLine { entries.add(Integer.valueOf(it)) }
    return entries
}