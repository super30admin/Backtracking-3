import java.util.*;
//Time Complexity : O(N!)
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Your code here along with comments explaining your approach
/*
 * Backtracking Approach is used for exploring all possibilities for placing the queens.
 * We discussed following possibilitis for placeing the queen in any position 
 * 	1. Queen Placed in First/Last Row/Columns
 * 		If we place queen in first/last row/column then we check for immediate row/column,bottom row/column for other queens.
 * 	if we found any queen then position is not marked safe 
 *  2. Quuen placed in middle row/column
 *  	In this case we check for upper left,upper right diagonal,bottom right,position
 *  	cells for safe position,if we found any queen then position is not marked safe.Although 
 * */
public class NQueens {
	public List<List<String>> list = new ArrayList<>();

	public List<List<String>> solveNQueens(int n) {
		int board[][] = new int[n][n];
		placeNQueen(board, 0, n);
		return list;
	}

	void placeNQueen(int board[][], int row, int n) {
		if (row == n) {
			List<String> li = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < n; j++) {
					if (board[i][j] == 1)
						sb.append("Q");
					else
						sb.append(".");
				}
				li.add(sb.toString());
			}
			list.add(li);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (isSafe(board, row, i, n)) {
				board[row][i] = 1;
				placeNQueen(board, row + 1, n);
				board[row][i] = 0;
			}
		}
	}

	boolean isSafe(int board[][], int row, int j, int n) {
		// Same Row
		for (int k = 0; k < row; k++) {
			if (board[k][j] == 1)
				return false;
		}
		// Diagonal upleft
		int x = row - 1;
		int y = j - 1;
		while (x >= 0 && y >= 0) {
			if (board[x][y] == 1)
				return false;
			x--;
			y--;
		}
		// Diagonal upright
		x = row - 1;
		y = j + 1;
		while (x >= 0 && y < n) {
			if (board[x][y] == 1)
				return false;
			x--;
			y++;
		}
		return true;
	}

	public static void main(String[] args) {
		NQueens queens = new NQueens();
		int n = 4;
		System.out.println(queens.solveNQueens(n));
	}
}