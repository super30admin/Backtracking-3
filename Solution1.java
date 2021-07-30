// Time complexity: O(n!)
// Space complexity: O(n*n)

import java.util.*;

class Solution {
    boolean board[][]; 
    List<List<String>> output;
    public List<List<String>> solveNQueens(int n) {
        output = new ArrayList<>(); 
        if(n == 2 || n == 3) return output; 
        board = new boolean[n][n];
        helper(n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>()); 
        return output;
    }
    
    public void helper(int n, int row, Set<Integer> columnSet, Set<Integer> leftDiagonalSet, Set<Integer> rightDiagonalSet) {
        //base case
        if(n == row) {
            List<String> list = new ArrayList<>(); 
            for(int i=0; i<n; i++) {
                StringBuilder sb = new StringBuilder(); 
                for(int j=0; j<n; j++) {
                    if(board[i][j]) sb.append("Q");
                    else sb.append(".");
                }
                list.add(sb.toString());
            }
            output.add(list); 
            return; 
        }
        
        //logic
        for(int col = 0; col < n; col++) {            
            //left diagnoal
            int ld = row - col;
            //right diagnoal
            int rd = row + col; 
            //check if position is safe
            if(!columnSet.contains(col) && !leftDiagonalSet.contains(ld) && !rightDiagonalSet.contains(rd)) {
                //place queen
                board[row][col] = true;
                //update sets
                columnSet.add(col); 
                leftDiagonalSet.add(ld); 
                rightDiagonalSet.add(rd); 
                //recurse
                helper(n, row+1, columnSet, leftDiagonalSet, rightDiagonalSet);
                //backtrack
                columnSet.remove(col);
                leftDiagonalSet.remove(ld);
                rightDiagonalSet.remove(rd); 
                //remove queen
                board[row][col] = false;
            }
        }
        
    }
}