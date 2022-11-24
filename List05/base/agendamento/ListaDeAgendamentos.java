package base.agendamento;

import base.singly_list.SinglyLinkedList;

public class ListaDeAgendamentos extends SinglyLinkedList<Agendamento> {
  // ListaDeAgendamentos.ordernar is the one Left, 
  // Also we need to fix isPresent()
  // We are getting troubles comparing, it´s comparing the class
  // Not the scheduleTime as we want
  
  public ListaDeAgendamentos(){
    super();
  }

  public void agendar(Agendamento obj){
    if(isEmpty() || !isPresent(obj)){
      insertAtEnd(obj);
      return;
    }

    System.out.println("A lista ja possui um agendamento para essa hora.");
  }

  public Node removerAgendamento(Agendamento reference){
    Node removedNode = remove(reference);

    if(removedNode == null){  
      System.out.println("Agendamento nao encontrado.");
      return null;
    }

    return removedNode;
  }

  @Override
  public void show(){
    System.out.println("\tLista de Agendamentos:");
    super.show();
  }
}
