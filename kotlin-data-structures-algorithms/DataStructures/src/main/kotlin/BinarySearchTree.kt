class TreeNode (
        var data: Int,
        var left: TreeNode? = null,
        var right: TreeNode? = null
)

class BinarySearchTree (var root: TreeNode? = null) {

    private fun insert(node: TreeNode, x: Int) {
        /* Element to be inserted is lesser than node’s data */
        if (x < node.data) {
            /* If left subtree is present */
            if (node.left != null) {
                insert(node.left!!, x)
            } else {
                /* Create new node */
                val n = TreeNode(x)
                node.left = n
            }
        } else if (x >= node.data) {
            /* If right subtree is present */
            if (node.right != null) {
                insert(node.right!!, x)
            } else {
                /* Create new node */
                val n = TreeNode(x)
                node.right = n
            }
        }
    }

    fun insert(x: Int) {
        if (root != null) {
            insert(root!!, x)
        } else {
            root = TreeNode(x)
        }
    }

    private fun search(x: Int, node: TreeNode?): Boolean {
        var r = false

        /* Node is not present */
        if (node == null) return false

        if(node.data == x) {
            /* Node’s data is equal to value searched */
            return true
        } else if(node.data > x) {
            /*Node’s data is greater than value searched*/
            r = search(x, node.left)
        } else {
            r = search(x, node.right)
        }

        return r
    }

    fun search(x: Int): Boolean {
        if (root == null) {
            return false
        } else {
            return search(x, root)
        }
    }

    private fun inOrder(node: TreeNode?) {
        if (node != null) {
            inOrder(node.left)
            print(" ${node.data} ")
            inOrder(node.right)
        }
    }

    fun inOrder() {
        if (root == null) {
            println("Tree is empty!")
        } else {
            inOrder(root)
        }
    }

    private fun preOrder(node: TreeNode?) {
        if (node != null) {
            print(" ${node.data} ")
            preOrder(node.left)
            preOrder(node.right)
        }
    }

    fun preOrder() {
        if (root == null) {
            println("Tree is empty!")
        } else {
            preOrder(root)
        }
    }

    private fun postOrder(node: TreeNode?) {
        if (node != null) {
            postOrder(node.left)
            postOrder(node.right)
            print(" ${node.data} ")
        }
    }

    fun postOrder() {
        if (root == null) {
            println("Tree is empty!")
        } else {
            postOrder(root)
        }
    }
}

fun main() {
    val tree = BinarySearchTree()
    tree.insert(20)
    tree.insert(10)
    tree.insert(30)
    tree.insert(5)
    tree.insert(25)
    tree.insert(35)
    tree.insert(15)
    tree.preOrder()
    println("\n")
    tree.postOrder()
    println("\n")
    tree.inOrder()
    println("\n")
    println(tree.search(15))
    println(tree.search(99))
}