package List08.singly_list;

public class SinglyLinkedList<T> implements SinglyListI<T>{
  
  protected static class Node<T> {
    public T data;
    private Node<T> next;
  
    Node(T obj){
      this.data = obj;
      this.next = null;
    }

    public String toString(){
      return String.format("%s", this.data);
    }
  }

  protected Node<T> head;
  private Node<T> tail;
  private int size;

  public SinglyLinkedList(){
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public int size(){
    return this.size;
  }

  @Override
  public boolean contains(T node){
    Node<T> testNode = findNode(this.head, node);
    
    return testNode != null;
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return this.head == null;
  }

  @Override
  public String first(){
    return this.head.toString();
  }

  @Override
  public String last(){
    return this.tail.toString();
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
  public void insertAfter(T reference, T data) {
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
  
  protected Node<T> findNode(Node<T> start, T reference) {
    // TODO Auto-generated method stub
    if(start == null)
      return null;
    
    if((start.data.equals(reference)))
      return start;

    return findNode(start.next, reference);
  }

  public Node<T> createNode(T data) {
    // TODO Auto-generated method stub
    Node<T> node = new Node<T>(data);

    return node;
  }

  @Override
  public void clear(){
    this.head = null;
    this.size = 0;
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

  private Node<T> findBeforeNode(Node<T> start, T reference){
    if(start.next == null || start.next.data.equals(reference))
      return start;

    return findBeforeNode(start.next, reference);
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
    if(this.head.data.equals(reference))
      return removeFromStart();
    else if(this.tail.data.equals(reference))
      return removeFromEnd();
    
    Node <T> beforeRef = findBeforeNode(head, reference);
    return removeAfter(beforeRef.data);
  }

  public String toString(){
    if(isEmpty())
      return "List is empty";
    else{
      Node<T> currentNode = this.head;
      String list = "";
      while(currentNode.next != null){
        list += currentNode + "\n";
        currentNode = currentNode.next;
      }
      list += currentNode;
      return list;
    }
  }
}
