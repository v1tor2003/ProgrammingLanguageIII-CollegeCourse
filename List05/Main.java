import base.singly_list.SinlgyLinkedList;

public class Main {
  public static void main (String[] args){
    SinlgyLinkedList myList = new SinlgyLinkedList();
    myList.insertAtEnd(1);
    myList.insertAtEnd(2);
    myList.insertAtEnd(3);

    myList.insertAtStart(20);
    myList.insertAtStart(10);
    myList.insertAtStart(30);
    myList.show();

    myList.removeFromStart();
    myList.removeAfter(20);
    myList.removeFromEnd();
    myList.removeFromEnd();
    
    System.out.println();
    myList.show();
  }
}
