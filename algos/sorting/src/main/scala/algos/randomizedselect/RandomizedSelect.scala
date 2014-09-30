package algos.randomizedselect

import scala.collection.mutable.ListBuffer
import scala.util.Random

class RandomizedSelect {
  def select(lst: List[Int], i: Int) = {
    selectHelper(lst.to[ListBuffer], 0, lst.length - 1, i - 1) // i -1 because of 0 based index, so 1st minimum, 2nd minimum etc.
  }

  def selectHelper(lst: ListBuffer[Int], startIndex: Int, endIndex: Int, toFind: Int): Int = {
    if (startIndex == endIndex) {
      return lst(startIndex)
    }
    val r = randomizedPartition(lst, startIndex, endIndex)
    val firstPartitionEndIndex = r - startIndex
    if (firstPartitionEndIndex == toFind) {
      return lst(r)
    } else if (toFind <= firstPartitionEndIndex) {
      selectHelper(lst, startIndex, r - 1, toFind)
    } else {
      selectHelper(lst, r + 1, endIndex, toFind - firstPartitionEndIndex - 1)
    }
  }

  def randomizedPartition(lst: ListBuffer[Int], startIndex: Int, endIndex: Int) = {
    preparePivot(lst, startIndex, endIndex)
    var i = startIndex - 1
    val pivot = lst(endIndex)
    for (j <- startIndex until endIndex) {
      if (lst(j) <= pivot) {
        i += 1
        swapElement(lst, i, j)
      }
    }
    swapElement(lst, i + 1, endIndex)
    i + 1
  }

  def preparePivot(lst: ListBuffer[Int], startIndex: Int, endIndex: Int) {
    val randomPos = new Random().nextInt(endIndex - startIndex + 1) + startIndex
    swapElement(lst, randomPos, endIndex)
  }

  def swapElement(lst: ListBuffer[Int], firstPos: Int, secondPos: Int) = {
    val temp = lst(firstPos)
    lst(firstPos) = lst(secondPos)
    lst(secondPos) = temp
  }
}
