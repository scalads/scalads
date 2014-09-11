package ds.linkedlist;

trait AbstractNode[T] {
  val data:T
}

class Node[T](override val data: T) extends AbstractNode[T] {
  var next: Option[Node[T]] = None
}

class DoubleNode[T](override val data:T) extends AbstractNode[T] {
  var next: Option[DoubleNode[T]] = None
  var previous: Option[DoubleNode[T]] = None
}

trait LinkedList[T, nodeType <: AbstractNode[T]] {
  def insertAfter(node: nodeType, newNode: nodeType): Unit

  def insertBeginning(newNode: nodeType): Unit

  def removeAfter(node: nodeType): Unit

  def removeBeginning
}

