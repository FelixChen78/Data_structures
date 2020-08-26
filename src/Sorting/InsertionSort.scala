/** Reference: Introduction to Algorithms
 * Author(s): Charles E. Leiserson, Clifford Stein, Ronald Rivest, and Thomas H. Cormen */
package Sorting

object InsertionSort {

  /** sorts array using insertion sort */
  def insertionSort(sort: Array[Int]): Array[Int] = {
    for (current <- 1 until sort.length) {
      val key = sort(current)
      var previous = current - 1
      while (previous >= 0 && sort(previous) > key) {
        sort(previous + 1) = sort(previous)
        previous = previous - 1
      }
      sort(previous + 1) = key
    }
    sort
  }

  /** driver code to test insertion sort */
  def main(args: Array[String]): Unit = {
    val ar: Array[Int] = Array(5, 2, 4, 6, 1, 3)
    println(insertionSort(ar).toList)
  }
}
