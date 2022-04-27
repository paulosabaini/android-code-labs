fun main() {
    val array = arrayOf(5, 1, 6, 2, 4, 3)
    insertionSort(array)
}

fun insertionSort(array: Array<Int>) {
    val n = array.size - 1

    /* Iterate the given array starting from the second element. For each number a new iteration is made to compare
     * it to the previous numbers, when a previous element is greater than the key, the key is inserted before him. */
    for(i in 1..n) {
        var j = i
        while (j > 0 && array[j-1] > array[j]) {
            var key = array[j]
            array[j] = array[j-1]
            array[j - 1] = key
            j--
        }
    }

    array.forEach {
        println(it)
    }
}