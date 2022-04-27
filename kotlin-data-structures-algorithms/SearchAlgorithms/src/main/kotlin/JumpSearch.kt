import kotlin.math.sqrt

fun main() {
    val A = arrayOf(0, 1, 1, 2, 3, 5, 8, 13, 21, 55, 77, 89, 101, 201, 256, 780)
    val item = 77

    println(jumpSearch(A, item))
}

fun jumpSearch(A: Array<Int>, item: Int): Int {
    val n = A.size
    /* The number of elements that will be skipped in the search */
    var jump = sqrt(n-1.toFloat()).toInt()
    /* Incremental variables used to do the jumps */
    var m = jump
    var i = 0

    /* Jump the blocks */
    while (A[m] <= item && m < n-1) {
        i = m
        m += jump

        /* If the jump exceeds the length of the array */
        if (m > n - 1) return -1
    }

    /* The above 'while' will execute until the item searched is before the current block delimited by
     * the position (m), after that a linear search is performed from the beginning of that block until
     * his end to encounter the searched element
     */
    for (x in i..m) {
        if (A[x] == item) return x
    }

    /* Item not found */
    return - 1
}