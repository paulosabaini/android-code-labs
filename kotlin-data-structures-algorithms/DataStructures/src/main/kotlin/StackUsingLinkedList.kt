class StackUsingLinkedList {
    var l = LinkedList()

    fun push(x: Int) {
        l.addAtEnd(Node(x))
    }

    fun pop(): Int {
        val n = l.getLastNode()
        l.deleteNode(n.data)
        return n.data
    }

    fun top(): Int {
        return l.getLastNode().data
    }
}

fun main() {
    var s =StackUsingLinkedList()
    s.push(10)
    s.push(15)
    s.push(20)
    println(s.pop())
    println(s.pop())
    println(s.top())
}