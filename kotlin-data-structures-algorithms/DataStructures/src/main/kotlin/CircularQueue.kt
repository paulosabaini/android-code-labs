import kotlin.system.exitProcess

class CircularQueue (
        private val size: Int,
        private var head: Int = -1,
        private var tail: Int = -1,
        private var arr: IntArray = IntArray(size)
) {
    private fun isFull(): Boolean {
        return ((head == 0 && tail == size - 1) || (head == tail + 1))
    }

    private fun isEmpty(): Boolean {
        return (head == -1)
    }

    fun enqueue(x: Int) {
        if (isFull()) {
            println("Overflow error. The Queue is full!")
            exitProcess(0)
        } else {
            if (head == -1) head = 0
            tail = (tail + 1) % size
            arr[tail] = x
            println("inserted $x")
        }
    }

    fun dequeue(): Int {
        if(isEmpty()) {
            println("Underflow error. The Queue is empty!")
            exitProcess(0)
        } else {
            val n = arr[head]
            if (head == tail) {
                /* only one element in queue, reset queue after removal */
                head = -1
                tail = -1
            } else {
                head = (head + 1) % size
            }
            return n
        }
    }

    fun display() {
        if (isEmpty()) {
            println("\nEmpty Queue")
        } else {
            println("\nHead -> $head")
            print("Elements -> ")
            var i = head
            while (i != tail) {
                print("${arr[i]} ")
                i = (i + 1) % size
            }
            println(arr[i])
            println("Tail -> $tail")
        }
    }

    fun size(): Int {
        if(tail > head) {
            return (tail - head) + 1
        } else {
            return (size - (head - tail) + 1)
        }
    }
}

fun main() {
    val cq = CircularQueue(10)
    cq.enqueue(10)
    cq.enqueue(100)
    cq.enqueue(1000)
    println("Size of queue ${cq.size()}")
    print("Removed element: ${cq.dequeue()}")
    cq.display()
}