class NodeCLL (var data: Int, var next: NodeCLL? = null) {

}

class CircularLinkedList(var head: NodeCLL? = null) {

    fun addAtFront(n: NodeCLL): Int {
        var i = 0
        if (head == null) {
            n.next = head
            head = n
            i++
        } else {
            n.next = head
            val last = getLastNodeCLL()
            last.next = n
            head = n
            i++
        }
        return i
    }

    fun isEmpty(): Boolean {
        return head == null
    }

    private fun getLastNodeCLL(): NodeCLL {
        var tmp = head

        while (tmp?.next != head) {
            tmp = tmp?.next
        }

        return tmp!!
    }

    fun addAtEnd(n: NodeCLL) {
        if(head == null) {
            head = n
            n.next = head
        } else {
            var last = getLastNodeCLL()
            last.next = n
            n.next = head
        }
    }

    fun search(x: Int): NodeCLL? {
        var tmp = head

        while (tmp != null && tmp.data != x) {
            tmp = tmp?.next
        }

        return tmp
    }

    fun deleteNode(x: Int): NodeCLL? {
        var n = search(x)
        var h = head

        if (h == null) {
            return null
        } else if (h == n) {
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

        while (tmp?.next != head) {
            print(" ${tmp?.data} ")
            tmp = tmp?.next
        }
    }
}

fun main() {
    var L = CircularLinkedList()

    for (i in 10..15) {
        val n = NodeCLL(i)
        L.addAtEnd(n)
    }

    L.addAtFront(NodeCLL(99))
    L.deleteNode(13)
    println(L.search(14)?.data)

    L.print()
}