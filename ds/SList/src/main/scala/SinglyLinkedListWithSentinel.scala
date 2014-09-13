package ds.linkedlist

class SinglyLinkedListWithSentinel[T] extends LinkedList[T, SingleNode[T]](Some(new SingleNode(null.asInstanceOf[T]))) {
  def insertBeginning(newNode: SingleNode[T]) = {
    insertAfter(head.get, newNode)
  }

  def insertAfter(node: SingleNode[T], newNode: SingleNode[T]): Unit = {
    newNode.next = node.next
    node.next = Some(newNode)
  }

  def removeAfter(node: SingleNode[T]): Unit = {
    node.next = node.next.flatMap(_.next)
  }

  def removeBeginning = {
    removeAfter(head.get)
  }

  override def size = {
    var currSize = 0
    var currNode = head.flatMap(_.next)
    while (currNode != None) {
      currNode = currNode.get.next
      currSize = currSize + 1
    }
    currSize
  }
}
