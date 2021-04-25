//Time Complexity : O(N!). The first queen will have N choices, the second will have (N-2) choice, third queen will have (N-4) choices and so on. Considering the upper bound, the total time taken is O(N!).
//Space Complexity : O(N^2). Space used by the board.
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english :
/*
At each index, it should be check whrther the queen is safe to be place  by checking the row, col and diagonals from the curret index.
ACTION : place the queen if safe
RECURSE: Check the next row is safe to place the next queen
BACKTRACK: if cannot place the current queen at the current index, then backtrack. Remove the current queen and then g to previous queen and look for new position.
*/
// Your code here along with comments explaining your approach
class Solution {
    int m;
    List<List<String>> result;
    //create the board
    int[][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if(n==0){
            return result;
        }
        m = n;
        board = new int[m][m];
        //helper function to backtrack
        backtrack(0);//passing the first row
        return result;
    }
    private void backtrack(int row){
        //base : if the end of the board is reached
        if(row == m){
            List<String> str = new ArrayList<>();
            //convrt the 1's to Q's and 0's to '.'
            for(int i=0;i<m;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<m;j++){
                    if(board[i][j]==1){
                        sb.append('Q');
                    }
                    else{
                        sb.append('.');
                    }
                }
                str.add(sb.toString());
            }
            result.add(str);
            return;
        }
        //checking by col and diagonal
        for(int col=0;col<m;col++){
            //check if its safe to place queen at this cell
            if(isSafe(row,col)){
                //ACTION: place the queen
                board[row][col] = 1;
                //RECURSE : Check in the next row
                backtrack(row + 1);
                //BACKTRACK : remove the queen from this location and go to previous queen to try new location
                board[row][col] = 0;
            }
        } 
    }
    private boolean isSafe(int row,int col){
        //upper col
        for(int i=0;i<row;i++){
            //if queen is present cant place the new queen in this col
            if(board[i][col]==1){
                return false;
            }
        }
        //upper left diagonal
        int r=row,c=col;
        while(r>=0 && c>=0){
            if(board[r][c]==1){
                return false;
            }
            r--;
            c--;
        }
        //upper right diagonal
        int r1 = row, c1=col;
        while(r1>=0 && c1<m){
             if(board[r1][c1]==1){
                return false;
            }
            r1--;
            c1++;
        }
        return true;
    }
}