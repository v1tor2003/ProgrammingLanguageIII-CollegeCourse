package base.singly_list;

import base.interfaces.IsinglyList;

public class SinglyLinkedList<T> implements IsinglyList<T>{
  private Node head;
  private Node tail;

  class Node {
    T info;
    Node next;

    Node(T info){
      this.info = info;
      this.next = null;
    }

    public String toString(){
      return String.format("%s", this.info);
    }
  }

  public SinglyLinkedList(){
    this.head = null;
    this.tail = null;
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return this.head == null;
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
  public void insertAtStart(T data) {
    // TODO Auto-generated method stub
    Node newNode = createNode(data);
    
    if(isEmpty()){
      this.head = newNode;
      this.tail = this.head;
    }else{
      newNode.next = this.head;
      this.head = newNode;
    }
  }

  @Override
  public void insertAfter(T data, T reference) {
    // TODO Auto-generated method stub
    Node newNode = createNode(data);
    Node placeToInsert;  
    
    if(!isEmpty()){
      placeToInsert = findNode(this.head, reference);
      newNode.next = placeToInsert.next;
      placeToInsert.next = newNode;
    }else
      this.head = newNode;
  }

  @Override
  public void insertAtEnd(T data) {
    // TODO Auto-generated method stub
    Node newNode = createNode(data);
    
    if(isEmpty()){
      this.head = newNode;
      this.tail = this.head;
    }else{
      this.tail.next = newNode;
      this.tail = newNode;
    }
  }
  
  @Override
  public boolean isPresent(T node){
    Node testNode = findNode(this.head, node);
    
    return testNode != null;
  }
  
  private Node findNode(Node start, T reference) {
    // TODO Auto-generated method stub
    if(start.info == reference)
      return start;
    if(start.next == null)
      return start;

    return findNode(start.next, reference);
  }

  public Node createNode(T data) {
    // TODO Auto-generated method stub
    Node node = new Node(data);

    return node;
  }

  public Node removeFromStart() {
    // TODO Auto-generated method stub
    if(isEmpty()){
      System.out.println("List is empty");
      return null;
    }
    
    Node temp = this.head;
    this.head = temp.next;
    temp.next = null;
    
    if(isEmpty())
      this.tail = this.head;
    
    return temp;
  }
  
  public Node removeAfter(T reference) {
    // TODO Auto-generated method stub
    if(isEmpty()){
      System.out.println("List is empty");
      return null;
    }

    Node placeToRemove = findNode(head, reference);
    
    if(placeToRemove.next == null)
      return null;
    
    Node temp = placeToRemove.next;
    placeToRemove.next = temp.next;
    
    return temp;
  }

  private Node beforeEnd(Node start){
    if(start.next == this.tail)
      return start;
    
    return beforeEnd(start.next);
  }

  public Node removeFromEnd() {
    // TODO Auto-generated method stub
    if(isEmpty()){
      System.out.println("List is empty");
      return null;
    }
    
    if(this.head == this.tail){
      Node temp = this.head;
      this.head = null;
      this.tail = null;
      return temp;
    }

    Node previousEnd = beforeEnd(this.head);
    Node end = previousEnd.next;
    
    //if(previousEnd.next == null)
    //  return null;
    
    previousEnd.next = null;
    this.tail = previousEnd;
    
    return end;
  }
}
