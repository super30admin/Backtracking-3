//tc : O(n!) as we have one choice for every row
//sc : O(n*n) for the maze 
// run successfull on leetcode
//no problems

//iterate through row by row and check if that location is valid

class Solution {
    List<List<String>> ans;
    boolean[][] maze;
    int size;

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        if (n == 0)
            return ans;
        size = n;
        maze = new boolean[size][size];
        helper(0);
        return ans;
    }

    private void helper(int row) {
        // base case
        if (row == size) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < size; j++) {
                    if (maze[i][j])
                        sb.append('Q');
                    else
                        sb.append('.');
                }
                list.add(sb.toString());
            }
            ans.add(new ArrayList(list));
        }
        // logic
        for (int i = 0; i < size; i++) {
            if (isSafe(row, i)) {
                // action
                maze[row][i] = true;
                // recurse
                helper(row + 1);
                // backtrack
                maze[row][i] = false;
            }
        }
    }

    private boolean isSafe(int row, int col) {
        // checking on top
        for (int i = row - 1; i >= 0; i--) {
            if (maze[i][col])
                return false;
        }
        int i = row - 1;
        int j = col - 1;
        // checking left diagonal
        while (i >= 0 && j >= 0) {
            if (maze[i--][j--])
                return false;
        }
        // checking right diagonal
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < size) {
            if (maze[i--][j++])
                return false;
        }
        return true;
    }
}
