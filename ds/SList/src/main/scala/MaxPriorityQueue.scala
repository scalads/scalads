package ds.heap

class MaxPriorityQueue[A:Ordering](override val data:Array[A]) extends MaxHeap[A](data) {
  def heapMaximum = {
    data(0)
  }

  def heapExtractMax = {
    assert(heapSize > 0)
    val max = data(0)
    swapElementAt(0, heapSize - 1)
    heapSize -= 1
    maxHeapify(0)
    max
  }

  def heapIncreaseKey(i:Int, newKey:A) = {
    val ord = implicitly(Ordering[A])
    import ord._
    assert(newKey >= data(i))
    data(i) = newKey
    var currentIndex = i
    while (currentIndex > 0 && (data(parent(currentIndex)) < data(currentIndex))) {
      swapElementAt(parent(currentIndex), currentIndex)
      currentIndex = parent(currentIndex)
    }
  }

  def maxHeapInsert(newKey:A) = {
    heapSize += 1
    data(heapSize) = null.asInstanceOf[A]
    heapIncreaseKey(heapSize, newKey)
  }

  def maxHeapDelete(i:Int) = {
    assert(i < heapSize)
    swapElementAt(i, heapSize - 1)
    heapSize -= 1
    maxHeapify(i)
  }
}
