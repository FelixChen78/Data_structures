/** Reference: Introduction to Algorithms
 * Author(s): Charles E. Leiserson, Clifford Stein, Ronald Rivest, and Thomas H. Cormen */
class DoublyLinkedList[T](var head: LinkedListNode[T] = null) {

  /** search for a node */
  def search(k: T): LinkedListNode[T] = {
    var current = this.head
    while (current != null && current.value != k) {
      current = current.next
    }
    current
  }

  /** insert in front of list */
  def prepend(value: T): Unit = {
    val newNode = new LinkedListNode[T](value, this.head)
    if (this.head != null) {
      this.head.prev = newNode
    }
    this.head = newNode
  }

  /** insert end of list */
  def append(value: T): Unit = {
    val newNode = new LinkedListNode[T](value)
    if (this.head == null) {
      this.head = newNode
    }
    else {
      var last = this.head
      while (last.next != null) {
        last = last.next
      }
      last.next = newNode
      newNode.prev = last
    }
  }

  /** insert after a node */
  def insert(value: T, prevNode: LinkedListNode[T]): Unit = {
    // does nothing if empty list
    if (prevNode != null) {
      val newNode = new LinkedListNode[T](value)
      // assigns the new pointers
      newNode.prev = prevNode
      newNode.next = prevNode.next
      prevNode.next = newNode
      if (prevNode.next != null) {
        prevNode.next.prev = newNode
      }
    }
  }

  /** deletes node from list */
  def delete(node: LinkedListNode[T]): Unit = {
    if (node.prev != null) {
      node.prev.next = node.next
    }
    else {
      this.head = node.next
    }
    if (node.next != null) {
      node.next.prev == node.prev
    }
  }

  // todo: maybe use scala fold instead of 20 println
  def list(): Unit = {
    print("(")
    var current = this.head
    print(current.value)

    while (current.next != null) {
      print(", ")
      print(current.next.value)
      current = current.next
    }

    print(")")
  }


}

object DoublyLinkedList {

  /** driver code to test doubly linked list */
  def main(args: Array[String]): Unit = {
    val a = new DoublyLinkedList[Int]
    // prepend to list
    for (i <- -5 to -1) {
      a.prepend(i)
      a.list()
      println()
    }
    // append to list
    for (i <- 1 to 5) {
      a.append(i)
      a.list()
      println()
    }
    // search for node with value 5
    val n = a.search(5)
    // inserts after node n
    a.insert(100,n)
    a.list()
    // deletes node n
    a.delete(n)
    println()
    a.list()

  }
}