package ds.linkedlist

class DoublyLinkedList[T] extends LinkedList[T, DoubleNode[T]] {
  def insertBeginning(newNode: DoubleNode[T]) = {
    newNode.next = head orElse None
    if (head.isDefined) {
      head.get.previous = Some(newNode)
    }
    head = Some(newNode)
  }

  def insertAfter(node: DoubleNode[T], newNode: DoubleNode[T]): Unit = {
    newNode.next = node.next
    if (newNode.next.isDefined) {
      node.next.get.previous = Some(newNode)
    }
    node.next = Some(newNode)
    newNode.previous = Some(node)
  }

  def removeAfter(node: DoubleNode[T]): Unit = {
    if (node.next.isDefined) {
      node.next = node.next.get.next
      if (node.next.isDefined) {
        node.next.get.previous = Some(node)
      }
    }
  }

  def removeBeginning = {
    head = head match {
      case Some(node) => node.next
      case _ => None
    }
    if (head.isDefined) {
      head.get.previous = None
    }
  }
}
