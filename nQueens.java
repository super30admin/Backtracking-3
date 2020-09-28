// TC: O(N!) where N is number of rows
// SC : O(N) since we are using board

// creating a square board and checking if it is safe to place the queen in every row. if the queen is not safe, we will backtrack and check for other combinations and places in a row.
// To check for safe of a queen, we need to check the row if the queen is already placed and check the previous rows, queen in same column, and previous row, column and previous row and next column

import java.util.*;

public class nQueens {
	
	int m;
	List<List<String>> res;
	int[][] board;
	public List<List<String>> solveNQueens(int n){
		
		m = n;
		res = new ArrayList<>();
		board = new int[n][n];
		backTrack(0);
		return res;
	}
	
	public void backTrack(int r) {
		
		if(r == m) {
			List<String> list = new ArrayList();
			for(int i = 0; i < m; i++) {
				StringBuilder sb = new StringBuilder();
				for(int j = 0; j < m; j++) {
					if(board[i][j]==1){
						sb.append("Q");
					}else {
						sb.append(".");
					}
				}
				list.add(sb.toString());
			}
			res.add(list);
		}
		
		
		for(int j = 0 ;j<m ;j++) {
			if(isSafe(r, j)) {
				board[r][j] = 1;
				backTrack(r+1);
				board[r][j]=0;
			}
		}
	}
	
	public boolean isSafe(int i, int j) {
		
		for(int r = 0; r < i; r++) {
			if(board[r][j]==1)
				return false;
		}
		
		int r = i-1;
		int c = j-1;
		
		while(r >= 0 && c >=0) {
			if(board[r--][c--]==1)
				return false;
		}
		
		r = i-1;
		c = j+1;
		
		while(r >=0 && c < m) {
			if(board[r--][c++]==1)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		nQueens nq = new nQueens();
		System.out.println(nq.solveNQueens(4));
	}

}
