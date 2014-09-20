package algos.divideandconquer

class MaximalSum{
  def bruteForce(lst: List[Int]) = {
    var maxSum = Int.MinValue
    var maxStartIndex = -1
    var maxEndIndex = -1

    for (i <- 0 until lst.length) {
      for (j <- i + 1 until lst.length) {
        val sliceSum =lst.slice(i + 1, j).sum
        if (lst(i) +  sliceSum > maxSum) {
          maxSum = lst(i) + sliceSum
          maxStartIndex = i
          maxEndIndex = j - 1 // because of the way slice works
        }
      }
    }
    (maxStartIndex, maxEndIndex, maxSum)
  }
}

object MaximalSum {
  def apply(lst: List[Int]) = {
    new MaximalSum().bruteForce(lst)
  }
}
