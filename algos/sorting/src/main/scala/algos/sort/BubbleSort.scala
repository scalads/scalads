package algos.sort

import scala.collection.mutable.ListBuffer

class BubbleSort[A: Ordering] extends Sort[A] {
  override def sort(seq: List[A]): List[A] = {
    sortHelper(seq.to[ListBuffer]).toList
  }

  private[this] def sortHelper[A](lst: ListBuffer[A])(implicit ord: Ordering[A]) = {
    import ord._
    for (i <- 0 until lst.length - 1) {
      for (j <- lst.length - 1 until i by -1 ) {
        if (lst(j) < lst(j - 1)) {
          val temp = lst(j-1)
          lst(j-1) = lst(j)
          lst(j) = temp
        }
      }
    }
    lst
  }
}

object BubbleSort extends BaseSort {
  def apply[A: Ordering](lst: List[A]) = {
    new BubbleSort().sort(lst)
  }
}
