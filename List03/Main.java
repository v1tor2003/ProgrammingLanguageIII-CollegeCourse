public class Main {
  public static void main(String[] args) {
    System.out.println("\nTeste Hora:");
    TimeAsInt time1 = new TimeAsInt(20, 30, 00);
    TimeAsInt outraHora = new TimeAsInt(22, 00, 00);;
    
    System.out.print("Object Time: "); 
    time1.prnTime();
    System.out.println();
  
    System.out.println("is Am? " + time1.isAm());
    
    System.out.print("Cron Time, from "); 
    time1.prnTime();
    System.out.print(" to ");
    outraHora.prnTime();
    System.out.println(" = " + time1.cron(outraHora) + " secs");

    int secondsToAdd = 3600;
    time1.addSeconds(secondsToAdd);
    
    System.out.print("Object time + " + secondsToAdd +" secs = ");
    time1.prnTime();

    System.out.println("\n\n--------------------------------------\n");
    
    System.out.println("Teste Data:");
    Data data1 = new Data(1, 1, 2021);
    Data data2 = new Data(1, 1, 2022);

    data1.imprimirDataExtenso();
    System.out.println();

    data2.imprimirDataExtenso();
    System.out.println();

    System.out.print("is ");
    data2.imprimirData();
    System.out.print(" previous to ");
    data1.imprimirData();
    System.out.println(" ? " + data1.isPrevious(data2));

    System.out.print("howManyDays from ");
    data1.imprimirData();
    System.out.print(" to ");
    data2.imprimirData();
    System.out.println(" ? " + data1.howManyDays(data2));

    System.out.print(data1.dayOfWeek() + ", ");
    data1.imprimirDataExtenso();
    System.out.println();

    System.out.print(data2.dayOfWeek() + ", ");
    data2.imprimirDataExtenso();
    System.out.println();

    System.out.println("\n\n--------------------------------------\n");
    
    System.out.println("Teste Contato:");
    Contato contato1 = new Contato("Vitor Pires", "vitor.pr04@hotmail.com", "7398545529", 29, 9, 2003);
    contato1.imprimirContato();

    System.out.println("\n\n--------------------------------------\n");
    
    System.out.println("Teste Lampada:");
    Lampada lampada1 = new Lampada();
    lampada1.acende();
    lampada1.mostraEstado();
    lampada1.apaga();
    lampada1.mostraEstado();
    
    System.out.println("\n\n--------------------------------------\n");
    
    System.out.println("Teste Ponto2D (testando em ponto1):");
    Ponto2D ponto1 = new Ponto2D(1,2);
    Ponto2D ponto2 = new Ponto2D(2,2);

    ponto1.imprimirPonto();
    ponto2.imprimirPonto();

    System.out.println("isEixoX? " + ponto1.isEixoX());
    System.out.println("isEixoY? " + ponto1.isEixoY());
    System.out.println("isEixos? " + ponto1.isEixos());
    System.out.println("Quadrante = " + ponto1.quadrante());
    System.out.println("Distancia = " + ponto1.distancia(ponto2));

    System.out.println("\n\n--------------------------------------\n");
    
    System.out.println("Teste Circulo (testando em circulo1):");
    Circulo circulo1 = new Circulo(1, 2, 2);
    Circulo circulo2 = new Circulo(2, 2, 2);

    circulo1.imprimirCirculo();
    circulo2.imprimirCirculo();

    System.out.println("isInnerPoint (ponto1 em circulo1)? " + circulo1.isInnerPoint(ponto1));
    System.out.println("isBiggerThan:" + circulo1.isBiggerThan(circulo2));
    System.out.println("Area:" + circulo1.area());
    System.out.println("Perimeter:" + circulo1.perimeter()+"\n");




    
  }
}
