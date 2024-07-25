/*
TC --> O(3^n *m)
SC --> O(L)
 */
class Solution {

    int[][] directions;
    int ROW;
    int COL;

    public boolean exist(char[][] board, String word) {
        directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        ROW = board.length;
        COL = board[0].length;
        int k = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (board[i][j] == word.charAt(k)) {

                    if (dfs(board, word, i, j, k)) {
                        return true;
                    }
                    //System.out.print("Hi");

                }
            }
        }

        return false;

    }

    public boolean dfs(char[][] board, String word, int r, int c, int idx) {
        //base case
        if (idx == word.length()) {
            return true;
        }
        if (r < 0 || r >= ROW || c < 0 || c >= COL) {
            return false;
        }

        //logic
        if (word.charAt(idx) == board[r][c]) {
            char ch = board[r][c];
            board[r][c] = '$';
            //System.out.println(ch);
            for (int[] dir : directions) {
                int new_r = dir[0] + r;
                int new_c = dir[1] + c;

                if (dfs(board, word, new_r, new_c, idx + 1)) {
                    return true;
                }

            }//for
            board[r][c] = ch;

        }//if

        return false;

    }//method

}//class
