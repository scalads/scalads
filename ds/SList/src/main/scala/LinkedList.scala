package ds.linkedlist

trait AbstractNode[T] {
  val data: T
}

trait AbstractLinkedNode[T] extends AbstractNode[T] {
  type nodeType
  var next: Option[nodeType] = None // every linked node will have a next element
}

class SingleNode[T](override val data: T) extends AbstractLinkedNode[T] {
  type nodeType = SingleNode[T]
}

class DoubleNode[T](override val data: T) extends AbstractLinkedNode[T] {
  type nodeType = DoubleNode[T]
  var previous: Option[nodeType] = None
}

abstract class LinkedList[T, nodeType <: AbstractLinkedNode[T]](var head: Option[nodeType] = None) {
  def insertAfter(node: nodeType, newNode: nodeType): Unit

  def insertBeginning(newNode: nodeType): Unit

  def removeAfter(node: nodeType): Unit

  def removeBeginning

  def size = {
    var currSize = 0
    var currNode = head orElse None
    while (currNode != None) {
      currNode = currNode.flatMap(_.next).asInstanceOf[Option[nodeType]]
      currSize = currSize + 1
    }
    currSize
  }
}

