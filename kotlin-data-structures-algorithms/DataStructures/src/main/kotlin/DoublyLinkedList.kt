class NodeDLL (
        val data: Int,
        var prev: NodeDLL? = null,
        var next: NodeDLL? = null
)

class DoublyLinkedList (
        var front: NodeDLL? = null,
        var end: NodeDLL? = null
) {

    fun addFront(x: Int) {
        val n = NodeDLL(x)
        n.next = front

        /* List is empty */
        if(front == null) {
            end = n
        } else {
            front?.prev = n
        }

        front = n
    }

    fun addAfter(n: NodeDLL, x: Int) {
        val temp = NodeDLL(x)

        temp.next = n.next
        temp.prev = n

        /* If node is to be inserted after last node */
        if (n.next == null) {
            end = temp
        }

        n.next?.prev = temp
        n.next = temp
    }

    fun addBefore(n: NodeDLL, x: Int) {
        val temp = NodeDLL(x)

        temp.next = n
        temp.prev = n.prev

        /* If node is to be inserted before first node */
        if (n.prev == null) {
            front = temp
        }

        n.prev?.next = temp
        n.prev = temp


    }

    fun addEnd(x: Int) {
        val n = NodeDLL(x)
        n.prev = end

        if(end == null) {
            front = n
        } else {
            end?.next = n
        }

        end = n
    }

    fun deleteNode(n: NodeDLL) {
        /* If node to be deleted is first node of list */
        if (n.prev == null) {
            /* The next node will be front of list */
            front = n.next
            front?.prev = null
        } else if(n.next == null) {
            /*
             * If node to be deleted is last node of list
             * the previous node will be last of list */
            end = n.prev
            end?.next = null
        } else {
            /* Previous node's next will point to current node's next */
            n.prev?.next = n.next
            /* Next node's prev will point to current node's prev */
            n.next?.prev = n.prev
        }
    }

    fun forwardTraverse() {
        var trav = front

        while (trav != null) {
            print(" ${trav.data} ")
            trav = trav.next
        }
    }

    fun backwardTraverse() {
        var trav = end

        while (trav != null) {
            print(" ${trav.data} ")
            trav = trav.prev
        }
    }

    fun search(x: Int): NodeDLL? {
        var trav = front

        while (trav != null) {
            if(trav.data == x) return trav
            trav = trav.next
        }
        return null
    }
}

fun main() {
    val L = DoublyLinkedList()

    for (i in 5..10) {
        L.addEnd(i)
    }

    L.addFront(99)
    L.addAfter(L.search(99)!!,101)
    L.addBefore(L.search(101)!!, 100)
    L.deleteNode(L.search(8)!!)
    L.forwardTraverse()
    println("\n")
    L.backwardTraverse()
}