package algos.sort

import scala.collection.mutable.ListBuffer

class SelectionSort[A : Ordering] extends Sort[A] {
  override def sort(seq: List[A]): List[A] = {
    sortHelper(seq).toList
  }
  private [this] def sortHelper[A](lst: List[A])(implicit ord: Ordering[A]) = {
    val result = lst.to[ListBuffer]
    for(i <- 0 until lst.length) {
      val minIndex = findMinIndex(result, i, lst.length)
      val temp = result(minIndex)
      result(minIndex) = result(i)
      result(i) = temp
    }
    result
  }

  private [this] def findMinIndex[A](lst: ListBuffer[A], startIndex:Int, endIndex:Int)(implicit ord: Ordering[A]) = {
    import ord._
    var currentMinIndex = startIndex
    for (i <- startIndex + 1 until endIndex) {
      if (lst(i) < lst(currentMinIndex)) {
        currentMinIndex = i
      }
    }
    currentMinIndex
  }
}

object SelectionSort extends BaseSort {
  def apply[A: Ordering](lst: List[A]) = {
    new SelectionSort().sort(lst)
  }
}
