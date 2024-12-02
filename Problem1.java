import java.util.*;

class Solution {
    List<List<String>> result ;
    boolean[][] board ;
    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        this.board = new boolean[n][n];
        helper(0,n);
        return this.result;
    }

    //TS:O(N!)
    //TS:O(N) stack space
    private void helper(int row, int n){
        //this is a valid solution if we were able to place in the end
        if(row == n){
            //valid solution
            List<String> rowPlacement = new ArrayList<>();
            for(int k =0;k<n;k++){
                StringBuilder builder = new StringBuilder();
                for(int l =0;l<n;l++){
                    if(board[k][l]){
                        builder.append('Q');
                    }else{
                        builder.append('.');
                    }

                }
                rowPlacement.add(builder.toString());
            }
            result.add(rowPlacement);
            return;
        }
        for(int c=0;c<n;c++){
            if(isSafe(row,c,n) && !this.board[row][c]){
                this.board[row][c] = true;
                helper(row+1,n);
                this.board[row][c] = false;
            }

        }
    }

    boolean isSafe(int r , int c,int n){
        int r1 = r;
        int c1 = c;

        //top right
        while(r1>=0){
            if(this.board[r1][c1]){
                return false;
            }
            r1--;
        }

        //dioganal left
        r1 = r;
        c1 = c;
        while(r1>=0 && c1>=0){
            if(this.board[r1][c1]){
                return false;
            }
            r1--;
            c1--;
        }

        //diagona right

        r1 = r;
        c1 = c;
        while(r1>=0 && c1<n){
            if(this.board[r1][c1]){
                return false;
            }
            r1--;
            c1++;
        }

        return true;
    }
}