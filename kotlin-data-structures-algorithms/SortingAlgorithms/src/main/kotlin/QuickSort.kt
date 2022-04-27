fun main() {
    val arr = arrayOf(90,23,101,45,65,28,67,89,34,29)
    quickSort(arr, 0, arr.size - 1)
    arr.forEach {
        println(it)
    }
}

fun partition(arr: Array<Int>, beg: Int, end: Int): Int {
    /* Pivot is the last element */
    var pivot = arr[end];
    var i = (beg-1); // index of smaller element

    for (j in beg..end) {
        /* If current element is smaller than the pivot */
        if (arr[j] < pivot) {
            i++;

            /* swap arr[i] and arr[j] */
            var temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    /* swap arr[i+1] and arr[end], the pivot */
    var temp = arr[i+1];
    arr[i+1] = arr[end];
    arr[end] = temp;

    return i+1;
}

fun quickSort(arr: Array<Int>, beg: Int, end: Int) {
    if(beg < end) {
        var pi = partition(arr, beg, end)
        quickSort(arr, beg,pi - 1)
        quickSort(arr, pi + 1, end)
    }
}