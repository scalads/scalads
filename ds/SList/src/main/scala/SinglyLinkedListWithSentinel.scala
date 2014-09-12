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
    node.next = node.next match {
      case Some(nextNode) => nextNode.next
      case None => None
    }
  }

  def removeBeginning = {
    removeAfter(head.get)
  }

  override def size = {
    var currSize = 0
    var currPos = head.get.next orElse None
    while (currPos != None) {
      currPos = currPos.get.next
      currSize = currSize + 1
    }
    currSize
  }
}
