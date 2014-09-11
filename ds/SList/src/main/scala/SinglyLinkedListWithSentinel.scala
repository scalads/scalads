package ds.linkedlist;

class SinglyLinkedListWithSentinel[T] extends LinkedList[T, Node[T]] {
  val head:Option[Node[T]] = Some(new Node(null.asInstanceOf[T])) // default value of T

  def insertBeginning(newNode: Node[T]) = {
    insertAfter(head.get, newNode)
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
    removeAfter(head.get)
  }

  def size = {
    var currSize = 0
    var node = head.get.next
    while (node != None) {
      node = node.get.next
      currSize = currSize + 1
    }
    currSize
  }
}
