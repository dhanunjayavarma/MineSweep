package board;
import java.util.ArrayList;
import java.util.Random;

public class Board {
	public Square[][] squareArray;
	int NoOfMines;
	public Board() {
		squareArray=new Square[3][3];
	}
	public ArrayList<Square> getNeighbourSquares(){
		return null;
	}
	public int getNoOfMines() {
		return NoOfMines;
	}
	public void boardSetUp() {
		createBoardWithSquares();
		setUpMinesInTheBoard();
		//printBoard();
		setMineNeighBourValues();
		printBoard();
	}
	public void createBoardWithSquares() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				squareArray[i][j]=new Square();
			}
		}
	}
	public void setUpMinesInTheBoard() {
		Random random=new Random();
		int lowNoOfMines=2;
		int highNoOfMines=3;
		NoOfMines=random.nextInt(highNoOfMines-lowNoOfMines)+lowNoOfMines;
		int i=0;
		while(i<NoOfMines) {
			int a=random.nextInt(3);
			int b=random.nextInt(3);
			//9 represents the mine
			if(squareArray[a][b].getValue()==-1) {
				squareArray[a][b].setValue(9);
				i++;
			}
		}
	}
	public void printBoard() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(squareArray[i][j].getValue()+"   ");
			}
			System.out.println();
		}
	}
	public void setMineNeighBourValues() {
		int count=0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
					if(squareArray[i][j].getValue()!=9) {
						if(!( (j-1) <0)) {
							if( squareArray[i][j-1].getValue()==9) {
								count++;
							}
						}
						if(!( (j+1) >2)) {
							if(squareArray[i][j+1].getValue()==9) {
								count++;
							}
						}
						if(!( (i-1) <0)) {
							if( squareArray[i-1][j].getValue()==9) {
								count++;
							}
						}
						if(!( (i+1) >2)) {
							if(squareArray[i+1][j].getValue()==9) {
								count++;
							}
						}
						if( !( (i-1)<0) && !((j-1)<0)) {
							if(squareArray[i-1][j-1].getValue()==9) {
								count++;
							}
						}
						if( !((i+1)>2) && !((j+1)>2)) {
							if(squareArray[i+1][j+1].getValue()==9) {
								count++;
							}
						}
						if(!((i-1)<0)&&!((j+1)>2)) {
							if(squareArray[i-1][j+1].getValue()==9) {
								count++;
							}
						}
						if(!((i+1)>2) && !((j-1)<0)) {
							if(squareArray[i+1][j-1].getValue()==9) {
								count++;
							}
						}
						squareArray[i][j].setValue(count);
						count=0;
					}
				}
		}
	}
}
