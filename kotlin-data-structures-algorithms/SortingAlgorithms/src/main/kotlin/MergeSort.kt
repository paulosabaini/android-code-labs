fun main() {
    val arr = arrayOf(32, 45, 67, 2, 7)
    mergeSort(arr,0,arr.size-1)
    arr.forEach {
        println(it)
    }
}

fun merge(arr: Array<Int>, l: Int, m: Int, r: Int) {
    /* Sizes of the two sub-arrays to be merged */
    val n1 = m - l + 1
    val n2 = r - m

    /* Temp arrays */
    var L = IntArray(n1)
    var R = IntArray(n2)

    /* Copy data to temp arrays */
    for (i in 0..n1-1) L[i] = arr[l+i]
    for (j in 0..n2-1) R[j] = arr[m + 1 + j]

    /* Index of L and R arrays */
    var (i, j) = arrayOf(0, 0)

    /* Index of merged array */
    var k = l

    /* Merge the arrays */
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i]
            i++
        } else {
            arr[k] = R[j]
            j++
        }
        k++
    }

    while(i < n1) {
        arr[k] = L[i]
        i++
        k++
    }

    while (j < n2) {
        arr[k] = R[j]
        j++
        k++
    }
}

fun mergeSort(arr: Array<Int>, l: Int, r: Int) {
    if (l < r) {
        /* Find the middle of the array */
        val m = (l + r) / 2
        /* Break the array into two sub-arrays */
        mergeSort(arr, l, m)
        mergeSort(arr,m+1, r)
        /* Merge the sub-arrays */
        merge(arr, l, m, r)
    }
}