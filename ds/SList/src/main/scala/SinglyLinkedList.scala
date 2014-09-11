package ds.linkedlist;

class SinglyLinkedList[T](var head: Option[Node[T]] = None) extends LinkedList[T, Node[T]] {
  def insertBeginning(newNode: Node[T]) = {
    newNode.next = head orElse None
    head = Some(newNode)
  }

  def insertAfter(node: Node[T], newNode: Node[T]): Unit = {
    newNode.next = node.next
    node.next = Some(newNode)
  }

  def removeAfter(node: Node[T]): Unit = {
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

  def size = {
    var currSize = 0
    var currPos = head
    while (currPos != None) {
      currPos = currPos.get.next
      currSize = currSize + 1
    }
    currSize
  }
}
