import java.util.ArrayList;
import java.util.List;
/*
// Time Complexity : O(N!)
// Space Complexity : O(N2)

 */
public class Nqueens {
    class Solution {
        List<List<String>> list ;
        char board[][];
        public List<List<String>> solveNQueens(int n) {
            board = new char[n][n];
            list = new ArrayList<>();
            helper(0);
            return list;
        }
        private void helper(int r){
            //base
            if(r == board.length) {
                List<String> aw= new ArrayList<>();
                for(int i=0; i<board.length; i++) {
                    StringBuilder sb = new StringBuilder();
                    for(int j=0;j<board.length; j++) {
                        if(board[i][j] == 'Q'){
                            sb.append('Q');
                        }
                        else{
                            sb.append('.');
                        }
                    }
                    aw.add(sb.toString());
                }
                list.add(aw);
                return ;
            }

            //logic
            for(int i=0;i<board.length;i++){
                if(checkPlace(r,i))
                {
                    board[r][i] = 'Q';
                    helper(r+1);
                }
                board[r][i] = ' ';
            }
        }
        public boolean checkPlace(int r, int c){
            //check the column up
            for(int i=0; i< r; i++) {
                if(board[i][c] == 'Q') {
                    return false;
                }
            }
            //check the column left
            int j = c;
            for(int i=r-1; i>=0 &&  j-1 >=0; i--) {
                if(board[i][--j] == 'Q') {
                    return false;
                }
            }
            //check the column right
            j = c;
            for(int i=r-1; i>=0 && 1+j <board.length; i--) {
                if(board[i][++j] == 'Q') {
                    return false;
                }
            }
            return true;
        }
    }
}
