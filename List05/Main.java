import base.agendamento.Agendamento;
import base.agendamento.Agendamentos;

public class Main {
  public static void main (String[] args){
    
    // some fix to do
    Agendamento ag1 = new Agendamento("vitor", "vitor.pr@teste", "7398845529", 1, 2, 2022);
    Agendamento ag2 = new Agendamento("vitor", "vitor.pr@teste", "7398845529", 1, 2, 2022);
    Agendamento ag3 = new Agendamento("fulano", "fulano.pr@teste", "7398845529", 20, 2, 2022);
    Agendamento ag4 = new Agendamento("ciclano", "ciclano.pr@teste", "7398845529", 20, 3, 2022);

    Agendamentos agendamentos = new Agendamentos();
    agendamentos.toSchedule(ag1);
    agendamentos.toSchedule(ag3);
    agendamentos.toSchedule(ag4);

    agendamentos.show();


  }
}
