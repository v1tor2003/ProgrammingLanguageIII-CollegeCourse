import java.util.Scanner;

public class BattleShip{
  public static void main(String[]args){
    Scanner input = new Scanner(System.in);
    int playerTurn = 1;
    int playerHits[] = new int[2];
    final int winScore = 5;
    final int size = 5;
    char player1Array[][] = new char[size][size];
    char player2Array[][] = new char[size][size];
    char history1Array[][] = new char[size][size];
    char history2Array[][] = new char[size][size];

    //initializing and showing players arrays
    initializePlayerArray(player1Array, size);
    initializePlayerArray(player2Array, size);
    initializePlayerArray(history1Array, size);
    initializePlayerArray(history2Array, size);
    
    readShipsCoordinates(player1Array, size, playerTurn, input);
    showPlayerArray(player1Array, size);
    readShipsCoordinates(player2Array, size, playerTurn+1, input);
    showPlayerArray(player2Array, size);

    while(true){
      int playerId = playerTurn;

      if(playerTurn == 1){
        shoot(playerHits, history1Array, player2Array, playerId, input, size);
        playerTurn++;//playerTurn2
      }else if (playerTurn == 2){
        shoot(playerHits, history2Array, player1Array, playerId, input, size);
        playerTurn--;//playerTurn = 1
      }
      
      if(checkWinner(playerHits[playerId-1], winScore)){
        System.out.println("PLAYER  "+playerId+"  WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
        System.out.println("\nFinal Boards:\n");
        showPlayerArray(player1Array, size);
        showPlayerArray(player2Array, size);
        break;
      }
    }
    input.close();
  }

  private static boolean validateInput(int row, int column){
    if((row >= 0 && row <= 4) && (column >= 0 && column <= 4)){
      return true;
    }else{
      return false;
    }
  }

  private static void readShipsCoordinates(char playerArray[][], int size, int playerId, Scanner input){
    System.out.println("PLAYER "+ playerId + ", ENTER  YOUR  SHIP'S COORDINATES.");
    
    int i = 0;
    int row, column;

    while (i < size){
      System.out.println("Enter ship "+ (i+1)+ " location:");
      row = input.nextInt();
      column = input.nextInt();
      
      if(validateInput(row, column)){
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

  private static void shoot(int playerHits[], char historyArray[][], char playerArray[][], int playerId, Scanner input, int size){
    int row, column, opponent = 0, index = playerId - 1;
    
    if(playerId == 1){
      opponent = 2;
    }else{
      opponent = 1;
    }

    System.out.println("Player "+ playerId + ",  enter hit row/column:");
   
    while (true){
      row = input.nextInt();
      column = input.nextInt();
      
      if(validateInput(row, column)){
        if(playerArray[row][column] != 'O' && playerArray[row][column] != 'X'){
          if(playerArray[row][column] == '@'){
            playerArray[row][column] = 'X';
            historyArray[row][column] = 'X';
            playerHits[index] += 1;
            System.out.println("\nPLAYER  "+playerId+"  HIT PLAYER  "+opponent+"'s  SHIP!\n");
          }else if (playerArray[row][column] == '-'){
            playerArray[row][column] = 'O';
            historyArray[row][column] = 'O';
            System.out.println("\nPLAYER  "+playerId+"  MISSED!\n");
          }
          showPlayerArray(historyArray, size);
          break;
        }else{
          System.out.println("You already fired on this spot. Choose different coordinates.");
        } 
      }else {
        System.out.println("Invalid coordinates. Choose different coordinates.");
      }
    }
  }
  
  private static boolean checkWinner(int killedShips, int winScore){
    if(killedShips == winScore){
      return true;
    }
    return false;
  }

  private static void showPlayerArray(char playerArray[][], int size){
    int i = 0;
    
    System.out.print("  ");
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