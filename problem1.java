class Solution {
    int n;
    int leftDiagonal[];
    int rightDiagonal[];
    int column[];

    boolean isValidToPlace(int row, int col, int leftDiagonal[], int rightDiagonal[], int column[]) {
        int n = column.length;

        // column[col] != 1 -> once placed at a column of any row then it can not be
        // placed at the same column of other row

        // leftDiagonal[row-col+n-1] != 1 -> once placed at board[row][col] then queen
        // can not be placed on any other leftDiagonal i.e, row-col (Since row-col can
        // be negative so using a an array of length n*2 and checkin after adding (n-1))

        // rightDiagonal[row+col] != 1 -> once placed at board[row][col] then queen can
        // not be placed on any other leftDiagonal i.e, row+col

        return (column[col] != 1 && leftDiagonal[row - col + n - 1] != 1 && rightDiagonal[row + col] != 1);
    }

    public List<List<String>> solveNQueens(int n) {

        this.n = n;
        this.leftDiagonal = new int[n * 2];
        this.column = new int[n];
        this.rightDiagonal = new int[n * 2];

        // make board
        char[][] board = new char[n][n];

        // fill with empty .

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(board, n, 0);

        return output;

    }

    List<List<String>> output = new ArrayList<>();

    public void backtrack(char[][] board, int queensLeft, int r) {

        // base case

        if (queensLeft <= 0) {
            output.add(makeOutput(board));
            return;
        }

        // recursive case

        for (int c = 0; c < board.length; c++) {
            if (isValidToPlace(r, c, leftDiagonal, rightDiagonal, column)) {
                leftDiagonal[r - c + n - 1] = 1;
                rightDiagonal[r + c] = 1;
                column[c] = 1;
                board[r][c] = 'Q';
                backtrack(board, queensLeft - 1, r + 1);
                leftDiagonal[r - c + n - 1] = 0;
                rightDiagonal[r + c] = 0;
                column[c] = 0;
                board[r][c] = '.';
            }
        }
    }

    public List<String> makeOutput(char[][] board) {
        List<String> output = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            String temp = "";
            for (int j = 0; j < board[0].length; j++) {
                temp += board[i][j];

            }

            output.add(temp);
        }

        return output;
    }
}