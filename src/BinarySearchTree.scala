/** Reference: Introduction to Algorithms
 * Author(s): Charles E. Leiserson, Clifford Stein, Ronald Rivest, and Thomas H. Cormen */
class BinarySearchTree (var root: BinaryTreeNode[Int] = null) {

  /** inserts a new node into bst */
  def insert(z: BinaryTreeNode[Int]): Unit = {
    var y: BinaryTreeNode[Int] = null
    var x: BinaryTreeNode[Int] = root
    while (x != null) {
      y = x
      if (z.value < x.value) {
        x = x.left
      }
      else {
        x = x.right
      }
    }
    z.pred = y
    if (y == null) {
      this.root = z
    }
    else if (z.value < y.value) {
      y.left = z
    }
    else {
      y.right = z
    }
  }

  /** transplant subtree of node u to node v */
  def transplant(u: BinaryTreeNode[Int], v: BinaryTreeNode[Int]): Unit = {
    if (u.pred == null) {
      this.root = v
    }
    else if (u == u.pred.left) {
      u.pred.left = v
    }
    else {
      u.pred.right = v
    }
    if (v != null) {
      v.pred = u.pred
    }
  }

  /** deletes node from bst */
  def delete(z: BinaryTreeNode[Int]): Unit = {
    if (z.left == null) {
      transplant(z, z.right)
    }
    else if (z.right == null) {
      transplant(z,z.left)
    }
    else {
      val y = minimum(z.right)
      if (y.pred != z) {
        transplant(y,y.right)
        y.right = z.right
        y.right.pred = y
      }
      transplant(z,y)
      y.left = z.left
      y.left.pred = y
    }

  }

  /** searches for node in bst */
  def search(x: BinaryTreeNode[Int], k: Int): BinaryTreeNode[Int] = {
    if (x == null || k == x.value) {
      return x
    }
    if (k < x.value) {
      search(x.left, k)
    }
    else {
      search(x.right, k)
    }
  }

  /**
   * iterative search solution
   * most computers iterative solution is faster than recursive solution
   * */
  def iterativeSearch(node: BinaryTreeNode[Int], k: Int): BinaryTreeNode[Int] = {
    var x = node
    while (x != null && k != x.value) {
      if (k < x.value) {
        x = x.left
      }
      else {
        x = x.right
      }
    }
    x
  }

  /** finds min value in bst */
  def minimum(node: BinaryTreeNode[Int]): BinaryTreeNode[Int] = {
    var x = node
    while (x.left != null) {
      x = x.left
    }
    x
  }

  /** finds max value in bst */
  def maximum(node: BinaryTreeNode[Int]): BinaryTreeNode[Int] = {
    var x = node
    while (x.right != null) {
      x = x.right
    }
    x
  }

  /** finds the successor to the inserted node */
  def successor(node: BinaryTreeNode[Int]): BinaryTreeNode[Int] = {
    var x = node
    if (x.right != null) {
      minimum(x.right)
    }
    var y = node.pred
    while (y != null && x == y.right) {
      x = y
      y = x.pred
    }
    y
  }




}

object BinarySearchTree {

  /** driver code to test bst functionality */
  def main(args: Array[String]): Unit = {
    val a = new BinarySearchTree
    val b = new BinaryTreeNode[Int](5) //parent
    val c = new BinaryTreeNode[Int](3) //left
    val d = new BinaryTreeNode[Int](6) //right

    a.insert(b)
    a.insert(c)
    a.insert(d)

    BinaryTreeTraversals.preOrder(a.root) // 5 3 6
    println("finding c, '3': " + a.iterativeSearch(c, c.value).value)
    println("finding d, '6': " + a.search(d, d.value).value)
    println("max value: " + a.maximum(a.root).value)
    println("min value: " + a.minimum(a.root).value)
    a.delete(d)
    BinaryTreeTraversals.preOrder(a.root)

  }
}
