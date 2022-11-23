import base.singly_list.SinglyLinkedList;

//import base.agendamento.Agendamento;

public class Main {
  public static void main (String[] args){
    //Agendamento test = new Agendamento("Vitor",null , "7398845529", 1, 1, 2022);
    //Agendamento test1 = new Agendamento("Vitor",null , "7398845521", 1, 1, 2022);
    SinglyLinkedList<Integer> test = new SinglyLinkedList<>();
    test.insertAtEnd(1);
    test.insertAtEnd(2);
    test.insertAfter(3, 2);
    
    test.show();
    test.remove(1);
    System.out.println();
    test.show();
   

  
  }
}
