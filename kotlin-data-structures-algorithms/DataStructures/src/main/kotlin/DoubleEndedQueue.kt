class Dequeue (
        private val size: Int,
        private var front: Int = -1,
        private var rear: Int = -1,
        private var arr: IntArray = IntArray(size)
) {

    fun pushFront(x: Int) {
        if(full()) {
            println("overflow!")
        } else {
            /* If queue is empty */
            if(front == -1) {
                front = 0
                rear = 0
            } else if (front == 0) {
                /* If front points to the first position element */
                front = size - 1
            } else {
                --front
            }

            arr[front] = x
        }
    }

    fun pushBack(x: Int) {
        if(full()) {
            println("overflow")
        } else {
            if(front == -1) {
                front = 0
                rear = 0
            } else if (rear == size - 1) {
                rear = 0
            } else {
                ++rear
            }

            arr[rear] = x
        }
    }

    fun popFront() {
        if (empty()) {
            println("underflow")
        } else {
            if(front == rear) {
                front = -1
                rear = -1
            } else if (front == size - 1) {
                front = 0
            } else {
                ++front
            }
        }
    }

    fun popBack() {
        if (empty()) {
            println("underflow")
        } else {
            if(front == rear) {
                front = -1
                rear = -1
            } else if (rear == 0) {
                rear = size - 1
            } else {
                --rear
            }
        }
    }

    fun getFront(): Int {
        if (empty()) {
            return -1
        } else {
            return arr[front]
        }
    }

    fun getBack(): Int {
        if (empty()) {
            return -1
        } else {
            return arr[rear]
        }
    }

    fun full(): Boolean {
        return ((front == 0 && rear == size - 1) || (front == rear + 1))
    }

    fun empty(): Boolean {
        return front == -1
    }

}

fun main() {
    var q = Dequeue(10)
    q.pushFront(10)
    q.pushBack(100)
    q.pushFront(11)
    q.pushBack(101)
    println("front: ${q.getFront()}")
    println("back: ${q.getBack()}")
    q.popFront()
    q.popBack()
    println("front: ${q.getFront()}")
    println("back: ${q.getBack()}")
}