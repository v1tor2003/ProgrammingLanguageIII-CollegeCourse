package List08.programa_agenda;

import List08.singly_list.SinglyLinkedList;

public class Agenda extends SinglyLinkedList<PessoaBase>{
  public Agenda(){
    super();
  }

  public void add(PessoaBase obj){
    super.insertAtEnd(obj);
  }

  public void show(){
    super.show();
  }

  public String search(String reference){
    Node<PessoaBase> result = findNode(reference);
    if(!(result == null))
      return result.toString();
    
    return "Referencia invalida";
  }



}
