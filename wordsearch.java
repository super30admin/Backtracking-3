
// Time Complexity : O(m * n * 4^L) where m and n are the dimensions of the board and L is the length of the word. In the worst case, we might have to explore all possible paths from each cell.
// Space Complexity : O(L) for the recursion stack and the visited set, where L is the length of the word.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// The approach is to use Depth First Search (DFS) to explore all possible paths in the board to find the given word.
// We start from each cell in the board and check if it matches the first character of the word.
//  If it does, we initiate a DFS from that cell, exploring all four possible directions (up, down, left, right) to find the next character in the word. 
// We keep track of visited cells to avoid revisiting them in the same path but backtrack by unmarking them after exploring all possibilities from that cell.
//  If we successfully match all characters of the word, we return true.
//  If we exhaust all possibilities without finding the word, we return false.

import java.util.*;

class Solution {

    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        HashSet<String> visited = new HashSet<>();

        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {

                if (dfs(r, c, 0, board, word, visited)) {
                    return true;
                }
            }
        }

        return false;
    }


    private boolean dfs(int row, int col, int index,
                        char[][] board,
                        String word,
                        HashSet<String> visited) {

        int R = board.length;
        int C = board[0].length;

        // Entire word matched
        if (index == word.length()) {
            return true;
        }


        // Invalid cell
        if (row < 0 || col < 0 ||
            row >= R || col >= C ||
            board[row][col] != word.charAt(index) ||
            visited.contains(row + "," + col)) {

            return false;
        }


        // Mark visited
        visited.add(row + "," + col);


        boolean found =
                dfs(row + 1, col, index + 1, board, word, visited) ||
                dfs(row - 1, col, index + 1, board, word, visited) ||
                dfs(row, col + 1, index + 1, board, word, visited) ||
                dfs(row, col - 1, index + 1, board, word, visited);


        // Backtrack
        visited.remove(row + "," + col);


        return found;
    }
}