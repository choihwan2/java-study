package backjoon.algorithim.bruteforce;

import java.util.Arrays;

public class Test05 {
	public static void main(String[] args) {
		ChessBoard chessBoard = new ChessBoard();
		chessBoard.blackBoard(false);
		for (int i = 0; i < chessBoard.board.length; i++) {
			System.out.println(Arrays.toString(chessBoard.board[i]));
		}
	}
}

class ChessBoard{
	char[][] board;
	
	public ChessBoard() {
		this.board = new char[8][8];
	}
	
	public void blackBoard(boolean type) {
		boolean isBlack = type;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(isBlack) {
					board[i][j] = 'B';
					isBlack = !isBlack;
				}else {
					board[i][j] = 'W'; 
					isBlack = !isBlack;
				}
			}
			isBlack = !isBlack;
		}
	}
}
