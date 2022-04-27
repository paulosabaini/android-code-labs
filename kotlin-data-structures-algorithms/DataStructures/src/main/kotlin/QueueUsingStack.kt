class QueueUsingStack {
    var S1 = Stack(10)
    var S2 = Stack(10)

    fun enqueue(x: Int) {
        S1.push(x)
        println("inserted $x")
    }

    fun dequeue(): Int {
        while (!S1.isEmpty()) {
            val x = S1.pop()
            S2.push(x)
        }

        val r = S2.pop()

        while (!S2.isEmpty()) {
            val x = S2.pop()
            S1.push(x)
        }

        return r
    }
}

fun main() {
    val q = QueueUsingStack()
    q.enqueue(10)
    q.enqueue(100)
    q.enqueue(1000)
    println("removed element ${q.dequeue()}")
}