package List06.base.statics;

import java.util.Calendar;

public class Data{
  private static final int feb = 2, febDuration = 28, longerMonth = 31, defaultMonth = 30;
  private static final String diasSemana [] = new String [] {"sabado", "domingo", "segunda",
                                                            "terca", "quarta", "quinta", "sexta"}; 

  private static final String meses [] = new String [] {"janeiro", "fevereiro", "marco", "abril",
                                                        "maio", "junho", "julho", "agosto",
                                                        "setembro", "outubro", "novembro", "dezembro"}; 
  private int dia;
  private int mes;
  private int ano;

  public Data(int dia, int mes, int ano){
    if(verificarData(dia, mes, ano)){
      this.dia = dia;
      this.mes = mes;
      this.ano = ano; 
    }else{
      this.dia = 1;
      this.mes = 1;
      this.ano = 1970;
    }
  }

  public Data(){
    this(0, 0, 0);
  }

  public Data(Data dataInput){
    this(dataInput.getDia(), dataInput.getMes(), dataInput.getAno());
  }
  
  
  private boolean verificarData(int dia, int mes, int ano){
    boolean isYearValid = checkYear(ano);
    
    if(mes == feb){
      if(Data.isBissexto(ano))
        return ((dia >= 1 && dia <= febDuration + 1) && isYearValid);

      return ((dia >= 1 && dia <= febDuration) && isYearValid);
    }

    if(Data.is31DaysMonth(mes))
      return (dia >= 1 && dia <= longerMonth) && isYearValid;
    
    return (mes >= 1 && mes <= defaultMonth) && isYearValid; 
  }

  private boolean checkYear(int ano){
    return ano >= 1900 && ano <= 2100;
  }

  public boolean isPrevious(Data outraData){
    if(howManyDays(outraData) >= 0)
      return false;

    return true;
  }
  
  public String dayOfWeek(){

    return diasSemana[getMonthName(this.dia, this.mes, this.ano)];
  }
  
  public static String dayOfWeek(int dia, int mes, int ano){

    return diasSemana[getMonthName(dia, mes, ano)];
  }

  private static int getMonthName(int dia, int mes, int ano){
    final int jan = 1, mesEspecial = 13, anoAnterior = ano - 1;;
    float nomeDia;

    if(mes == jan || mes == feb)
      nomeDia = Data.findName(dia, mesEspecial, anoAnterior);
    else
      nomeDia = Data.findName(dia, mes, ano);
  
    int result = (int) nomeDia % 7;
  
    return result;
  }

  public static Data getCurrentData(){
    Calendar currentData = Calendar.getInstance();
    int dia = currentData.get(Calendar.DAY_OF_MONTH);
    int mes = currentData.get(Calendar.MONTH);
    int ano = currentData.get(Calendar.YEAR);

    return new Data(dia, mes+1, ano);
  }

  
  private static float findName(int dia, int mes, int ano){
    return (float) (dia + (2.0 * mes) + (3.0 * (mes + 1.0) / 5.0) + ano + (ano / 4.0) - (ano / 100.0) + (ano / 400.0) + 2.0);
  }

  public int howManyDays(Data outraData){
    int outraDataDias = calcQntdDaysEach(outraData.dia, outraData.mes, outraData.ano);
    int objDias = calcQntdDaysEach(this.dia, this.mes, this.ano);
    
    return (outraDataDias - objDias);
  }

  public int howManyDays(int dia, int mes, int ano){
    int outraDataDias = calcQntdDaysEach(dia, mes, ano);
    int objDias = calcQntdDaysEach(this.dia, this.mes, this.ano);
    
    return (outraDataDias - objDias);
  }

  public static int howManyDaysUntilEndYear(Data d){   
    final int dec = 12;
    final int currentYear = d.getAno();
    final int startMonth = d.getMes() + 1;
    int difDataEndYear = 0;

    int firstMonth = Data.howManyDaysUntilNextMonth(d.getDia(), d.getMes(), currentYear);
    
    for (int i = startMonth; i <= dec; i++)
      difDataEndYear += Data.howManyDaysUntilNextMonth(1, d.getMes(), currentYear);
    
    return firstMonth + difDataEndYear;
  }

