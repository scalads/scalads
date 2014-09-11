package ds.linkedlist;

import org.specs2.mutable._

class TestDoublyLinkedList  extends SpecificationWithJUnit {
  "The Doubly Linked List" should {
    "have no element if just constructed" in {
      val linkedList = new DoublyLinkedList[Int]()
      linkedList.head must beEqualTo(None)
      linkedList.size mustEqual 0
    }

    "allow removing from an empty list" in {
      val linkedList = new DoublyLinkedList[Int]()
      linkedList.removeBeginning
      linkedList.head must beEqualTo(None)
      linkedList.size mustEqual 0
    }

    "contain none as next and previous element of head of a one element list" in {
      val linkedList = new DoublyLinkedList[Int]()
      val firstNode = new DoubleNode(10)
      linkedList.insertBeginning(firstNode)
      linkedList.head must beEqualTo(Some(firstNode))
      linkedList.size mustEqual 1
      linkedList.head.get.next mustEqual None
      linkedList.head.get.previous mustEqual None
    }

    "not remove any node if node after first node is removed" in {
      val linkedList = new DoublyLinkedList[Int]()
      val firstNode = new DoubleNode(10)
      linkedList.insertBeginning(firstNode)
      linkedList.removeAfter(firstNode)
      linkedList.head must beEqualTo(Some(firstNode))
      linkedList.size mustEqual 1
    }

    "have no element after adding and removing one element" in {
      val linkedList = new DoublyLinkedList[Int]()
      linkedList.insertBeginning(new DoubleNode(10))
      linkedList.removeBeginning
      linkedList.head must beEqualTo(None)
      linkedList.size mustEqual 0
    }

    "have one element after adding two and removing one element" in {
      val linkedList = new DoublyLinkedList[Int]()
      val firstNode = new DoubleNode(10)
      linkedList.insertBeginning(firstNode)
      val secondNode = new DoubleNode(15)
      linkedList.insertAfter(firstNode, secondNode)
      linkedList.removeBeginning
      linkedList.head must beEqualTo(Some(secondNode))
      linkedList.size mustEqual 1
    }

    "have no elements after adding two and removing two element" in {
      val linkedList = new DoublyLinkedList[Int]()
      val firstNode = new DoubleNode(10)
      linkedList.insertBeginning(firstNode)
      val secondNode = new DoubleNode(15)
      linkedList.insertAfter(firstNode, secondNode)
      linkedList.removeAfter(firstNode)
      linkedList.removeBeginning
      linkedList.head must beEqualTo(None)
      linkedList.size mustEqual 0
    }

    "be able to traverse back to head after adding three elements" in {
      val linkedList = new DoublyLinkedList[Int]()
      val firstNode = new DoubleNode(10)
      linkedList.insertBeginning(firstNode)
      val secondNode = new DoubleNode(15)
      linkedList.insertAfter(firstNode, secondNode)
      val thirdNode = new DoubleNode(20)
      linkedList.insertAfter(secondNode, thirdNode)
      linkedList.size mustEqual 3
      linkedList.head mustEqual linkedList.head.get.next.get.next.get.previous.get.previous
    }
  }
}
