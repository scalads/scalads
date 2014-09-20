package algos.sort

import scala.collection.mutable.ListBuffer

class InsertionSort[A : Ordering] extends Sort[A] {
  override def sort(seq: List[A]): List[A] = {
    sortHelper(seq).toList
  }

  private [this] def sortHelper[A](lst: List[A])(implicit ord: Ordering[A]) = {
    import ord._
    val result = lst.to[ListBuffer]
    for(i <- 1 until lst.length) {
      val key = result(i)
      var j = i - 1
      while (j >= 0 && key < result(j)) {
        result(j+1) = result(j)
        j -= 1
      }
      result(j + 1) = key
    }
    result
  }
}

object InsertionSort extends BaseSort {
  def apply[A: Ordering](lst: List[A]) = {
    new InsertionSort().sort(lst)
  }
}
