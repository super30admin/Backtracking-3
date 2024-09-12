/*
The time complexity is O(N!) since we select each row with choices N(N-1)(N-2)..
The space complexity is O(N^2) since I am creating a boolean[][] array with size n^2.

The intuition here is to traverse through each row and try to select a column in that row. If it is selected we move to the next.
If any of our positions are not valid we backtrack to undo our choice

Yes, the code passed all the test cases in leet code
 */

class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        List<List<String>> ret = new LinkedList<>();
        backtrackNQueen(ret,board,n,0);
        return ret;
    }

    public void backtrackNQueen(List<List<String>> ret,boolean[][] board,int n,int start){
        if(start==board.length){
            addToList(ret,board);
            return;
        }

        for(int j=0;j<board[0].length;j++){
            board[start][j] = true;

            if(!conflict(board,start,j)) {
                backtrackNQueen(ret, board, n, start + 1);
            }

            board[start][j] = false;

        }
    }

    public void addToList(List<List<String>> ret,boolean[][] board){
        List<String> list = new LinkedList<>(); StringBuilder sb = new StringBuilder();
        int boardrows = board.length; int boardcols = board[0].length;

        for(int i=0;i<boardrows;i++){
            for(int j=0;j<boardcols;j++){
                if(board[i][j]){
                    sb.append("Q");
                }
                else{
                    sb.append(".");
                }
            }
            list.add(new String(sb));
            sb = new StringBuilder();
        }

        ret.add(list);
    }


    public boolean conflict(boolean[][] matrix,int row,int col){

        int leftDiagonal = col-1; int rightDiagonal = col+1; int matrixCol = matrix[0].length;
        for(int i=row-1;i>=0;i--){
            if(leftDiagonal>=0){
                if(matrix[i][leftDiagonal]){
                    return true;
                }
                leftDiagonal--;
            }
            if(rightDiagonal<matrixCol){
                if(matrix[i][rightDiagonal]){
                    return true;
                }
                rightDiagonal++;
            }
            if(matrix[i][col]){
                return true;
            }
        }

        return false;
    }
}