import kotlin.system.exitProcess

/* Simple stack implementation with array */
class Stack(
        private val size: Int,
        private var arr: IntArray = IntArray(size),
        private var top: Int = -1
) {
    fun push(e: Int) {
        if (top == arr.size - 1) {
            println("Overflow error. The Stack is full!")
            exitProcess(0)
        } else {
            top++
            arr[top] = e
        }
    }

    fun pop(): Int {
        if (top < 0) {
            println("Underflow error. The Stack is empty!")
            exitProcess(0)
        } else {
            val n = arr[top]
            top --
            return n
        }
    }

    fun isEmpty(): Boolean {
        return top < 0
    }
}

fun main() {
    var s = Stack(10)
    s.isEmpty()
    s.push(2)
    s.push(5)
    s.push(8)
    println(s.pop())
    println(s.pop())
    s.push(9)
    println(s.pop())
    s.isEmpty()
}