package base.singly_list;

import base.interfaces.SinglyListI;

public class SinglyLinkedList<T> implements SinglyListI<T>{
  
  private static class Node<T> {
    private T data;
    private Node<T> next;
  
    Node(T obj){
      this.data = obj;
      this.next = null;
    }
  
    public String toString(){
      return String.format("%s", this.data);
    }
    
  }

  private Node<T> head;
  private Node<T> tail;
  private int size;

  public SinglyLinkedList(){
    this.head = null;
    this.tail = null;
    this.size = 0;
  }
  @Override
  public boolean isPresent(T node){
    Node<T> testNode = findNode(this.head, node);
    
    return testNode != null;
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return this.head == null;
  }

  @Override
  public void first(){
    System.out.println(this.head);
  }

  @Override
  public void last(){
    System.out.println(this.tail);
  }

  @Override
  public void show() {
    // TODO Auto-generated method stub
    Node<T> currentNode = this.head;

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
    Node<T> newNode = createNode(data);
    
    if(isEmpty()){
      this.head = newNode;
      this.tail = this.head;
    }else{
      newNode.next = this.head;
      this.head = newNode;
    }

    this.size++;
  }

  @Override
  public void insertAfter(T data, T reference) {
    // TODO Auto-generated method stub
    Node<T> newNode = createNode(data);
    Node<T> placeToInsert;  
    
    if(!isEmpty()){
      placeToInsert = findNode(this.head, reference);
      newNode.next = placeToInsert.next;
      placeToInsert.next = newNode;
    }else
      this.head = newNode;
    
    this.size++;
  }

  @Override
  public void insertAtEnd(T data) {
    // TODO Auto-generated method stub
    Node<T> newNode = createNode(data);
    
    if(isEmpty()){
      this.head = newNode;
      this.tail = this.head;
    }else{
      this.tail.next = newNode;
      this.tail = newNode;
    }

    this.size++;
  }
  
  private Node<T> findNode(Node<T> start, T reference) {
    // TODO Auto-generated method stub
    if((start.equals(reference)) || (start.next == null))
      return start;

    return findNode(start.next, reference);
  }

  public Node<T> createNode(T data) {
    // TODO Auto-generated method stub
    Node<T> node = new Node<T>(data);

    return node;
  }

  private Node<T> beforeEnd(Node<T> start){
    if(start.next == this.tail)
      return start;
    
    return beforeEnd(start.next);
  }

  public Node<T> removeFromStart() {
    // TODO Auto-generated method stub
    if(isEmpty()){
      System.out.println("List is empty");
      return null;
    }
    
    Node<T> temp = this.head;
    this.head = temp.next;
    temp.next = null;
    
    if(isEmpty())
      this.tail = this.head;
    
    this.size--;
    return temp;
  }
  
  public Node<T> removeAfter(T reference) {
    // TODO Auto-generated method stub
    if(isEmpty()){
      System.out.println("List is empty");
      return null;
    }

    Node<T> placeToRemove = findNode(head, reference);
    
    if(placeToRemove.next == null)
      return null;
    
    Node<T> temp = placeToRemove.next;
    placeToRemove.next = temp.next;
    
    this.size--;
    return temp;
  }

  public Node<T> removeFromEnd() {
    // TODO Auto-generated method stub
    if(isEmpty()){
      System.out.println("List is empty");
      return null;
    }
    
    this.size--;

    if(this.head == this.tail){
      Node<T> temp = this.head;
      this.head = null;
      this.tail = null;
      return temp;
    }

    Node<T> previousEnd = beforeEnd(this.head);
    Node<T> end = previousEnd.next;
    
    previousEnd.next = null;
    this.tail = previousEnd;
    
    return end;
  }

  public Node<T> remove(T reference){
    if(isEmpty()){
      System.out.println("List is empty");
      return null;
    }

    if ((reference == this.tail) || (this.head == this.tail))
      return removeFromEnd();

    return removeFromStart();
  }
}
