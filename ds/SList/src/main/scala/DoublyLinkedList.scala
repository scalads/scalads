package ds.linkedlist

class DoublyLinkedList[T] extends LinkedList[T, DoubleNode[T]] {
  def insertBeginning(newNode: DoubleNode[T]) = {
    newNode.next = head orElse None
    head.map(_.previous = Some(newNode))
    head = Some(newNode)
  }

  def insertAfter(node: DoubleNode[T], newNode: DoubleNode[T]): Unit = {
    newNode.next = node.next
    node.next.map(_.previous = Some(newNode))
    node.next = Some(newNode)
    newNode.previous = Some(node)
  }

  def removeAfter(node: DoubleNode[T]): Unit = {
    Some(node).map(_.next = node.next.flatMap(_.next))
    node.next.map(_.previous = Some(node))
  }

  def removeBeginning = {
    head = head.flatMap(_.next)
    head.map(_.previous = None)
  }
}
