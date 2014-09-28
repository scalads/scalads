package ds.heap

class MaxHeap[A:Ordering](override val data:Array[A]) extends Heap[A](data) {
  def maxHeapify(i:Int):Unit = { // O(lgn)
  val ordering: Ordering[A] = implicitly[Ordering[A]]
    import ordering._
    // assumptions: left(i) and right(i) are max heaps but element at i might not be
    val l = leftChild(i)
    val r = rightChild(i)
    var largest = i
    if (l < heapSize && data(l) > data(i)) {
      largest = l
    }
    if (r < heapSize && data(r) > data(largest)) {
      largest = r
    }
    if (largest != i) {
      swapElementAt(i, largest)
      maxHeapify(largest)
    }
  }

  def buildMaxHeap = {  // O(n)
    heapSize = data.length
    for (i <- Math.floor(data.length/2).toInt to 0 by -1) {
      maxHeapify(i)
    }
  }

  def heapSort = {
    buildMaxHeap
    for (i <- data.length - 1 to 1 by -1) {
      swapElementAt(0, i)
      heapSize -= 1
      maxHeapify(0)
    }
  }

  protected def swapElementAt(first: Int, second: Int) = {
    val temp = data(first)
    data(first) = data(second)
    data(second) = temp
  }
}