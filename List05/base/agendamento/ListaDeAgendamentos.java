package base.agendamento;

import base.singly_list.SinglyLinkedList;

public class ListaDeAgendamentos {
  private SinglyLinkedList<Agendamento> list;
  
  public ListaDeAgendamentos(){
    list = new SinglyLinkedList<>();
  }

  public void toSchedule(Agendamento obj){
    list.insertAtStart(obj);
  }

  public Object removeSchedule(Agendamento reference){
    return list.remove(reference);
  }

  public void show(){
    System.out.println("Lista de Agendamentos:");
    list.show();
  }

  // ListaDeAgendamentos.ordernar is the one Left, 
  // Also we need to fix isPresent()
  // We are getting troubles comparing, it´s comparing the class
  // Not the scheduleTime as we want
  // methods:
  // toSchedule(obj)
  // removeSchedule(refObj)
  // show()
}
