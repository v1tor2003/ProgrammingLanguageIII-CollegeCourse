package base.interfaces;

public interface IsinglyList<T> {
  @Override
  String toString();
  boolean isEmpty();
  void show();
  void insertAtStart(T data);
  void insertAfter(T data, T reference);
  void insertAtEnd(T data);
  boolean isPresent(T data);
  //Node<T> findNode(Node<T> start, T reference);
  //Node<T> createNode(T data);
  //Node<T> removeFromStart();
  //Node<T> removeAfter(T reference);
  //Node<T> removeFromEnd();
  //Node<T> remove();
}
