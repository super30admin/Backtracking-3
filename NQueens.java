import java.util.*;

//TC: N! - Each row it will decrease by one. Which is n-1, n-2, n-3 and so on.
//SC: O(N(2)) - For the recursive stack
public class NQueens { 
    private List<List<String>> result2;

    public List<List<String>> solveNQueens2(int n) {
        result2 = new ArrayList();
        if (n == 0)
            return result2;
        int[][] board = new int[n][n];
        helper2(board, 0, 0);
        return result2;
    }

    private void helper2(int[][] board,  int rowIndex, int columnIndex) {
        // Base
        if(rowIndex == board.length) {
            //Valid One
            List<String> list = new ArrayList();
            for(int i=0;i<board.length;i++) {
                StringBuilder builder = new StringBuilder();
                for(int j=0;j<board[0].length;j++) {
                    if(board[i][j] == 1) {
                        builder.append('Q');
                    } else {
                        builder.append('.');
                    }
                }
                list.add(builder.toString());  
            }
            result2.add(list);
            return;
        }
       
        for (int c = 0; c < board[0].length; c++) {
            if(isValid2(board, rowIndex, c )) {
                board[rowIndex][c] = 1;
                helper2(board, rowIndex+1, c);
                board[rowIndex][c] = 0;
            } 
        }
       
    }

    private boolean isValid2(int[][] board, int currentRow, int currentColumn) {
        //Up
        for(int row=0;row<board.length;row++) {
            if(row!=currentRow && board[row][currentColumn] == 1) {
                return false;
            }
        }
        //Diagnal Left

        int i = currentRow;
        int j = currentColumn;
        while(j>=0 && i>=0) {
            if(currentRow != i && board[i][j] == 1) {
                return false;
            }
            i--;
            j--;
        }

        //Diagnal Right
        i = currentRow;
        j = currentColumn;
        while(i>=0 && j<board[0].length) {
            if(currentRow != i  && board[i][j] == 1) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        List<List<String>> result = nQueens.solveNQueens2(4);
        System.out.println(result);
    }

}
