fun main() {
    /* Search an value that exists in the array */
    val values = arrayOf(5, 34, 65, 12, 77, 35)
    println(linearSearch(values, 77, values.size))
    println(values.indexOf(77))

    /* Search an value that not exists in the array */
    val values2 = arrayOf(101, 392, 1, 54, 32, 22, 90, 93)
    println(linearSearch(values2, 200, values2.size))
    println(values2.indexOf(200))
}

fun linearSearch(values: Array<Int>, target: Int, n: Int): Int {
    /* Traverse the array until the searched element is encountered, if not, return -1 */
    for (i in 0..n-1){
        if (values[i] == target){
            return i
        }
    }
    /* Target not found */
    return -1
}