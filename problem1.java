import java.util.ArrayList;
import java.util.List;

public class problem1 {
// Time Complexity: O(n!)
// Space Complexity: O(n)

    List<List<String>> result;
    boolean[][] board;

    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<List<String>>();
        this.board = new boolean[n][n];
        helper(0, n); //0,4
        return this.result;
    }

    private void helper(int row, int n) {
        // base case
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (board[i][j]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }

        //logic
        for (int j = 0; j < n; j++) {
            if(isSafe(board, row, j, n))
            {
                board[row][j] = true;
                helper(row + 1, n);
                board[row][j] = false;
            }
        }

    }

    private boolean isSafe(boolean[][] board, int i, int j, int n)
    {
        int row = i, col=j;
        while (row >= 0 )
        {
            if (board[row][col]){ // queen is present at that position
                return false;
            }
            row--;
        }
        //diagnol left;
        row=i; col=j;
        while (row >= 0  && col<n)
        {
            if (board[row][col]){return false;}
            row--; col++;
        }
        return true;


    }
}