  public static int howManyDaysUntilNextMonth(Data d){
    return howManyDaysUntilNextMonth(d.getDia(), d.getMes(),d.getAno());
  }

  public static int howManyDaysUntilNextMonth(int currentDay,int currentMonth, int currentYear){
    int result;

    if(currentMonth == feb)
      if(Data.isBissexto(currentYear))
        result = febDuration + 1 - currentDay;
      else 
        result = febDuration - currentDay;

    if(Data.is31DaysMonth(currentMonth))
      result = longerMonth - currentDay;
    else
      result = defaultMonth - currentDay; 
    
    return result + 1;
  }

  public static boolean isBissexto(int ano){
    return ano % 4 == 0 || ano % 100 == 0 || ano % 400 == 0;
  }

  public boolean isEquals(Data other){
    return howManyDays(other) == 0;
  }

  public static boolean isBissexto(Data d){
    return isBissexto(d.getAno());
  }

  private static int calcQntdDaysEach(int dia, int mes, int ano){
    final int diasNoAno = 365;
    final int mesDuracaoPadrao = 30;
    final int feb = 2;

    int febDuracao = 2;
    
    if(mes < feb)
      febDuracao = 0;
    
    int dias = ((dia - 1) + ((ano - 1) * diasNoAno) + countLeapYears(mes, ano) + ((mes - 1) * mesDuracaoPadrao) - febDuracao + countExtraDayMonths(mes)); 
    
    return dias;
  }

  private static int countLeapYears(int month, int years){
    final int feb = 2;
    int leapYearsCounter = 0;

    for (int i = 1; i <= years; i++){
      if(Data.isBissexto(i))
        leapYearsCounter++;
    }
    
    if(month != feb )
      return leapYearsCounter;
    
    return leapYearsCounter - 1;
  }

  private static int countExtraDayMonths(int month){
    int extraDays = 0;
    
    for(int i = 1; i < month; i++){
      if(Data.is31DaysMonth(month))
        extraDays++;
    }

    return extraDays;
  }

  public static boolean is31DaysMonth(int month){
    final int jan = 1, mar = 3, may = 5, jul = 7, aug = 8, dec = 12;
    return (month == jan) || (month == mar) || (month == may) || (month == jul) || (month == aug) || (month == dec);
  }

  public String imprimirData(){
    final int conditionToShow0 = 10;

    return formatedShortDataOutput(this.dia, this.mes, this.ano, conditionToShow0);
  }

  private static String formatedShortDataOutput(int dia, int mes, int ano, int show0){
    String diaStr = formatedIntegerOutput(dia, show0);
    String mesStr = formatedIntegerOutput(mes, show0);
    
    return String.format("%s/%s/%d", diaStr, mesStr, ano); 
  }

  public static String imprimirData(int dia, int mes, int ano){
    final int conditionToShow0 = 10;

    return formatedShortDataOutput(dia, mes, ano, conditionToShow0);
  }

  private static String formatedIntegerOutput(int input, int conditional){
    String output = Integer.toString(input);

    if(input < conditional)
      return output = "0" + output;
    
    return output;
  }

  private static String nomeMesExtenso(int mes){
    
    return meses[mes - 1];
  }

  public String imprimirDataExtenso(){
    
    return formatedLongDataOutput(this.dia, this.mes, this.ano);
  }

  public static String imprimirDataExtenso(int dia, int mes, int ano){

    return formatedLongDataOutput(dia, mes, ano);
  }

  private static String formatedLongDataOutput(int dia, int mes, int ano){
    return String.format("%d de %s de %d", dia, nomeMesExtenso(mes), ano);
  }

  public int getDia(){
    return dia;
  }

  public int getMes(){
    return mes;
  }

  public int getAno(){
    return ano;
  }

  public static  int getDefaultMonthDuration(){
    return defaultMonth;
  }
  
  public void setData(int dia, int mes, int ano){
    if(verificarData(dia, mes, ano)){
      this.dia = dia;
      this.mes = mes;
      this.ano = ano;
    }
    else{
      System.out.println("Data invalida");
    }
  }

  public void setData(Data outraData){
    this.setData(outraData.dia, outraData.mes, outraData.ano);
  }

  public String toString(){
    return imprimirData();
  }
}
