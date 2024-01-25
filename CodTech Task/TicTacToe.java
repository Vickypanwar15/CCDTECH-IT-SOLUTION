import java.util.Random;
import java.util.Scanner;


 class StartGame{
	 static char[][] board;
	 
	 public StartGame() {
		 board = new char[3][3];
		 initBoard();
	 }
	 // Intialize the board value 
	 void initBoard() {
		 for(int i=0;i<board.length;i++) {
			 for(int j =0;j<board[i].length;j++) {
				 board[i][j]=' ';
			 }
		 }
	 }
	 
	 // Display the board on the screen
	 
	static  void dispBoard() {
		 System.out.println("-------------");
		 for(int i=0;i<board.length;i++) {
			 System.out.print("| ");
			 for(int j=0;j<board[i].length;j++) {
				 System.out.print(board[i][j] + " | ");
			 }
			 System.out.println();
			 System.out.println("-------------");
		 }
	 }




//  To print value on the board
 
 	static void placeMark(int row,int col, char mark) {
 		if(row >=0 && row<=2 && col>=0 && col<=2)
 		board[row][col] = mark;
 		else {
 			System.out.println("Invalid Position");
 		}
 	}
 	
// 	 check column Winner
 	
 	static boolean checkColWin() {
		for(int j=0;j<=2;j++) {
 				if(board[0][j]!=' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j] ) {
 					return true;
 			}
 		}
		return false;
 	}
 	
// 	 check Row Winner
 	static boolean checkRowWin() {
 		 for(int i =0 ;i<= 2 ;i++) {
 			 if(board[i][0]!=' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
 				 return true;
 			 }
 		 }
 		 return false;
 	}
 
 	static boolean checkDiagWin() {
 		if(board[0][0]!=' '&& board[0][0]==board[1][1] && board[1][1] == board[2][2]  ||
 				board[0][2]!=' ' &&	board[0][2]==board[1][1] && board[1][1] == board[2][0]) {
 			return true;
 		}
 		else
 			return false;
 	}
 
   static boolean toCheckDraw() {
	   for(int i=0;i<=2;i++) {
		   for(int j=0;j<=2;j++) {
			   if(board[i][j]==' ') {
				   return false;
			   }
		   }
	   }
	   return true;
   }
 }
 
abstract  class Player{
	 String name;
	 char mark;
	 abstract void makeMove();
	 boolean isValidMove(int row,int col) {
		 if(row>=0 && row<=2 && col>=0 && col<=2) {
			 if(StartGame.board[row][col]==' ') {
				 return true;
			 }
		 }
		 return false;
	 }
 }
 
 
 class HumanPlayer extends Player
 {
	 
	 public HumanPlayer(String name, char mark) {
		 this.name = name;
		 this.mark = mark;
	 }
	 
	 void makeMove() {
		 Scanner sc = new Scanner(System.in);
		 int row,col;
		do {
			 System.out.println("Enter the row and column");
			  row = sc.nextInt();
			  col = sc.nextInt();
		} while (!isValidMove(row,col));
		 
		StartGame.placeMark(row, col, mark);
	 }
	 
 }
 
 
 class AIPlayer  extends Player{
	 
	 public AIPlayer(String name, char mark) {
		 this.name = name;
		 this.mark = mark;
	 }
	 
	 void makeMove() {
		 Scanner sc = new Scanner(System.in);
		 int row,col;
		do {
			Random r = new Random();
			row = r.nextInt(3);
			col = r.nextInt(3);
		} while (!isValidMove(row,col));
		 
		StartGame.placeMark(row, col, mark);
    }
	 }
 
public class TicTacToe {
	public static void main(String[] args) {
		StartGame t = new StartGame();
		Scanner sc = new Scanner(System.in);
		HumanPlayer p1 = new HumanPlayer("Vishal", 'X');
		HumanPlayer p2 = new HumanPlayer("DK", 'O');
		AIPlayer a1 = new AIPlayer("AI", 'O');
		
		Player cp; 
		cp=p1;
			
		System.out.println("Welcome, to the TICTACTOE game");
		StartGame.dispBoard();
		System.out.println("Play with Machine Press   : 1 ");
		System.out.println("Play Human Vs Human Press : 2");
		
		int play = sc.nextInt();
		
		switch (play) {
		case 1: {
			while(true) {
				System.out.println(cp.name +" Turn");
				cp.makeMove();
				StartGame.dispBoard();
				
				if(StartGame.checkColWin() || StartGame.checkRowWin() || StartGame.checkDiagWin()) {
					System.out.println(cp.name+" has won");
					break;
				}
				else if(StartGame.toCheckDraw()) {
					System.out.println("Game is Draw");
					break;
				}
				else {
					if(cp == p1) {
						cp = a1;
					}
					else {
						cp =p1;
					}
				}
			}
			break;
		}
		
		case 2:{
			while(true) {
				System.out.println(cp.name +" Turn");
				cp.makeMove();
				StartGame.dispBoard();
				
				if(StartGame.checkColWin() || StartGame.checkRowWin() || StartGame.checkDiagWin()) {
					System.out.println(cp.name+" has won");
					break;
				}
				else if(StartGame.toCheckDraw()) {
					System.out.println("Game is Draw");
					break;
				}
				else {
					if(cp == p1) {
						cp = p2;
					}
					else {
						cp =p1;
					}
				}
			}
			break;
		}
		default:
			System.out.println("Invalid Choice");
		}
		sc.close();
	}	
	
}
