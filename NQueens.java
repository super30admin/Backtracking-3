//T.C O(n*n!) //T.C(3n) for isSafe() and n! for placing Q in each row
//S.C O(n*n) //board size
//Did the code run in LeetCode: yes


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//Traverse entire matrix by placing the queens at first safe positions. If all the queens are placed at safe place, that is a solution,
// otherwise backtrack the last queen's position and try next safe place
class NQueens {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        int[][] board = new int[n][n];
        placeQueens(board,0,n);
        return res;
    }
    private boolean placeQueens(int[][] board, int r, int n){
        //base case
        if(r==n){
            List<String> temp = new ArrayList();
            for(int i=0;i<n;i++){//n pow 2
                String a = new String();
                for(int j=0;j<n;j++){
                    if(board[i][j]==1)
                        a+='Q';
                    else
                        a+='.';
                }
                temp.add(a);
            }
            res.add(temp);
            return false;
        }
        for(int i=0;i<n;i++){ //for each col for given row r //O(n)
            if(isSafe(board,r,i,n)){
                //action
                board[r][i] = 1;
                //recurse
                if(placeQueens(board,r+1,n))
                    return true;
            }
            //backtrack
            board[r][i] = 0;
        }
        return false;
    }

    public boolean isSafe(int board[][], int i, int j, int n){
        //same col
        for(int k=0;k<i;k++){ //from 0 to curr row, check if the col has any queen already
            if(board[k][j]==1)
                return false;
        }

        //left diagonal
        int x=i-1;
        int y=j-1;
        while(x>=0 && y>=0){
            if(board[x][y]==1)
                return false;
            x--;
            y--;
        }

        //right diagonal
        x=i-1;
        y=j+1;
        while(x>=0 && y<n){
            if(board[x][y]==1)
                return false;
            x--;
            y++;
        }
        return true;
    }
}
