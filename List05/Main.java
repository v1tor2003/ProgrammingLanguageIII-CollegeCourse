import base.agendamento.Agendamento;
import base.agendamento.ListaDeAgendamentos;

public class Main {
  public static void main (String[] args){
    Agendamento test = new Agendamento("Vitor",null , "7398845529", 1, 1, 2022);
    Agendamento test1 = new Agendamento("Vitor",null , "7398845521", 2, 1, 2022);
  
    ListaDeAgendamentos agendamentos = new ListaDeAgendamentos();
    
    agendamentos.agendar(test);
    agendamentos.agendar(test1);

    agendamentos.show();

  
  }
}
