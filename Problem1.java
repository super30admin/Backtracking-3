import java.util.ArrayList;
import java.util.List;
/*
N-Queens
approach: dfs with backtracking
time: O(nxn)
space: O(nxn)
 */
public class Problem1 {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();

        if(n<=0) return res;
        boolean[][] board = new boolean[n][n];
        dfs(0, board);
        return res;
    }

    private void dfs(int r, boolean[][] board) {
        if(r==board.length) {
            List<String> li = new ArrayList<>();
            for(int i=0;i<board.length;i++) {
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<board[0].length;j++) {
                    if(board[i][j]) {
                        sb.append("Q");
                    }
                    else {
                        sb.append(".");
                    }
                }
                li.add(sb.toString());
            }
            res.add(li);
        }
        for (int j = 0; j < board.length; j++) {
            if (isSafe(r, j, board)) {
                board[r][j] = true;
                dfs(r + 1, board);
                board[r][j] = false;
            }
        }
    }

    private boolean isSafe(int r, int c, boolean[][] board) {

        for(int i=0;i<r;i++) {
            if(board[i][c]) return false;
        }

        int i=r, j=c;
        while(i>=0 && j>=0) {
            if(board[i--][j--]) return false;
        }

        i = r; j=c;
        while(i>=0 && j<board.length) {
            if(board[i--][j++]) return false;
        }
        return true;

    }

    public static void main(String []args) {
        Problem1 problem1 = new Problem1();
        problem1.solveNQueens(4);
    }
}
