package algos.secondmin

import org.specs2.mutable.SpecificationWithJUnit

class TestSecondMin extends SpecificationWithJUnit  {
  val NormalList = List(0, 1, 2, 9, 3, 6, 7, 4, 8)
  val ListWithDuplicates = List(0, 1, 9, 0, 6, 7, 9, 1)
  val ListWithSingleElement = List(0)
  val ListWithRepeatedSingleElement = List(8,8,8,8,8,8,8,8,8,8,8,8)

  "The second min method" should {
    "return proper values for a normal list " in {
      new SecondMin().secondMin(NormalList) mustEqual 1
    }
  }

  "The second min method" should {
    "return proper values for a list with duplicate elements" in {
      new SecondMin().secondMin(ListWithDuplicates) mustEqual 1
    }
  }

  "The second min method" should {
    "return proper values for a list with single element" in {
      new SecondMin().secondMin(ListWithSingleElement) mustEqual 0
    }
  }

  "The second min method" should {
    "return proper values for a list with repeated single element" in {
      new SecondMin().secondMin(ListWithRepeatedSingleElement) mustEqual 8
    }
  }
}
