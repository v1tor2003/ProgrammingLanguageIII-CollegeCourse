package List08.programa_agenda;

import List08.singly_list.SinglyLinkedList;

public class Agenda extends SinglyLinkedList<PessoaBase>{
  public Agenda(){
    super();
  }

  public void add(PessoaBase obj){
    super.insertAtEnd(obj);
  }

  public String toString(){
    return "Agenda: \n\n" + super.toString();
  }

  public PessoaBase search(PessoaBase reference){
    
    Node<PessoaBase> foundNode = findNode(this.head, reference);

    if(foundNode == null)
      return null;

    return foundNode.data;
  }

  private PessoaFisica setUpPessoaFisicaToCompare(String info){
    return new PessoaFisica("", "", "", "", 0,0,0, info);
  }

  private PessoaJuridica setUpPessoaJuridicaToCompare(String info){
    return new PessoaJuridica("", "", "", "", 0,0,0, info);
  }

  public PessoaBase searchPessoaFisica(String cpf){
    
    return search(setUpPessoaFisicaToCompare(cpf));
  }

  public PessoaBase searchPessoaJuridica(String cnpj){
    
    return search(setUpPessoaJuridicaToCompare(cnpj));
  }




}
