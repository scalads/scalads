package algos.sort

import scala.collection.mutable.ListBuffer

class MergeSort[A : Ordering] extends Sort[A] {
  override def sort(seq: List[A]): List[A] = {
    sortHelper(seq).toList
  }

  private [this] def sortHelper[A](lst: List[A])(implicit ord: Ordering[A]) = {
    mergeSort(lst.to[ListBuffer], 0, lst.length - 1)
  }

  private [this] def mergeSort[A](lst:ListBuffer[A], startIndex:Int, endIndex:Int)(implicit ord: Ordering[A]): ListBuffer[A] = {
    if (startIndex < endIndex) {
      val midIndex = (startIndex + endIndex) / 2
      mergeSort(lst.slice(startIndex, midIndex), startIndex, midIndex)
      mergeSort(lst.slice(midIndex, endIndex), midIndex + 1, endIndex)
      merge(lst, startIndex, midIndex, endIndex)
    } else {
      ListBuffer[A](lst(startIndex))
    }
  }

  private [this] def merge[A](lst:ListBuffer[A], startIndex:Int, midIndex:Int, endIndex:Int)(implicit ord: Ordering[A]) = {
    import ord._
    var left = startIndex
    val leftEnd = midIndex
    var right = midIndex + 1
    val rightEnd = endIndex

    val result = new ListBuffer[A]()
    while (left <= leftEnd && right <= rightEnd) {
      if (lst(left) < lst(right)) {
        result += lst(left)
        left += 1
      } else if (lst(left) >= lst(right)) {
        result += lst(right)
        right += 1
      }
    }
    if (left <= leftEnd) {
      result ++= lst slice(left, leftEnd)
    }
    if (right <= rightEnd) {
      result ++= lst slice(right, rightEnd)
    }
    lst.clear()
    lst.appendAll(result)
    lst
  }
}

object MergeSort extends BaseSort {
  def apply[A: Ordering](lst: List[A]) = {
    new MergeSort().sort(lst)
  }
}

