/** implemented with a lot of cheese */
class DynamicArray(size: Int) {

  var dynamicArray: Array[Int] = new Array[Int](size)
  var pointer: Int = 0
  var length = dynamicArray.length

  /** creates a new larger array and copies value from old to new array */
  def increase(): Unit = {
    val size = dynamicArray.length * 2
    val newArray: Array[Int] = new Array[Int](size)
    for (i <- dynamicArray.indices) {
      newArray(i) = dynamicArray(i)
    }
    dynamicArray = newArray
    length = dynamicArray.length
  }

  /** insert into dynamic array */
  def insert(x: Int): Unit = {
    if (pointer < dynamicArray.length) {
      dynamicArray(pointer) = x
    }
    else {
      increase()
      dynamicArray(pointer) = x
    }
    pointer += 1
  }


}

object DynamicArray {
  /** driver code */
  def main(args: Array[String]): Unit = {
    val a = new DynamicArray(10)
    println(a.length)
    for (i <- 0 to 10) {
      a.insert(i)
    }
    println(a.dynamicArray.toList)
    a.insert(2)
    println(a.length)

  }
}
