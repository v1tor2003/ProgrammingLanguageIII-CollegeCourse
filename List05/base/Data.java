package base;
public class Data{
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
    this(dataInput.dia, dataInput.mes, dataInput.ano);
  }

  private boolean verificarData(int dia, int mes, int ano){
    if(mes == 2){
      if(ano % 4 == 0 || ano % 100 == 0 || ano % 400 == 0)
        return ((dia >= 1 && dia <= 29) && (ano >= 1900 && ano <= 2100));

      return ((dia >= 1 && dia <= 28) && (ano >= 1900 && ano <= 2100));
    }

    return ((mes >= 1 && mes <= 12) && (dia >= 1 && dia <= 31) && (ano >= 1900 && ano <= 2100));
  }

  public boolean isPrevious(Data outraData){
    if(howManyDays(outraData) >= 0)
      return false;

    return true;
  }
  
  public String dayOfWeek(){
    final int jan = 1, feb = 2, mesEspecial = 13, anoAnterior = this.ano - 1;
    float nomeDia;
    String diasSemana [] = new String [7]; 
    
    diasSemana[0] = "sabado";
    diasSemana[1] = "domingo";
    diasSemana[2] = "segunda";
    diasSemana[3] = "terca";
    diasSemana[4] = "quarta";
    diasSemana[5] = "quinta";
    diasSemana[6] = "sexta";

    if(this.mes == jan || this.mes == feb)
      nomeDia = findName(this.dia, mesEspecial, anoAnterior);
    else
      nomeDia = findName(this.dia, this.mes, this.ano);
    
    int result = (int) nomeDia % 7;
    
    return diasSemana[result];
  }
  
  private float findName(int dia, int mes, int ano){
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

  private int calcQntdDaysEach(int dia, int mes, int ano){
    final int diasNoAno = 365;
    final int mesDuracaoPadrao = 30;
    final int feb = 2;

    int febDuracao = 2;
    
    if(mes < feb)
      febDuracao = 0;
    
    int dias = ((dia - 1) + ((ano - 1) * diasNoAno) + countLeapYears(mes, ano) + ((mes - 1) * mesDuracaoPadrao) - febDuracao + countExtraDayMonths(mes)); 
    
    return dias;
  }

  private int countLeapYears(int month, int years){
    final int feb = 2;
    int leapYearsCounter = 0;

    for (int i = 1; i <= years; i++){
      if(i % 4 == 0 || i % 100 == 0 || i % 400 == 0)
        leapYearsCounter++;
    }
    
    if(month != feb )
      return leapYearsCounter;
    
    return leapYearsCounter - 1;
  }

  private int countExtraDayMonths(int month){
    final int jan = 1, mar = 3, may = 5, jul = 7, aug = 8, dec = 12;
    int extraDays = 0;
    
    for(int i = 1; i < month; i++){
      if((i == jan) || (i == mar) || (i == may) || (i == jul) || (i == aug) || (i == dec))
        extraDays++;
    }

    return extraDays;
  }
  public String imprimirData(){
    String str = "";
    
    if(dia < 10 && mes < 10)
      str = String.format("0%d/0%d/%d", this.dia, this.mes, this.ano);
    else if(dia < 10)
      str = String.format("0%d/%d/%d", this.dia, this.mes, this.ano);
    else if(mes < 10)
      str = String.format("%d/0%d/%d", this.dia, this.mes, this.ano);
    else 
      str = String.format("%d/%d/%d", this.dia, this.mes, this.ano);

    return str;
  }

  private String nomeMesExtenso(int mes){
    String meses [] = {"janeiro", "fevereiro", "marco", "abril",
                        "maio", "junho", "julho", "agosto",
                        "setembro", "outubro", "novembro", "dezembro"};
    return meses[mes - 1];
  }

  public String imprimirDataExtenso(){
    
    return String.format("%d de %s de %d", this.dia, nomeMesExtenso(this.mes), this.ano);
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

  public int acharAno(){
    return ano;
  }

  public int acharMes(){
    return mes;
  }

  public String toString(){
    return imprimirData();
  }
}
