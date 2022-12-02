package List08.singly_list;

public interface SinglyListI<T> {
  @Override
  String toString();
  boolean isEmpty();
  void insertAtStart(T data);
  void insertAfter(T data, T reference);
  void insertAtEnd(T data);
  void clear();
  String first();
  String last();
  boolean contains(T data);
  //T findNode(T start, T reference);
  //T createNode(T data);
  //T removeFromStart();
  //T removeAfter(T reference);
  //T removeFromEnd();
  //T remove();
}
