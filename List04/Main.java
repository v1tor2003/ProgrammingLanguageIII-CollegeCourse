public class Main {
  public static void main(String[] args){
    TimeAsInt time1 = new TimeAsInt(20, 15, 11);
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

  }  
} 
