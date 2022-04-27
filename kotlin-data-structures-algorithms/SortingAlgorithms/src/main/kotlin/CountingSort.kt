/* Maximum element of A[] */
val k = 8

fun main() {
    val A = arrayOf(1, 3, 2, 8, 5, 1, 5, 1, 2, 7)
    val n = A.size
    var B = IntArray(n)

    countingSort(A, B, n-1)

    B.forEach {
        println(it)
    }
}

fun countingSort(A: Array<Int>, B: IntArray, n: Int) {
    var count = IntArray(k+1)
    var u = -1

    /* Initialize count array */
    for (i in 0..k) count[i] = 0

    /* Count the occurrence of elements u of A
	   and increment count[u] where u=A[i] */
    for (i in 0..n) {
       u = A[i]
       count[u]++
    }

    /* Updating elements of count array */
    for (i in 1..k) count[i] = count[i] + count[i - 1]

    for (i in 0..n) {
        /* Add elements of array A to array B */
        u = A[i]
        B[count[u]-1] = u
        /* Decrement the count value by 1 */
        count[u] = count[u] - 1
    }

}