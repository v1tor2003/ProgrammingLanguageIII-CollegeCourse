public class Main {
  public static void main(String[] args){
    /*TimeAsInt time1 = new TimeAsInt(20, 15, 11);
    TimeAsInt time2 = new TimeAsInt(15, 20);
    TimeAsInt time3 = new TimeAsInt(12);
    TimeAsInt timeObj = new TimeAsInt(10, 20, 30);
    TimeAsInt time4 = new TimeAsInt(timeObj);
    TimeAsInt time5 = new TimeAsInt();

    System.out.println("Default constructor:");
    time1.prnTime();
    System.out.println();

    System.out.println("HH:MM constructor:");
    time2.prnTime();
    System.out.println();

    System.out.println("HH constructor:");
    time3.prnTime();
    System.out.println();

    System.out.println("From other Obj constructor:");
    time4.prnTime();
    System.out.println();

    System.out.println("Empty args constructor:");
    time5.prnTime();
    System.out.println();
    
    int hours = 1;
    int minutes = 10;
    int seconds = 20;

    System.out.println("Add time:");
    System.out.print("Base time is ");
    time3.prnTime();
    System.out.println();
    
    System.out.println("Add Seconds: ");
    time3.addTime(seconds);
    time3.prnTime();
    System.out.println();

    System.out.println("Add minutes and seconds: ");
    time3.addTime(minutes, seconds);
    time3.prnTime();
    System.out.println();

    System.out.println("Add hours, minutes and seconds: ");
    time3.addTime(hours, minutes, seconds);
    time3.prnTime();
    System.out.println();

    System.out.println("Add Obj: ");
    time3.addTime(timeObj);
    time3.prnTime();
    System.out.println();

    Ponto2D ponto1 = new Ponto2D(1, 2);
    Ponto2D ponto2 = new Ponto2D(2, 2);
    
    String nome = "Vitor";
    String email = "vitor.pr04@hotmail.com";
    String telefone = "7398545529";
    int dia = 29, mes = 9, ano = 2003;
    
    Contato contato1 = new Contato(nome, email, telefone, dia, mes, ano);
    Contato contato2 = new Contato(nome, email, telefone);
    Contato contato3 = new Contato(nome);
    
    System.out.println("distancia do Ponto1 para Ponto2 = " + ponto1.distancia(ponto2));
    System.out.println("distancia ponto 1 para origem = " + ponto1.distancia());
    System.out.println("distancia ponto 1 para x e y = " + ponto1.distancia(ponto2.getX(), ponto2.getY()));

    System.out.println("Contato construtor completo");
    contato1.imprimirContato();
    System.out.println();

    System.out.println("Contato construtor de 3 args");
    contato2.imprimirContato();
    System.out.println();

    System.out.println("Contato construtor so com nome");
    contato3.imprimirContato();
    System.out.println();
    */

    RoboSimples robo = new RoboSimples(null,0, 1, 'f');
    robo.toString();
  }  
} 
