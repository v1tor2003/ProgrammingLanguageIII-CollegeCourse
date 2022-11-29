import base.agendamento.Agendamento;
import base.agendamento.TestSimples;
import base.singly_list.SinglyLinkedList;

public class Main {
  public static void main (String[] args){
    TestSimples vitor = new TestSimples("Vitor", 1);
    TestSimples bruno = new TestSimples("Bruno", 2);
    TestSimples pedro = new TestSimples("Pedro", 3);
    TestSimples luiz = new TestSimples("Luiz", 4);
    TestSimples inavlida = null;
    TestSimples pessoaEspecial = new TestSimples("ESPECIAl", 6);

    SinglyLinkedList<TestSimples> list = new SinglyLinkedList<>();
    list.insertAtEnd(vitor);
    list.insertAtEnd(bruno);
    list.insertAtEnd(pedro);
    list.insertAfter(bruno, pessoaEspecial);
    list.insertAtStart(luiz);

    list.show();
System.out.println("return " + list.removeAfter(vitor));
  
System.out.println("\n");
    list.show();


  }
}
