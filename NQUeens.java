/*The time complexity of this implementation is O(N!)*/
import java.util.ArrayList;
import java.util.List;

class NQueens {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        backtrack(board,0);
        return res;
    }
    private void backtrack(char[][] board,int row){
        if(row == board.length){
            res.add(construct(board));
            return;
        }
        for(int col=0;col<board.length;col++){
            if(isValid(board,row,col)){
                board[row][col] = 'Q';
                backtrack(board,row+1);
                board[row][col] = '.';
            }
        }
    }
    private boolean isValid(char[][] board,int row,int col){
        for(int i=0;i<row;i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    private List<String> construct(char[][] board){
        List<String> res = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
    public static void main(String[] args) {
        int n = 4; // change this to the desired value of N
        NQueens s = new NQueens();
        List<List<String>> res = s.solveNQueens(n);
        for (List<String> sol : res) {
            for (String row : sol) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

}
