/** Reference: Introduction to Algorithms
 * Author(s): Charles E. Leiserson, Clifford Stein, Ronald Rivest, and Thomas H. Cormen */
object BinaryTreeTraversals {
  //recursive bst traversal

  /** left child, parent, right sibling  */
  def inOrder(node: BinaryTreeNode[Int]): Unit = {
    if (node != null) {
      inOrder(node.left)
      println(node.value)
      inOrder(node.right)
    }
  }
  /** parent, left child, right sibling */
  def preOrder(node: BinaryTreeNode[Int]): Unit = {
    if (node != null) {
      println(node.value)
      preOrder(node.left)
      preOrder(node.right)
    }
  }
  /** left child, right sibling, parent */
  def postOrder(node: BinaryTreeNode[Int]): Unit = {
    if (node != null) {
      preOrder(node.left)
      preOrder(node.right)
      println(node.value)
    }
  }

  def main(args: Array[String]): Unit = {

  }

}
