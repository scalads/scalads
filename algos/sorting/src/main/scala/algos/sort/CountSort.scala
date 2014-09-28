package algos.sort

import scala.collection.mutable.ArrayBuffer

class CountSort extends Sort[Int] {
  override def sort(lst: List[Int]): List[Int] = {
    countSort(lst.toVector, lst.max).toList
  }

  private[this] def countSort(lst: Vector[Int], k: Int): ArrayBuffer[Int] = {
    val result: ArrayBuffer[Int] = ArrayBuffer.fill(lst.length)(0)
    val intermediate: ArrayBuffer[Int] = ArrayBuffer.fill(k + 1)(0)

    for (j <- 0 until lst.length) {
      intermediate(lst(j)) =  intermediate(lst(j)) + 1 // intermediate(i) contains number of elements equal to i
    }
    for (i <- 1 to k) {
      intermediate(i) += intermediate(i - 1) // intermediate(i) contains number of elements less than or equal to i
    }
    for (j <- lst.length - 1 to 0 by -1) {
      result(intermediate(lst(j)) - 1) =  lst(j)
      intermediate(lst(j)) =  intermediate(lst(j)) - 1
    }
    result
  }
}

object CountSort {
  def apply(lst: List[Int]) = {
    new CountSort().sort(lst)
  }
}