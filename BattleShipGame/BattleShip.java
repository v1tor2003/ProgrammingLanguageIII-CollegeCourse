import java.util.Scanner;

public class BattleShip{
  public static void main(String[]args){
    char player1Array[][] = new char[5][5];
    char player2Array[][] = new char[5][5];
    int size = player1Array.length;
    initializePlayerArray(player1Array, size);
    initializePlayerArray(player2Array, size);
    
    readShipsCoordinates(player1Array, size, 1);
    showPlayerArray(player1Array, size);
    readShipsCoordinates(player2Array, size, 2);
    
    //showPlayerTurn(true)
    showPlayerArray(player2Array, size);
  }

  private static boolean validateShipsInput(int row, int column){
    if((row >= 0 && row <= 4) && (column >= 0 && column <= 4)){
      return true;
    }else{
      return false;
    }
  }

  private static void readShipsCoordinates(char playerArray[][], int size, int playerId){
    System.out.println("PLAYER "+ playerId + " , ENTER  YOUR  SHIP'S COORDINATES.");
    Scanner input = new Scanner(System.in);
    int i = 0;
    int row, column;

    while (i < size){
      System.out.println("Enter ship "+ (i+1)+ " location:");
      row = input.nextInt();
      column = input.nextInt();
      System.out.println(row + " " + column);
      
      if(validateShipsInput(row, column)){
        if(playerArray[row][column] != '@'){
          playerArray[row][column] = '@';
          i++;
        }else{
          System.out.println("You already have a ship there. Choose different coordinates.");
        }
      }else {
        System.out.println("Invalid coordinates. Choose different coordinates.");
      }
    }
  }

  private static void initializePlayerArray(char playerArray[][], int size){
    for(int i = 0; i < size; i++){
      for(int j = 0; j < size; j++){
        playerArray[i][j] = '-'; 
      }
    }
  }

  private static void showPlayerArray(char playerArray[][], int size){
    int i = 0;
    
    System.out.println("  ");
    for(i = 0; i < size; i++){
      System.out.print(i + " ");
    }
    System.out.println("");
    
    for(i = 0; i < size; i++){
      System.out.print(i + " ");
      for(int j = 0; j < size; j++){
        if(j == size - 1){
          System.out.println(playerArray[i][j]); 
        }
        else{
          System.out.print(playerArray[i][j] + " "); 
        }
      }
    }
    System.out.println("");
  }
}