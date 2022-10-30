class Data{
  private int dia;
  private int mes;
  private int ano;

  public void inicializarData(){
    int diaDefault = 1;
    int mesDefault = 1;
    int anoDefault = 1900;
    
    setData(diaDefault, mesDefault, anoDefault);

  }

  private boolean verificarData(int dia, int mes, int ano){
    if(mes == 2){
      return ((dia >= 1 && dia <= 28) && (ano >= 1900 && ano <= 2100));
    }
    return ((mes >= 1 && mes <= 12) && (dia >= 1 && dia <= 31) && (ano >= 1900 && ano <= 2100));
  }

  public void imprimirData(){
    if(dia < 10 && mes < 10)
      System.out.println("0" + dia + "/0" + mes + "/"+  ano);
    else if(dia < 10)
      System.out.println("0" + dia + "/" + mes + "/"+  ano);
    else if(mes < 10)
      System.out.println(dia + "/0" + mes + "/"+  ano);
    else 
      System.out.println(dia + "/" + mes + "/"+  ano);
  }
  
  public void imprimirDataExtenso(){
    String mesExtenso;
    switch(mes){
      case 1:
        mesExtenso = "janeiro";
      break;
      case 2:
        mesExtenso = "fevereiro";
      break;
      case 3:
        mesExtenso = "marco";
      break;
      case 4:
        mesExtenso = "abril";
      break;
      case 5:
        mesExtenso = "maio";
      break;
      case 6:
        mesExtenso = "junho";
      break;
      case 7:
        mesExtenso = "julho";
      break;
      case 8:
        mesExtenso = "agosto";
      break;
      case 9:
        mesExtenso = "setembro";
      break;
      case 10:
        mesExtenso = "outubro";
      break;
      case 11:
        mesExtenso = "novembro";
      break;
      case 12:
        mesExtenso = "dezembro";
      break;
      default:
        mesExtenso = "janeiro";
    }
    System.out.println(dia + " de " + mesExtenso + " de " + ano+ '.');
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
  int acharAno(){
    return ano;
  }
  int acharMes(){
    return mes;
  }
}