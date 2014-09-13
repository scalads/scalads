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
    node.next = node.next.flatMap(_.next)
  }

  def removeBeginning = {
    head = head.flatMap(_.next)
  }
}
