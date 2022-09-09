package CrapsGame;
public class Craps{
  public static void main(String[] args){
    int cubes[] = new int[2];
    readCubes(cubes);
    firstTurn(cubes); 
  }

  private static void firstTurn(int cubes[]){
    int sum = sumCubes(cubes);
    checkCubesSum(sum);
    secondTurn(cubes, sum);
  }

  private static int sumCubes(int cubes[]){
    int result = 0;
    for (int i = 0; i < cubes.length; i++){
      result += cubes[i];
    }
    return result;
  }

  private static void checkCubesSum(int sum){
    if(sum == 7 || sum == 11){
      System.out.println("Vc ganhou :-)");
      System.exit(0);
    }else if (sum == 2 || sum == 3 || sum == 12){
      System.out.println("Vc perdeu :-(");
      System.exit(0);
    }
  }

  private static void secondTurn(int cubes[], int point){    
    System.out.println("Ponto: " + point);
    System.out.println("Iniciando estagio 2...");
    int turn = 0;
    while(true){
      readCubes(cubes);
      turn = countTurns(turn);
      int sum = sumCubes(cubes);
      System.out.println("Jogada "+turn + " : " + sum);
      if(sum == 7){
        System.out.println("Vc perdeu :-(");
        System.exit(0);
      }else if (sum == point){
        System.out.println("Vc ganhou :-)");
        System.exit(0);
      }
    }
  }

  private static int countTurns(int turn){
    return turn += 1;
  }

  private static void readCubes(int cubes[]){
    final int min = 1;
    final int max = 6;
    for(int i = 0; i < cubes.length; i++){
      cubes[i] = (int)Math.floor(Math.random()*(max-min+1)+min);
    }
    System.out.println("Dado 1: "+ cubes[0] + ", Dado 2: "+cubes[1]);
  }

  
}