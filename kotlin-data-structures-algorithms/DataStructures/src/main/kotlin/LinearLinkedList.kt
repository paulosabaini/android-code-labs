class Node (var data: Int, var next: Node? = null) {

}

class LinkedList(var head: Node? = null) {

    fun addAtFront(n: Node): Int {
        var i = 0
        n.next = head
        head = n
        i++
        return i
    }

    fun isEmpty(): Boolean {
        return head == null
    }

    fun getLastNode(): Node {
        var tmp = head

        while (tmp?.next != null) {
            tmp = tmp.next
        }

        return tmp!!
    }

    fun addAtEnd(n: Node) {
        if(head == null) {
            head = n
            n.next = null
        } else {
            var n2 = getLastNode()
            n2.next = n
        }
    }

    fun search(x: Int): Node? {
        var tmp = head

        while (tmp != null && tmp.data != x) {
            tmp = tmp?.next
        }

        return tmp
    }

    fun deleteNode(x: Int): Node {
        var n = search(x)
        var h = head

        if(h == n ) {
            h?.next = n?.next
            return n!!
        } else {
            while (h?.next != n) {
                h = h?.next
            }
            h?.next = n?.next
            return n!!
        }
    }

    fun print() {
        var tmp = head

        while (tmp != null) {
            print(" ${tmp.data} ")
            tmp = tmp.next
        }
    }
}

fun main() {
    var L = LinkedList()

    for (i in 10..15) {
        val n = Node(i)
        L.addAtEnd(n)
    }

    L.addAtFront(Node(99))
    L.deleteNode(13)
    println(L.search(14)?.data)

    L.print()
}