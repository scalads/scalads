package algos.sort

import org.specs2.mutable.SpecificationWithJUnit

class TestBinarySerach extends SpecificationWithJUnit {
  val ListWithDuplicates = List(0, 1, 2, 2, 3, 6, 7, 4, 4)

  "The binary search method" should {
    "find an item in the sorted list" in {
      BinarySearch(ListWithDuplicates.sorted, 3) mustEqual 4
    }
  }

  "The binary search method" should {
    "find a duplicated item in the sorted list" in {
      BinarySearch(ListWithDuplicates.sorted, 2) mustEqual 2
    }
  }

  "The binary search method" should {
    "fail to find a nonexistent item in the sorted list" in {
      BinarySearch(ListWithDuplicates.sorted, 20) mustEqual -1
    }
  }
}
