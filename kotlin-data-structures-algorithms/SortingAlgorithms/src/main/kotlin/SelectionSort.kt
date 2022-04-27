fun main() {
    val arr = arrayOf(46, 52, 21, 22, 11)
    selectionSort(arr)
}

fun selectionSort(arr: Array<Int>) {
    var n = arr.size-1

    for (i in 0..n) {
        /* Found the smallest element*/
        var min = arr[i]
        var minIndex = i
        for (j in i+1..n) {
            if (min > arr[j]) {
                min = arr[j]
                minIndex = j
            }
        }
        /* Put the smallest number in the beginning */
        val aux = arr[i]
        arr[i] = min
        arr[minIndex] = aux
    }

    arr.forEach {
        println(it)
    }
}