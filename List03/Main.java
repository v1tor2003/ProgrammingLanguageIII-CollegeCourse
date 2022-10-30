public class Main {
  public static void main(String[] args) {
    System.out.println("Hora como inteiro:");
    TimeAsInt time1 = new TimeAsInt(20, 30, 00);
    TimeAsInt outraHora = new TimeAsInt(22, 00, 00);;
    
    System.out.print("Object Time: "); 
    time1.prnTime();
    
    System.out.println("is Am? " + time1.isAm());
    
    System.out.print("ObjectCron Time: "); 
    outraHora.prnTime();
    
    int result = time1.cron(outraHora);
    System.out.println("Seconds passed = " + result);
    
    int secondsToAdd = 3600;
    time1.addSeconds(secondsToAdd);
    
    System.out.print("Object time + " + secondsToAdd +"secs = ");
    time1.prnTime();

    System.out.println("\n\n--------------------------------------\n");
    
    System.out.println("Teste Data:");
    Data data1 = new Data(1, 1, 2021);
    Data data2 = new Data(1, 1, 2022);

    System.out.println("isPrevious:" + data1.isPrevious(data2));
    System.out.println("howManyDays:" + data1.howManyDays(data2));
    
    System.out.print(data1.dayOfWeek() + ", ");
    data1.imprimirDataExtenso();

    System.out.print(data2.dayOfWeek() + ", ");
    data2.imprimirDataExtenso();

    // test new version of Contato
    // test new version of Lampada

    // remaining Ponto2D e circle


    
  }
}
