//tc : O(m*n*3^len(string))
//sc : O(n*n)
//run successfully 
//no problem

//perform backtracking from the matching letters point 
//in the entire matrix from the previous unread point

class Solution {
    boolean[][] maze;
    int size, n;
    String search;
    int[][] dirs = {
            { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }
    };
    char[][] grid;

    public boolean exist(char[][] board, String word) {
        size = board.length;
        if (size == 0)
            return false;
        n = board[0].length;
        search = word;
        maze = new boolean[size][n];
        grid = board;
        // base case
        if (word.length() == 0)
            return true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(i, j, 0))
                    return true;
            }
        }
        return false;

    }

    private boolean helper(int row, int col, int ind) {
        // base case

        // logic
        if (grid[row][col] == search.charAt(ind) && !maze[row][col]) {
            // System.out.println(ind);
            if ((ind + 1) == search.length())
                return true;
            maze[row][col] = true;
            for (int[] dir : dirs) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r < size && r >= 0 && c >= 0 && c < n) {
                    if (helper(r, c, ind + 1))
                        return true;
                }
            }
            maze[row][col] = false;
        }
        return false;
    }
}