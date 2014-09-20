package algos.sort

class BinarySearch[A: Ordering] {
  def search(lst: List[A], item:A) = {
    //searchHelper(lst, 0, lst.length - 1, item)
    searchHelperIterative(lst, item)
  }

  private [this] def searchHelper[A](lst:List[A], startIndex:Int, endIndex:Int, item: A)(implicit ord: Ordering[A]):Int = {
    import ord._
    if (startIndex > endIndex) {
      return -1
    }
    val midIndex = (startIndex + endIndex) / 2

    if (lst(midIndex) == item) {
      return midIndex
    } else {
      if (lst(midIndex) < item) {
        searchHelper(lst, midIndex + 1, endIndex, item)
      } else {
        searchHelper(lst, startIndex, midIndex - 1, item)
      }
    }
  }

  private [this] def searchHelperIterative[A](lst:List[A], item: A)(implicit ord: Ordering[A]):Int = {
    import ord._
    var startIndex = 0
    var endIndex = lst.length - 1

    while (startIndex < endIndex) {
      val midIndex =(startIndex + endIndex) / 2

      if (lst(midIndex) == item) {
        return midIndex
      } else {
        if (lst(midIndex) < item) {
          startIndex = midIndex + 1
        } else {
          endIndex = midIndex - 1
        }
      }
    }
    return -1
  }
}

object BinarySearch {
  def apply[A: Ordering](lst: List[A], item: A) = {
    new BinarySearch().search(lst, item)
  }
}
