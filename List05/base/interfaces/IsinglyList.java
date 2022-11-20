package base.interfaces;
import base.singly_list.Node;

public interface IsinglyList {
  @Override
  String toString();
  boolean isEmpty();
  void show();
  void insertAtStart(int data);
  void insertAfter(int data, int reference);
  void insertAtEnd(int data);
  Node findNode(Node start, int reference);
  Node findEnd(Node start);
  Node createNode(int data);
  Node removeFromStart();
  Node removeAfter(int reference);
  Node removeFromEnd();
}
