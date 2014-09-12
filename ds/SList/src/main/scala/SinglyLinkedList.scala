package ds.linkedlist;

class SinglyLinkedList[T] extends LinkedList[T, SingleNode[T]] {
  def insertBeginning(newNode: SingleNode[T]) = {
    newNode.next = head orElse None
    head = Some(newNode)
  }

  def insertAfter(node: SingleNode[T], newNode: SingleNode[T]): Unit = {
    newNode.next = node.next
    node.next = Some(newNode)
  }

  def removeAfter(node: SingleNode[T]): Unit = {
    node.next = node.next match {
      case Some(nextNode) => nextNode.next
      case None => None
    }
  }

  def removeBeginning = {
    head = head match {
      case Some(node) => node.next
      case _ => None
    }
  }
}
