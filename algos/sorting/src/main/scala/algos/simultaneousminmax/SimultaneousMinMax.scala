package algos.simultaneousminmax

class SimultaneousMinMax {
  def findMinMax(lst: List[Int]) = {
    var isOddLengthList = true
    if (lst.length % 2 == 0) {
      isOddLengthList = false
    }

    var (currentMin, currentMax) = (lst(0), lst(0))
    var startIndex = 1
    if (!isOddLengthList) {
      var (currentMin, currentMax) = (if (lst(0) < lst(1)) lst(0) else lst(1),
        if (lst(0) > lst(1)) lst(0) else lst(1))
      startIndex = 2
    }

    for(i <- startIndex until lst.length - 1 by 2) {
      val (tempMin, tempMax) = (if (lst(i) < lst(i + 1)) lst(i) else lst(i + 1),
        if (lst(i) > lst(i + 1)) lst(i) else lst(i + 1))
      if (tempMin < currentMin) {
        currentMin = tempMin
      }
      if (tempMax > currentMax) {
        currentMax = tempMax
      }
    }
    (currentMin, currentMax)
  }
}
