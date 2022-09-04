import java.util.Scanner;

public class Main {  
  public static void main (String[] args){
    float[] mesuares = new float [10];
    readMesuares(mesuares);
    float average = calcAverage(mesuares);
    float detour = calcDetour(average, mesuares);
    System.out.println("Average = " + average);
    System.out.println("Detour = " + detour);
    printMesuares(mesuares);
    checkDetour(detour, average);
  } 

  private static float calcDetour(float average, float mesuares[]){
    float sum = 0.0f;
    int arySize = mesuares.length;
    for(int i = 0; i < arySize; i++){
      sum += Math.abs(Math.pow(mesuares[i] - average, 2));
    }
    float detour = sum / arySize;
    return (float)Math.sqrt(detour);
  }

  private static void checkDetour(float detour, float average){
    if (detour > average * 0.1){
      System.out.println("Multimeter sucks.");
    }else{
      System.out.println("Multimeter is fine.");
    }
  }

  private static void readMesuares(float mesuares[]){
    System.out.println("Insert the mesuares: ");
    
    Scanner input = new Scanner(System.in);
    int arySize = mesuares.length;
    for(int i = 0; i < arySize; i++){
      mesuares[i] = input.nextFloat(); 
    }
    
    input.close();
  }

  private static float calcAverage(float mesuares[]){
    int sum = 0, arySize = mesuares.length;
    for (int i = 0; i < arySize; i++){
      sum += mesuares[i];
    }
    return (sum/arySize);
  }

  private static void printMesuares(float mesuares[]){
    int arySize = mesuares.length;
    for (int i = 0; i < arySize; i++){
      System.out.println("Mesuare #"+ (i+1) + " = " + mesuares[i]);
    }
  }
}