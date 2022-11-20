package agendamento;

import base.data_hora.DataHoraComp;

public class Agendamento {
  private Contato person;
  private DataHoraComp scheduledTime;

  public Agendamento(String name, String email, String telefone){
    this.person = new Contato(name, email, telefone);
    this.scheduledTime = new DataHoraComp();
  }

  public String toString(){
    return person + "Agendamento " + scheduledTime;
  }
}
