import kotlin.system.exitProcess

class Queue (
        private val size: Int,
        private var head: Int = -1,
        private var tail: Int = -1,
        private var arr: IntArray = IntArray(size)
) {
    fun enqueue(x: Int) {
        if (head == -1) head ++
        if (tail == size - 1) {
            println("Overflow error. The Queue is full!")
            exitProcess(0)
        } else {
            tail++
            arr[tail] = x
        }
    }

    fun dequeueAndShift(): Int {
        if(isEmpty()) {
            println("Underflow error. The Queue is empty!")
            exitProcess(0)
        } else {
            val n = arr[0]
            for (i in 0..tail) {
                arr[i] = arr[i+1]
            }
            tail--
            return n
        }
    }

    fun dequeue(): Int {
        if(isEmpty()) {
            println("Underflow error. The Queue is empty!")
            exitProcess(0)
        } else {
            val n = arr[head]
            if (head == tail) {
                head = -1
                tail = -1
            } else head++
            return n
        }
    }

    fun isEmpty(): Boolean {
        return (tail == -1 && head == -1)
    }

    fun display() {
        println("\nQueue Print\n")
       arr.forEach { println(it) }
    }
}

fun main() {
    val q = Queue(10)
    q.enqueue(10)
    q.enqueue(100)
    q.enqueue(1000)
    q.enqueue(1001)
    q.enqueue(1002)
    println("removed ${q.dequeue()}")
    q.enqueue(1003)
    println("removed ${q.dequeue()}")
    println("removed ${q.dequeue()}")
    q.enqueue(1004)
    q.display()
}