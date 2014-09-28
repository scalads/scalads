package algos.simultaneousminmax

import org.specs2.mutable.SpecificationWithJUnit

class TestSimultaneousMinMax extends SpecificationWithJUnit {
  val NormalList = List(0, 1, 2, 9, 3, 6, 7, 4, 8)
  val ListWithDuplicates = List(0, 1, 9, 0, 6, 7, 9, 9)
  val ListWithSingleElement = List(0)
  val ListWithRepeatedSingleElement = List(8,8,8,8,8,8,8,8,8,8,8,8)

  "The simultaneous min max method" should {
    "return proper values for a normal list " in {
      val (min, max) = new SimultaneousMinMax().findMinMax(NormalList)
      min mustEqual 0
      max mustEqual 9
    }
  }

  "The simultaneous min max method" should {
    "return proper values for a list with duplicate elements" in {
      val (min, max) = new SimultaneousMinMax().findMinMax(ListWithDuplicates)
      min mustEqual 0
      max mustEqual 9
    }
  }

  "The simultaneous min max method" should {
    "return proper values for a list with single element" in {
      val (min, max) = new SimultaneousMinMax().findMinMax(ListWithSingleElement)
      min mustEqual 0
      max mustEqual 0
    }
  }

  "The simultaneous min max method" should {
    "return proper values for a list with repeated single element" in {
      val (min, max) = new SimultaneousMinMax().findMinMax(ListWithRepeatedSingleElement)
      min mustEqual 8
      max mustEqual 8
    }
  }
}
