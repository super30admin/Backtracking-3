// Time Complexity : O(n! + V*n^2) where n is matrix size and V is possible ways to place queen
// Space Complexity : O(n^2 + 3*n) where n is row*col of board matrix and also 3 extra hashsets
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

class Solution {
    
    private List<List<String>> result;
    
    private boolean[][] board;
    
    private Set<Integer> colSet, leftUpperDiagSet, rightUpperDiagSet;
    
    public List<List<String>> solveNQueens(int n) {
        
        colSet = new HashSet<>();
        leftUpperDiagSet = new HashSet<>();
        rightUpperDiagSet = new HashSet<>();
        
        result = new ArrayList<>();
        board = new boolean[n][n]; //true => there is queen   
        
        solveQueens(board, 0);
        
        return result;
    }
    
    private void solveQueens(boolean[][] board, int row) {
        //base
        if (row == board.length) {
            List<String> out = new ArrayList<>();
            
            for (int i = 0; i < board.length; i++) {
                StringBuilder sb = new StringBuilder();
                
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j]) {
                        sb.append('Q');
                    }
                    else {
                        sb.append('.');
                    }
                }
                out.add(sb.toString());
            }
            result.add(out);
            return;
        }
        
        //recurse
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                
                //placing queen
                board[row][col] = true;
                colSet.add(col);
                leftUpperDiagSet.add(row-col);
                rightUpperDiagSet.add(row+col);
                
                solveQueens(board, row+1);
                
                //remove queen (backtrack)
                board[row][col] = false;
                colSet.remove(col);
                leftUpperDiagSet.remove(row-col);
                rightUpperDiagSet.remove(row+col);
            }
        }
    }
    
    private boolean isSafe(boolean[][] board, int row, int col) {
        
        return  isSafeColumn(board, row, col) 
                        && 
                isSafeLeftUpperDiag(board, row, col)
                        &&
                isSafeRightUpperDiag(board, row, col);
    }
    
    private boolean isSafeColumn(boolean[][] board, int row, int col) {
        return !colSet.contains(col); 
    }
    
    private boolean isSafeLeftUpperDiag(boolean[][] board, int row, int col) {
        return !leftUpperDiagSet.contains(row-col);
    }
    
    private boolean isSafeRightUpperDiag(boolean[][] board, int row, int col) {
        return !rightUpperDiagSet.contains(row+col);
    }
    
//     private boolean isSafeColumn(boolean[][] board, int row, int col) {
//         for (int i = row-1; i >= 0; i--) {
//             if (board[i][col]) {
//                 return false; // there is a queen, not safe
//             }
//         }
//         return true;
//     }
    
//     private boolean isSafeLeftUpperDiag(boolean[][] board, int row, int col) {
//         int i = row-1;
//         int j = col-1;
        
//         while (i >= 0 && j >= 0) {
//             if (board[i][j]) {
//                 return false; // there is a queen, not safe
//             }
            
//             i--;
//             j--;
//         }
//         return true;
//     }
    
//     private boolean isSafeRightUpperDiag(boolean[][] board, int row, int col) {
//         int i = row-1;
//         int j = col+1;
        
//         while (i >= 0 && j < board.length) {
//             if (board[i][j]) {
//                 return false; // there is a queen, not safe
//             }
            
//             i--;
//             j++;
//         }
        
//         return true;
//     }
    
    
}