package ds.heap

abstract class Heap[A:Ordering](val data:Array[A]) {
  protected [this] var heapSize = 0;

  def leftChild(i:Int) = 2*i
  def rightChild(i:Int) = 2*i + 1
  def parent(i:Int) = Math.floor(i/2).toInt

  def heapSort      // O(nlgn)

  override def toString: String = {
    s"heap size $heapSize, data = " + data.deep.mkString(",")
  }
}