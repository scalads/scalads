package algos.divideandconquer

import org.specs2.mutable.SpecificationWithJUnit

class TestMaximalSum  extends SpecificationWithJUnit {
  val ListToCheck = List(13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7)
  val ListContainingOnlyNegativeNumbers = List(-3, -2, -11, -1, -4, -6, -7, -2, -19)

  "The maximal sum algorithm" should {
    "should find correct sum and indices for a valid list" in {
      MaximalSum(ListToCheck) mustEqual (7, 10, 43)
    }
  }

  "The maximal sum algorithm" should {
    "should find correct sum and indices for a list containing only negative numbers" in {
      MaximalSum(ListContainingOnlyNegativeNumbers) mustEqual (3, 3, -1)
    }
  }
}
