package ds.heap;

import org.specs2.mutable._

class TestMaxHeap extends SpecificationWithJUnit {
  "The Max Heap" should {
    "be able to sort elements using heapsort" in {
      val data = Array(4, 5, 1, -5, 10, 1, 4, 2, 0, -11)
      val heap = new MaxHeap[Int](data)
      heap.heapSort
      heap.data mustEqual data.sorted
    }
  }
}
