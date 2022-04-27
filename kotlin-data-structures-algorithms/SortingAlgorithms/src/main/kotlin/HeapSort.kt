fun main() {
    val arr = arrayOf(121, 10, 130, 57, 36, 17)
    val n = arr.size

    heapSort(arr,n)

    arr.forEach {
        println(it)
    }
}

fun heapify(arr: Array<Int>, n: Int, i: Int) {
    var largest = i
    var l = 2 * i + 1
    var r = 2 * i + 2

    /* If left child is larger than root */
    if (l < n && arr[l] > arr[largest]) largest = l

    /* If right child is larger than largest so far */
    if (r < n && arr[r] > arr[largest]) largest = r

    /* If largest is not root */
    if (largest != i) {
        val temp = arr[i]
        arr[i] = arr[largest]
        arr[largest] = temp

        /* Recursively heapify the affected sub-tree */
        heapify(arr, n, largest)
    }

}

fun heapSort(arr: Array<Int>,n: Int) {
    /* Build heap */
    for (i in n / 2 - 1 downTo 0) heapify(arr, n, i)

    /* One by one extract an element from heap */
    for (i in n - 1 downTo 1) {
        /* Move current root to end */
        val temp = arr[0]
        arr[0] = arr[i]
        arr[i] = temp

        /* call max heapify on the reduced heap */
        heapify(arr, i, 0)
    }
}