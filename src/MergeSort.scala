/** Reference: Introduction to Algorithms
 * Authors: Charles E. Leiserson, Clifford Stein, Ronald Rivest, and Thomas H. Cormen */
object MergeSort {

  /** recursively divides the array until each array has a single element then combines into full array using merge */
  def sort(A:Array[Int], l:Int, r:Int): Array[Int] = {
    if (l < r) {
      val m: Int = math.floor((l + r) / 2).toInt
      sort(A, l, m)
      sort(A, m + 1, r)
      merge(A, l ,m, r)
    }
    A
  }

  /** combines the 2 sorted subarray into a single sorted array */
  def merge(A: Array[Int], l: Int, m: Int, r: Int): Array[Int] = {
    val n1:Int = m - l + 1
    val n2:Int = r - m
    val L :Array[Int] = new Array[Int](n1 + 1)
    val R: Array[Int] = new Array[Int](n2 + 1)
    for (i <- 0 until n1) {
      L(i) = A(l + i)
    }
    for (j <- 0 until n2) {
      R(j) = A(m + j + 1)
    }
    L(n1) = Int.MaxValue
    R(n2) = Int.MaxValue
    var i = 0
    var j = 0
    for (k <- l to r) {
      if (L(i) <= R(j)) {
        A(k) = L(i)
        i = i + 1
      }
      else {
        A(k) = R(j)
        j = j + 1
      }
    }
    A
  }

  /** used to reduce redundant inputs */
  def mergeSort(A: Array[Int]): Array[Int] = {
    sort(A, 0, A.length - 1)
  }

  /** driver code to test merge sort */
  def main(args: Array[String]): Unit = {
    val a: Array[Int] = Array(2,4,6,1,3,7)
    val b :Array[Int] = Array(2,5,7,1,6,8)
    val c: Array[Int] = Array(2,5,7,1,6,8,11,2,5,7,1,6,8)
    println(mergeSort(a).toList)
    println(mergeSort(b).toList)
    println(mergeSort(c).toList)
  }
  //  523 362
  //  52 3 36 2
  //  5 2 3 3 6 2
  //  25 3 36 2
  //  235 236
  //  223356

}
