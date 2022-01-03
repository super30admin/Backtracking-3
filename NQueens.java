import java.util.*;

public class NQueens {
        /*

        TC: O(n!)
        SC: O(n^2)

        */
        List<List<String>> result;
        boolean board[][];
        public List<List<String>> solveNQueens(int n) {
            result=new ArrayList<>();
            if(n==0) return result;
            board=new boolean[n][n];
            backtrack(0);
            return result;
        }

        private void backtrack(int row){
            if(row==board.length){
                List<String> newList=new ArrayList<>();
                for(int i=0;i<board.length;i++){
                    StringBuilder sb=new StringBuilder();
                    for(int j=0;j<board.length;j++){
                        if(board[i][j]==true){
                            sb.append('Q');
                        }
                        else{
                            sb.append('.');
                        }
                    }
                    newList.add(sb.toString());
                }
                result.add(newList);
                return;
            }

            for(int j=0;j<board.length;j++){
                if(isValid(row,j)){
                    //action
                    board[row][j]=true;
                    //recurse
                    backtrack(row+1);
                    //backtrack
                    board[row][j]=false;
                }
            }
        }

        private boolean isValid(int r,int c){
            //1. column
            for(int i=r;i>=0;i--){
                if(board[i][c]==true){
                    return false;
                }
            }

            //2. upper left diag

            int i=r;int j=c;
            while(i>=0 && j>=0){
                if(board[i][j]==true){
                    return false;
                }
                i--;
                j--;
            }

            i=r;j=c;
            while(i>=0 && j<board.length){
                if(board[i][j]==true){
                    return false;
                }
                i--;
                j++;
            }
            return true;
        }
}
