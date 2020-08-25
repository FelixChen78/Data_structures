/** Reference: Introduction to Algorithms
 * Author(s): Charles E. Leiserson, Clifford Stein, Ronald Rivest, and Thomas H. Cormen */
class Queue {
  var head, tail, length = 0
  var queue: Array[Int] = new Array[Int](10000)

  /** inserts into queue */
  def enqueue(x: Int): Unit = {
    this.queue(this.tail) = x
    length += 1
    if (this.tail == this.length) {
      this.tail = 1
    }
    else {
      this.tail = this.tail + 1
    }
  }

  /** removes and returns head value from queue */
  def dequeue(): Int = {
    val x = this.queue(this.head)
    if (this.head == this.length) {
      this.head = 1
    }
    else {
      this.head = this.head + 1
    }
    x
  }
}

object Queue {
  /** driver code to test queue */
  def main(args: Array[String]): Unit = {
    val a = new Queue
    a.enqueue(3)
    a.enqueue(4)
    a.enqueue(14)
    println(a.dequeue())
    println(a.dequeue())
    println(a.dequeue())
  }
}
