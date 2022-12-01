package List08.programa_agenda;

import List06.base.statics.Data;
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

  public String search(String cpf){
    PessoaBase aux = findInTheAgenda(cpf);
    if(aux == null)
      return "CPF nao encontrado";
    else
      return String.format("%s", aux);
  }

  public PessoaBase findInTheAgenda(String cpf){
    Data defaultdate = new Data();
    PessoaBase reference = new PessoaFisica("", "", "", "", defaultdate, cpf);
    Node<PessoaBase> result = (super.findNode(this.head, reference));
    return result.getData();
  }

}
