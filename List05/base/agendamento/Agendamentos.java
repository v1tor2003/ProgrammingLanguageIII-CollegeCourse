package base.agendamento;

import base.singly_list.SinglyLinkedList;

public class Agendamentos {
  private SinglyLinkedList<Agendamento> list;
  
  public Agendamentos(){
    list = new SinglyLinkedList<>();
  }

  public void toSchedule(Agendamento obj){
    if(!list.isPresent(obj))
      list.insertAtEnd(obj);
    else
      System.out.println("hora/data invalida, ja existe agendamento marcado");
  }

  public Object removeSchedule(Agendamento reference){
    return list.remove(reference);
  }

  public void show(){
    System.out.println("Lista de Agendamentos:");
    list.show();
  }

  // Agendamentos.ordernar is the one Left, 
  // Also we need to fix isPresent()
  // We are getting troubles comparing, it´s comparing the class
  // Not the scheduleTime as we want
  // methods:
  // toSchedule(obj)
  // removeSchedule(refObj)
  // show()
}
