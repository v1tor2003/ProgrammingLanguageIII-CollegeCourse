import base.singly_list.SinglyLinkedList;

public class Main {
  public static void main (String[] args){
    SinglyLinkedList<String> myList = new SinglyLinkedList<>();
    myList.insertAtStart("Vitor");
    myList.insertAtStart("TestStart");
    myList.insertAtEnd("TestEnd");
    
    myList.insertAfter("null", "Vitor");
    myList.show();

    myList.removeFromStart();
    myList.removeFromEnd();
    myList.removeAfter("Vitor");
    System.out.println();
    myList.show();

  }
}
