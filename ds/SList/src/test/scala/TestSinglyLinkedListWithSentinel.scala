package ds.linkedlist;

import org.specs2.mutable._

class TestSinglyLinkedListWithSentinel   extends SpecificationWithJUnit {
  "The Singly Linked List with Sentinel" should {
    "have no element if just constructed" in {
      val linkedList = new SinglyLinkedListWithSentinel[Int]()
      linkedList.size mustEqual 0
    }

    "allow removing from an empty list" in {
      val linkedList = new SinglyLinkedListWithSentinel[Int]()
      linkedList.removeBeginning
      linkedList.size mustEqual 0
    }

    "not remove any node if node after first node is removed" in {
      val linkedList = new SinglyLinkedListWithSentinel[Int]()
      val firstNode = new SingleNode(10)
      linkedList.insertBeginning(firstNode)
      linkedList.removeAfter(firstNode)
      linkedList.size mustEqual 1
    }

    "have no element after adding and removing one element" in {
      val linkedList = new SinglyLinkedListWithSentinel[Int]()
      linkedList.insertBeginning(new SingleNode(10))
      linkedList.removeBeginning
      linkedList.size mustEqual 0
    }

    "have one element after adding two and removing one element" in {
      val linkedList = new SinglyLinkedListWithSentinel[Int]()
      val firstNode = new SingleNode(10)
      linkedList.insertBeginning(firstNode)
      val secondNode = new SingleNode(15)
      linkedList.insertAfter(firstNode, secondNode)
      linkedList.removeBeginning
      linkedList.size mustEqual 1
    }

    "have no elements after adding two and removing two element" in {
      val linkedList = new SinglyLinkedListWithSentinel[Int]()
      val firstNode = new SingleNode(10)
      linkedList.insertBeginning(firstNode)
      val secondNode = new SingleNode(15)
      linkedList.insertAfter(firstNode, secondNode)
      linkedList.removeAfter(firstNode)
      linkedList.removeBeginning
      linkedList.size mustEqual 0
    }
  }
}
