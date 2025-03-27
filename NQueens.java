import java.util.ArrayList;
import java.util.List;

//Time Complexity : O(n!)
//Space Complexity : O(n^2)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/*
Start placing queen in the column from i=0 to n. While placing check if it is safe to place at that column. If safe then go to next row. When we place a queen we mark that node as
true, before moving to next column we mark node as false. In safe we check left diagonal, right diagonal and vertically up. 
*/
class NQueens {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board=new boolean[n][n];
        List<List<String>> res=new ArrayList<>();
        backtrack(board,res,0,n);
        return res;
    }

    private void backtrack(boolean[][] board,List<List<String>> res,int row, int n){
        //base
        if(row==n){
            List<String> li=new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<n;j++){
                    if(board[i][j]){
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            res.add(li);
        }

        //logic
        for(int c=0;c<n;c++){
            if(isSafe(board,row,c)){
                board[row][c]=true;
                backtrack(board,res,row+1,n);
                board[row][c]=false;
            }
        }
    }

    private boolean isSafe(boolean[][] board, int r, int c){
        //col up
        for(int i=0;i<r;i++){
            if(board[i][c]){
                return false;
            }
        }

        //diag left
        int i=r-1;
        int j=c-1;
        while(i>=0 && j>=0){
            if(board[i][j]){
                return false;
            }
            i--;
            j--;
        }
        //diag right
        i=r-1;
        j=c+1;
        while(i>=0 && j<board.length){
            if(board[i][j]){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}
