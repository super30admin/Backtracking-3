// Time complexity is O(n!)
// Space is n^2 i.e n*n for using the board
// this solution is submitted on leetcode

import java.util.ArrayList;
import java.util.List;

public class BigN72QueensWithoutDirectionArray {
	    List<List<String>> result = new ArrayList<>();
	    public List<List<String>> solveNQueens(int n) {
	        // edge case
	        if(n ==0)
	            return result;
	        int [][] board = new int[n][n];
	        placeQueen(board,0,n);
	        return result;
	    }
	    // n is size of row and column
	    private void placeQueen(int [][] board, int row, int n){
	        //base case
	        if(row==n){
	            List<String> temp = new ArrayList<>();
	            for(int i = 0; i<n;i++){
	                StringBuilder sb = new StringBuilder();
	                for(int j = 0;j<n;j++){
	                    if(board[i][j]==1)
	                        sb.append("Q");
	                    else
	                        sb.append(".");
	                    }
	                temp.add(sb.toString());
	                }
	            result.add(temp);
	            return;
	        }
	        //logic
	        for(int j = 0;j<n;j++){ // column interation
	            if(isSafe(board,row,j,n)){
	                board[row][j]=1;
	                placeQueen(board,row+1,n);
	                // back track
	                board[row][j]=0;
	            }
	        }
	    }
	    
	    private boolean isSafe(int [][]board, int r, int j, int n){
	        //column check
	        for(int i = 0; i<r;i++){// till row iterate
	            if(board[i][j]==1)
	                return false;
	        }
	        // diagonal up left
	        int x = r-1;
	        int y = j-1;
	        while(x>=0 && y>=0){
	            if(board[x][y]==1){
	                return false;
	            }
	            else{
	               x--;
	                y--;  
	            }         
	        }
	        // diagonal up right
	        x = r-1;
	        y = j+1;
	        while(x>=0 && y<n){
	            if(board[x][y]==1){
	                return false;
	            }
	            else{
	                x--;
	                y++; 
	            }
	        }
	        return true;        
	    }
	}