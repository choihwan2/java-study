package baekjoon.algorithm.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[][] testBoard;
		int x, y;
		x = scanner.nextInt();
		y = scanner.nextInt();
		scanner.nextLine();
		testBoard = new char[x][y];
		for (int i = 0; i < testBoard.length; i++) {
			testBoard[i] = scanner.nextLine().toCharArray();
		}

		ChessBoard whiteBoard = new ChessBoard();
		ChessBoard blackBoard = new ChessBoard();
		whiteBoard.makeBoard(false);
		blackBoard.makeBoard(true);
		
		int white_answer = 0;
		int black_answer = 0;
		
		Math.min(white_answer, black_answer);
		
	}

	public static int compareBoard(char[][] board, char[][] chess) {
		int answer = 0;
		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess.length; j++) {
				if (board[i][j] != chess[i][j]) {
					answer++;
				}
			}
		}

		return answer;
	}
}

class ChessBoard {
	char[][] board;

	public ChessBoard() {
		this.board = new char[8][8];
	}

	public void makeBoard(boolean type) { // true 면 검은색 false 면 흰색
		boolean isBlack = type;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (isBlack) {
					board[i][j] = 'B';
					isBlack = !isBlack;
				} else {
					board[i][j] = 'W';
					isBlack = !isBlack;
				}
			}
			isBlack = !isBlack;
		}
	}
}
