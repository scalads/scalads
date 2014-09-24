package algos.divideandconquer

class MaximalSum{
  def optimized(lst: List[Int]) = {
    case class Sum(startIndex:Int, endIndex:Int, sum:Int)

    var currentSum = Sum(0, 0, lst(0))
    var maxSum = Sum(0, 0, lst(0))

    for (i <- 0 until lst.length) {
      if (lst(i) >= maxSum.sum && lst(i) > currentSum.sum + lst(i)) {
        maxSum = Sum(i, i, lst(i))
        currentSum = maxSum
      } else if (currentSum.sum + lst(i) > maxSum.sum) {
        maxSum = Sum(currentSum.startIndex, i, currentSum.sum + lst(i))
        currentSum = maxSum
      } else {
        if (lst(i) >= currentSum.sum) {
          currentSum = Sum(i, i, lst(i))
        } else {
          currentSum = Sum(currentSum.startIndex, i, currentSum.sum + lst(i))
        }
      }
    }
    (maxSum.startIndex, maxSum.endIndex, maxSum.sum)
  }
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

  def recursive(lst:List[Int]) = ???
}

object MaximalSum {
  def apply(lst: List[Int]) = {
    new MaximalSum().optimized(lst)
  }
}
