package algos.randomizedselect

import org.specs2.mutable.SpecificationWithJUnit

class TestRandomizedSelect  extends SpecificationWithJUnit {
  val ReverseSortedList = List(5, 4, 3, 2, 1, 0)
  val SortedList = List(0, 1, 2, 3, 4, 5)
  val ListWithDuplicates = List(0, 1, 2, 2, 3, 6, 7, 4, 4)
  val NormalList = List(2, 3, 1, 7, 8, 0, 4)

  "The is randomized select method" should {
    "find correct index for a normal list " in {
      new RandomizedSelect().select(NormalList, 1) mustEqual 0
      new RandomizedSelect().select(NormalList, 2) mustEqual 1
      new RandomizedSelect().select(NormalList, 3) mustEqual 2
      new RandomizedSelect().select(NormalList, 4) mustEqual 3
      new RandomizedSelect().select(NormalList, 5) mustEqual 4
      new RandomizedSelect().select(NormalList, 6) mustEqual 7
      new RandomizedSelect().select(NormalList, 7) mustEqual 8
    }
  }

  "The is randomized select method" should {
    "find correct index for a reverse sorted list " in {
      new RandomizedSelect().select(ReverseSortedList, 1) mustEqual 0
      new RandomizedSelect().select(ReverseSortedList, 2) mustEqual 1
      new RandomizedSelect().select(ReverseSortedList, 3) mustEqual 2
      new RandomizedSelect().select(ReverseSortedList, 4) mustEqual 3
      new RandomizedSelect().select(ReverseSortedList, 5) mustEqual 4
      new RandomizedSelect().select(ReverseSortedList, 6) mustEqual 5
    }
  }

  "The is randomized select method" should {
    "find correct index for a sorted list " in {
      new RandomizedSelect().select(SortedList, 1) mustEqual 0
      new RandomizedSelect().select(SortedList, 2) mustEqual 1
      new RandomizedSelect().select(SortedList, 3) mustEqual 2
      new RandomizedSelect().select(SortedList, 4) mustEqual 3
      new RandomizedSelect().select(SortedList, 5) mustEqual 4
      new RandomizedSelect().select(SortedList, 6) mustEqual 5
    }
  }

  "The is randomized select method" should {
    "find correct index for a list with duplicates " in {
      new RandomizedSelect().select(ListWithDuplicates, 1) mustEqual 0
      new RandomizedSelect().select(ListWithDuplicates, 2) mustEqual 1
      new RandomizedSelect().select(ListWithDuplicates, 3) mustEqual 2
      new RandomizedSelect().select(ListWithDuplicates, 4) mustEqual 2
      new RandomizedSelect().select(ListWithDuplicates, 5) mustEqual 3
      new RandomizedSelect().select(ListWithDuplicates, 6) mustEqual 4
      new RandomizedSelect().select(ListWithDuplicates, 7) mustEqual 4
      new RandomizedSelect().select(ListWithDuplicates, 8) mustEqual 6
      new RandomizedSelect().select(ListWithDuplicates, 9) mustEqual 7
    }
  }
}
