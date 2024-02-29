import java.util.ArrayList;
import java.util.List;

// TC - O(N^N) => Each cell has N to choose from next row
// SC - O(N) => Stack space of number of rows

public class NQueen {

    class Solution {
        private List<List<String>> result;
        private boolean[][] board;

        public List<List<String>> solveNQueens(int size) {
            result = new ArrayList<>();
            board = new boolean[size][size];
            placeQueens(0, size);
            return result;
        }

        private void placeQueens(int row, int size) {
            if (row == size) {
                List<String> boardRowList = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    StringBuilder rowBuilder = new StringBuilder();
                    for (int j = 0; j < size; j++) {
                        if (board[i][j]) {
                            rowBuilder.append("Q");
                        } else {
                            rowBuilder.append(".");
                        }
                    }
                    boardRowList.add(rowBuilder.toString());
                }
                result.add(boardRowList);
                return;
            }

            for (int col = 0; col < size; col++) { // Check each col possibility
                if (isSafe(row, col, size)) {
                    board[row][col] = true; // Action
                    placeQueens(row + 1, size); // Recurse
                    board[row][col] = false; // Backtrack
                }
            }
        }

        private boolean isSafe(int row, int col, int size) {
            int r = row;
            int c = col;
            while (r >= 0) { // Col Up
                if (board[r][col]) {
                    return false;
                }
                r--;
            }

            r = row;
            c = col;
            while (r >= 0 && c >= 0) { // Left Diagonal Up
                if (board[r][c]) {
                    return false;
                }
                r--;
                c--;
            }

            r = row;
            c = col;
            while (r >= 0 && c < size) { // Right Diagonal Up
                if (board[r][c]) {
                    return false;
                }
                r--;
                c++;
            }

            return true;
        }
    }
}