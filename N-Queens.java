//O(N!) time: we only consider spaces where queen is not under attack and for each queen placed, the number of considered spots decrease by 1
// O(N^2) space to maintain board state of NxN, recursion stack also N

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    private int size;
    private List<List<String>> solutions = new ArrayList<List<String>>();
    
    public List<List<String>> solveNQueens(int n) {
        size = n;
        char emptyBoard[][] = new char[size][size];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                emptyBoard[i][j] = '.';
            }
        }
        
        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), emptyBoard);
        return solutions;
    }
    
    private List<String> createBoard(char[][] state){
        List<String> board = new ArrayList<String>();
        for (int row = 0; row < size; row++){
            String currentRow = new String(state[row]);
            board.add(currentRow);
        }
        return board;
    }
    
    private void backtrack(int row, Set<Integer> diagonals, Set<Integer> antiDiag, Set<Integer> cols, char[][] state){
        // base case: N queens have been placed
        if (row == size){
            solutions.add(createBoard(state));
            return;
        }
        
        for (int col = 0; col < size; col++){
            int currDiag = row - col;
            int currAntiDiag = row + col;
            if (cols.contains(col) || diagonals.contains(currDiag) || antiDiag.contains(currAntiDiag)){
                continue;
            }
            
            // add queen on board
            cols.add(col);
            diagonals.add(currDiag);
            antiDiag.add(currAntiDiag);
            state[row][col] = 'Q';
                
            // move on to next row
            backtrack(row + 1, diagonals, antiDiag, cols, state);
            
            // remove queen after exploring all valid paths
            cols.remove(col);
            diagonals.remove(currDiag);
            antiDiag.remove(currAntiDiag);
            state[row][col] = '.';
        }
    }
}