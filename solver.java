public class Solution {

    int boardRows;
    int boardColumns;

    public boolean exist(char[][] board, String word) {
        boardRows = board.length;

        if (boardRows == 0 || board == null || word.isEmpty()) return false;

        boardColumns = board[0].length;

        for (int row = 0; row < boardRows; row++) {
            for (int col = 0; col < boardColumns; col++) {
                if (dfsSearch(board, word, row, col)) return true;
            }
        }

        return false;
    }

    private boolean dfsSearch(char[][] board, String word, int row, int col) {
        // Base case
        if (row < 0 || row >= boardRows || col < 0 || col >= boardColumns || board[row][col] == '#') 
            return false;

        // Logic
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        if (board[row][col] == word.charAt(0)) {
            if (word.length() == 1) return true;

            char tempChar = board[row][col];
            board[row][col] = '#'; 

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (dfsSearch(board, word.substring(1), newRow, newCol)) return true;
            }

            // Backtrack 
            board[row][col] = tempChar; 
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(solver.exist(board, word)); // Should print true
    }
}
