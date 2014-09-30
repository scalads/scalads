package algos.secondmin

class SecondMin {
  def secondMin(lst: List[Int]):Int = {
    if (lst.length < 2) {
      return lst(0)
    }

    var min = lst(0)
    var secondMin = lst(1)

    if (lst(1) < lst(0)) {
      min = lst(1)
      secondMin = lst(0)
    }

    for(i <- 2 until lst.length) {
      if (lst(i) < min) {
        min = lst(i)
        secondMin = min
      } else if (lst(i) != min && lst(i) < secondMin) {
        secondMin = lst(i)
      }
    }
    secondMin
  }
}
