package ds.linkedlist;

class Node[T](val data: T) {
  var next: Option[Node[T]] = None
}

class DoubleNode[T](val data:T) {
  var next: Option[DoubleNode[T]] = None
  var previous: Option[DoubleNode[T]] = None
}

//todo parameterize the node type and pass the head argument as constructor to this trait
// after that the size method can be defined in this trait
trait LinkedList[T] {
  def insertAfter(node: Node[T], newNode: Node[T]): Unit

  def insertBeginning(newNode: Node[T]): Unit

  def removeAfter(node: Node[T]): Unit

  def removeBeginning
}

