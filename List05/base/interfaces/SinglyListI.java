package base.interfaces;

public interface SinglyListI<T> {
  @Override
  String toString();
  boolean isEmpty();
  void show();
  void insertAtStart(T data);
  void insertAfter(T data, T reference);
  void insertAtEnd(T data);
  String first();
  String last();
  boolean isPresent(T data);
  //T findNode(T start, T reference);
  //T createNode(T data);
  //T removeFromStart();
  //T removeAfter(T reference);
  //T removeFromEnd();
  //T remove();
}
