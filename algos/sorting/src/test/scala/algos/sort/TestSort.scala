package algos.sort

import org.specs2.mutable.SpecificationWithJUnit

class TestSort extends SpecificationWithJUnit {
  val sortingAlgorithms = List(InsertionSort, SelectionSort, BubbleSort)
  val ReverseSortedList = List(5, 4, 3, 2, 1, 0)
  val SortedList = List(0, 1, 2, 3, 4, 5)
  val ListWithDuplicates = List(0, 1, 2, 2, 3, 6, 7, 4, 4)

  "The sort method" should {
    "sort a reverse sorted list" in {
      for (s <- sortingAlgorithms) {
        val sortedList = s(ReverseSortedList)
        sortedList mustEqual ReverseSortedList.sorted
      }
      success
    }
  }

  "The sort method" should {
    "sort an already sorted list" in {
      for(s <- sortingAlgorithms) {
        val sortedList = s(SortedList)
        sortedList mustEqual SortedList.sorted
      }
      success
    }
  }

  "The sort method" should {
    "sort a list with duplicates" in {
      for (s <- sortingAlgorithms) {
        val sortedList = s(ListWithDuplicates)
        sortedList mustEqual ListWithDuplicates.sorted
      }
      success
    }
  }
}