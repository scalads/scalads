package algos.sort

import org.specs2.mutable.SpecificationWithJUnit

class TestCountSort extends SpecificationWithJUnit {
  val ReverseSortedList = List(5, 4, 3, 2, 1, 0)
  val SortedList = List(0, 1, 2, 3, 4, 5)
  val ListWithDuplicates = List(0, 1, 2, 2, 3, 6, 7, 4, 4)

  "The sort method" should {
    "sort a reverse sorted list" in {
      val sortedList = CountSort(ReverseSortedList)
      sortedList mustEqual ReverseSortedList.sorted
    }
  }

  "The sort method" should {
    "sort an already sorted list" in {
      val sortedList = CountSort(SortedList)
      sortedList mustEqual SortedList.sorted
    }
  }

  "The sort method" should {
    "sort a list with duplicates" in {
      val sortedList = CountSort(ListWithDuplicates)
      sortedList mustEqual ListWithDuplicates.sorted
    }
  }
}