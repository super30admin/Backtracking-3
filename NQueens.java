//Time complexity is O(N)
//Space complexity is O(N^2)
class Solution {
    private int size;
    private List<List<String>> solutions = new ArrayList<List<String>>();
    
    public List<List<String>> solveNQueens(int n) {
        size = n;
        char board[][] = new char[size][size];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        helper(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), board);
        return solutions;
    }
    
    private List<String> createBoard(char[][] state) {
        List<String> board = new ArrayList<String>();
        for (int row = 0; row < size; row++) {
            String current_row = new String(state[row]);
            board.add(current_row);
        }
        
        return board;
    }
    
    private void helper(int row, Set<Integer> diagonals, Set<Integer> antiDiagonals, Set<Integer> cols, char[][] state) {
        // Base case - N queens have been placed
        if (row == size) {
            solutions.add(createBoard(state));
            return;
        }
        
        for (int col = 0; col < size; col++) {
            int currDiagonal = row - col;
            int currAntiDiagonal = row + col;
            if (cols.contains(col) || diagonals.contains(currDiagonal) || antiDiagonals.contains(currAntiDiagonal)) {
                continue;    
            }
            
            cols.add(col);
            diagonals.add(currDiagonal);
            antiDiagonals.add(currAntiDiagonal);
            state[row][col] = 'Q';

            helper(row + 1, diagonals, antiDiagonals, cols, state);
            cols.remove(col);
            diagonals.remove(currDiagonal);
            antiDiagonals.remove(currAntiDiagonal);
            state[row][col] = '.';
        }
    }
}