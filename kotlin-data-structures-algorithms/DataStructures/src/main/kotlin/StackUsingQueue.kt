class StackUsingQueue(val size: Int) {
    var Q1 = Queue(size)
    var Q2 = Queue(size)

    fun push(x: Int) {
        /* Move all elements in Q1 to Q2 */
        while (!Q1.isEmpty()) {
            var temp = Q1.dequeue()
            Q2.enqueue(temp)
        }

        /* Add the element which is pushed into Stack */
        Q1.enqueue(x)

        /* Move back all elements back to Q1 from Q2 */
        while (!Q2.isEmpty()) {
            var temp = Q2.dequeue()
            Q1.enqueue(temp)
        }
    }

    fun pop(): Int {
        return Q1.dequeue()
    }
}

fun main() {
    var s = StackUsingQueue(10)

    s.push(10)
    s.push(15)
    s.push(20)
    println(s.pop())
}