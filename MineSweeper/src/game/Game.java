package game;

import java.util.Scanner;

import board.Board;

public class Game {
	Board board;
	Board dummyBoard;
	Scanner scanner=new Scanner(System.in);
	public Game(){
		board=new Board();
		board.boardSetUp();
	}
	public void startGame() {
		dummyBoard=new Board();
		dummyBoard.createBoardWithSquares();
		
		int noOfUnrevealedSquares=9-board.getNoOfMines();
		int noOfrevealedSquares=0;
		// substracting 9 because 3*3 array have 9 postions
		while(true) {
			if(noOfUnrevealedSquares==noOfrevealedSquares) {
				winGame();
				board.printBoard();
				break;
			}
			else {
				System.out.println("Enter the position you want to reveal it");
				dummyBoard.printBoard();
				int a=Integer.parseInt(scanner.next());
				int b=Integer.parseInt(scanner.next());
				if( (!(a<0)&& !(b>2)) || (!(b<0)&&!(a>2))) {
					if(board.squareArray[a][b].getValue()==9) {
						youLostTheGame();
						board.printBoard();
						break;
					}
					else if(board.squareArray[a][b].getValue()!=0) {
						dummyBoard.squareArray[a][b].setValue(board.squareArray[a][b].getValue());	
						noOfrevealedSquares++;
						dummyBoard.printBoard();
					}
					else {
						dummyBoard.squareArray[a][b].setValue(board.squareArray[a][b].getValue());
						noOfrevealedSquares++;
						if(!( (b-1) <0)) {
							dummyBoard.squareArray[a][b-1].setValue(board.squareArray[a][b-1].getValue());	
							noOfrevealedSquares++;
						}
						if(!( (b+1) >2)) {
							dummyBoard.squareArray[a][b+1].setValue(board.squareArray[a][b+1].getValue());	
							noOfrevealedSquares++;
						}
						if(!( (a-1) <0)) {
							dummyBoard.squareArray[a-1][b].setValue(board.squareArray[a-1][b].getValue());	
							noOfrevealedSquares++;
						}
						if(!( (a+1) >2)) {
							dummyBoard.squareArray[a+1][b].setValue(board.squareArray[a+1][b].getValue());	
							noOfrevealedSquares++;
						}
						if( !( (a-1)<0) && !((b-1)<0)) {
							dummyBoard.squareArray[a-1][b-1].setValue(board.squareArray[a-1][b-1].getValue());	
							noOfrevealedSquares++;
						}
						if( !((a+1)>2) && !((b+1)>2)) {
							dummyBoard.squareArray[a+1][b+1].setValue(board.squareArray[a+1][b+1].getValue());	
							noOfrevealedSquares++;
						}
						if(!((a-1)<0)&&!((b+1)>2)) {
							dummyBoard.squareArray[a-1][b+1].setValue(board.squareArray[a-1][b+1].getValue());
							noOfrevealedSquares++;
						}
						if(!((a+1)>2) && !((b-1)<0)) {
							dummyBoard.squareArray[a+1][b-1].setValue(board.squareArray[a+1][b-1].getValue());	
							noOfrevealedSquares++;
						}
						dummyBoard.printBoard();
					}
				}
				else {
					System.out.println("invalid selection"+"\n"+"select again");
				}
				
			}
		}
		
		
	}
	void winGame() {
		System.out.println("YOU WON THE GAME");
	}
	void youLostTheGame() {
		System.out.println("YOU LOST THE GAME");
	}
}

