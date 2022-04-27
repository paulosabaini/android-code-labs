fun main() {
    val values = arrayOf(13, 21, 54, 81, 90)
    val len = values.size
    var target = 81

    println(binarySearch(values, len, target))
    target = 99
    println(binarySearch(values, len, target))
}

fun binarySearch(values: Array<Int>, len: Int, target: Int): Int {
    /* Variables to delimit the length of the half of the array that will be searched  */
    var max = len - 1
    var min = 0

    /* Repeat until the element is found or the maximum number of divisions is reached  */
    while (max >= min) {
        /* Variable who will store the middle position of the array */
        var middle = (max + min) / 2

        /* If the target is greater than the element on the middle the target will be in the right half.
         * If the target is lower than the element on the middle the target will be in the left half.
         * Otherwise the target is localized and his position is returned */
        when {
            target > values[middle] -> min = middle + 1
            target < values[middle] -> max = middle - 1
            else -> return middle
        }
    }
    /* Target not found */
    return -1
}