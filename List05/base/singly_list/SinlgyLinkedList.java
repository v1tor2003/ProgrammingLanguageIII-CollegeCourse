package base.singly_list;
import base.interfaces.IsinglyList;

public class SinlgyLinkedList implements IsinglyList {
  private Node head;

  public SinlgyLinkedList(){
    this.head = null;
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return this.head == null;
  }

  @Override
  public void insertAtStart(int data) {
    // TODO Auto-generated method stub
    Node newNode = createNode(data);
    
    if(!isEmpty())
      newNode.next = this.head;
    
    this.head = newNode;
  }

  @Override
  public void insertAfter(int data, int reference) {
    // TODO Auto-generated method stub
    Node newNode = createNode(data);
    Node placeToInsert = findNode(this.head, reference);

    newNode.next = placeToInsert.next;
    placeToInsert.next = newNode;
  }

  @Override
  public void insertAtEnd(int data) {
    // TODO Auto-generated method stub
    Node newNode = createNode(data);

    if(isEmpty()){
      this.head = newNode;
    }else{
      Node end = findEnd(this.head);
      end.next = newNode;
    }
    
  }

  @Override
  public Node removeFromStart() {
    // TODO Auto-generated method stub
    if(isEmpty()){
      System.out.println("List is empty");
      return null;
    }

    Node temp = this.head;
    this.head = temp.next;

    return temp;
  }

  @Override
  public Node removeAfter(int reference) {
    // TODO Auto-generated method stub
    if(isEmpty()){
      System.out.println("List is empty");
      return null;
    }
    Node placeToRemove = findNode(head, reference);
    Node temp = placeToRemove.next;
    placeToRemove.next = temp.next;

    return temp;
  }

  @Override
  public Node removeFromEnd() {
    // TODO Auto-generated method stub
    Node start = this.head;
    Node end = findEnd(this.head);

    while(start.next != end){
      start = start.next;
    }

    start.next = end.next;
    
    return end;
  }

  @Override
  public void show() {
    // TODO Auto-generated method stub
    Node currentNode = this.head;

    if(isEmpty()){
      System.out.println("List is empty");
    }else{
      while(currentNode.next != null){
        System.out.println(currentNode);
        currentNode = currentNode.next;
      }
      System.out.println(currentNode);
    }
  }

  @Override
  public Node createNode(int info) {
    // TODO Auto-generated method stub
    Node node = new Node(info);

    return node;
  }

  @Override
  public Node findNode(Node start, int wantedInfo){
    if(start.data == wantedInfo)
      return start;
    if(start.next == null)
      return (start);

    return findNode(start.next, wantedInfo);
  }

  @Override
  public Node findEnd(Node start) {
    // TODO Auto-generated method stub
    if(start.next == null)
      return start;
    
    return findEnd(start.next);
  }
    
}
