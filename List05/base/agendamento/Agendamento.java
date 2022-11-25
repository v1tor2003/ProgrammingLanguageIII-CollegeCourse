package base.agendamento;

import base.data_hora.DataHoraComp;

public class Agendamento {
  private Contato person;
  private DataHoraComp scheduledTime;

  public Agendamento(String name, String email, String telefone, int dia, int mes, int ano, int hora, int min, int sec){
    this.person = new Contato(name, email, telefone);
    this.scheduledTime = new DataHoraComp(dia, mes, ano, hora, min, sec);
  }

  public Agendamento(String name, String email, String telefone, int dia, int mes, int ano){
    this(name, email, telefone, dia, mes, ano, 0, 0, 0);
  }
  
  public String toString(){
    String str = String.format("Pessoa: %s", person.getNome());
    if(person.isEmailValid())
      str += String.format(", email: %s.", person.getEmail());
    else if(person.isPhoneValid())
      str += String.format(", telefone: %s.", person.getTelefone());
    
    str += String.format("\nAgendado para: %s, horario: %s.", 
                          scheduledTime.getData(), scheduledTime.getHora());
   
    return str;
  }

  private boolean compare(Agendamento obj){
    return this.scheduledTime.isEqual(obj.scheduledTime); 
  }

  @Override
  public boolean equals(Object obj){
    if (obj == this)
      return true;
    
    return compare((Agendamento) obj);
  }
}
