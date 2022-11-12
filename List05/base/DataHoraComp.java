package base;

import base.interfaces.IdataHora;

// USING COMPOSITION HERE
public class DataHoraComp implements IdataHora {
  private Data data;
  private TimeAsInt hora;

  public DataHoraComp(int dia, int mes, int ano, int hora, int min, int sec){
    this.data = new Data(dia, mes, ano);
    this.hora = new TimeAsInt(hora, min, sec);
  } 

  public DataHoraComp(){
    this(0,0,0,0,0,0);
  }

  public DataHoraComp(int dia, int mes, int ano){
    this(dia, mes, ano, 0,0,0);
  }

  public DataHoraComp(Data data){
    this(data.getDia(), data.getMes(), data.getAno(), 0, 0 ,0);
  }

  public DataHoraComp(Data data, TimeAsInt hora){
    this(data.getDia(), data.getMes(), data.getAno(), 0, 0 , hora.getTimeAsSeconds());
  }

  @Override
  public boolean isEqual(DataHoraComp outra) {
    // TODO Auto-generated method stub
    return (!isLower(outra) && !isGreater(outra));
  }
  
  @Override
  public boolean isGreater(DataHoraComp outra) {
    // TODO Auto-generated method stub
    int diasPassados = data.howManyDays(outra.data);

    if(diasPassados > 0)
      return true;
    else if((diasPassados == 0) && (hora.howManySeconds(outra.hora) > 0))
      return true;

    return false;
  }
  
  @Override
  public boolean isLower(DataHoraComp outra) {
    // TODO Auto-generated method stub
    int diasPassados = data.howManyDays(outra.data);

    if(diasPassados < 0)
      return true;
    else if((diasPassados == 0) && (hora.howManySeconds(outra.hora) < 0))
      return true;

    return false;
  }

  public String toString(){
    return data + ", " + hora;
  }
}
