fun main() {
 val arr = arrayOf(2, 3, 34, 22, 11)
 bubbleSort(arr)
}

fun bubbleSort(arr: Array<Int>) {
    val n = arr.size - 1
    /* Flag to stop the execution if no swap is made */
    var flag = 0

    /* Iterate over the array and do the swaps */
    for (i in 0..n){
        for(j in 0..n-i-1) {
            if (arr[j] > arr[j+1]) {
                /* Swap the values */
                val temp = arr[j]
                arr[j] = arr[j+1]
                arr[j+1] = temp
                /* Swapping happened */
                flag = 1
            }
        }
        /* If no swap was done after the iterations, stop the loop */
        if (flag == 0) break
    }

    arr.forEach {
        println(it)
    }
}