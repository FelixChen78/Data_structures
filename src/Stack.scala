/** Reference: Introduction to Algorithms
 * Author(s): Charles E. Leiserson, Clifford Stein, Ronald Rivest, and Thomas H. Cormen */
class Stack {
  var top: Int = -1
  var stack: Array[Int] = new Array[Int](10000)
  var length: Int = stack.length
  /** checks if stack is empty */
  def isEmpty: Boolean = {
    if (this.top == -1) true ; else false
  }

  /** inserts into stack */
  def push(x: Int): Unit = {
    this.top = this.top + 1
    this.stack(this.top) = x
  }

  /** checks if stack is empty and pops last element */
  def pop(): Any = {
    if (isEmpty) {
      println("stack underflow")
    }
    else {
      this.top = this.top - 1
      this.stack(this.top + 1)
    }
  }

}


object Stack {

  /** driver code to test stack */
  def main(args: Array[String]): Unit = {
    val a = new Stack
    a.pop()
    a.push(3) // first
    a.push(4) // second
    a.push(2) // last
    println(a.pop()) // last
    println(a.pop()) // second
    println(a.pop()) // first

  }
}