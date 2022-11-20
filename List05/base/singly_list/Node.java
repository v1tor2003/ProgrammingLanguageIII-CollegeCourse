package base.singly_list;

public class Node {
  int data;
  Node next;

  Node(int data){
    this.data = data;
    this.next = null;
  }



  public String toString(){
    return String.format("Info: %d", this.data);
  }
}
