package ds.linkedlist;

import org.specs2.mutable._

class TestSinglyLinkedList  extends SpecificationWithJUnit {
  "The Singly Linked List" should {
    "have no element if just constructed" in {
      val linkedList = new SinglyLinkedList[Int]()
      linkedList.head must beEqualTo(None)
      linkedList.size mustEqual 0
    }

    "allow removing from an empty list" in {
      val linkedList = new SinglyLinkedList[Int]()
      linkedList.removeBeginning
      linkedList.head must beEqualTo(None)
      linkedList.size mustEqual 0
    }

    "not remove any node if node after first node is removed" in {
      val linkedList = new SinglyLinkedList[Int]()
      val firstNode = new Node(10)
      linkedList.insertBeginning(firstNode)
      linkedList.removeAfter(firstNode)
      linkedList.head must beEqualTo(Some(firstNode))
      linkedList.size mustEqual 1
    }

    "have no element after adding and removing one element" in {
      val linkedList = new SinglyLinkedList[Int]()
      linkedList.insertBeginning(new Node(10))
      linkedList.removeBeginning
      linkedList.head must beEqualTo(None)
      linkedList.size mustEqual 0
    }

    "have one element after adding two and removing one element" in {
      val linkedList = new SinglyLinkedList[Int]()
      val firstNode = new Node(10)
      linkedList.insertBeginning(firstNode)
      val secondNode = new Node(15)
      linkedList.insertAfter(firstNode, secondNode)
      linkedList.removeBeginning
      linkedList.head must beEqualTo(Some(secondNode))
      linkedList.size mustEqual 1
    }

    "have no elements after adding two and removing two element" in {
      val linkedList = new SinglyLinkedList[Int]()
      val firstNode = new Node(10)
      linkedList.insertBeginning(firstNode)
      val secondNode = new Node(15)
      linkedList.insertAfter(firstNode, secondNode)
      linkedList.removeAfter(firstNode)
      linkedList.removeBeginning
      linkedList.head must beEqualTo(None)
      linkedList.size mustEqual 0
    }
  }
}
