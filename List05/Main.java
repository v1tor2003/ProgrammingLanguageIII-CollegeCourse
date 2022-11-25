import base.agendamento.Agendamento;
import base.singly_list.SinglyLinkedList;

public class Main {
  public static void main (String[] args){
    Agendamento test = new Agendamento("Vitor",null , "7398845529", 1, 1, 2022);
    Agendamento test1 = new Agendamento("Vitor",null , "7398845521", 2, 1, 2022);
    Agendamento test2 = new Agendamento("Sexo",null , "7398845520", 2, 1, 2022);
    SinglyLinkedList<Agendamento> list = new SinglyLinkedList<>();

    list.insertAtEnd(test);
    list.insertAtEnd(test1);
    list.insertAfter(test2, test);



    list.show();
  }
}
