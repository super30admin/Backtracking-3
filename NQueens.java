// Time Complexity : O(n X n!) (n operations X n! choices)  
// Space Complexity :   O(n^2). because extra space of board.  
// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//the code uses recursion plus backtracking. The code follows the pattern action, recursion and backtrack. if we find the word we stop and 
// return true, otherwise we keep moving until end of matrix and return false; 
//Success
//Details 
//Runtime: 30 ms, faster than 7.08% of Java online submissions for N-Queens.
//Memory Usage: 44 MB, less than 5.41% of Java online submissions for N-Queens.
class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result=new ArrayList<>();
        char[][] board= new char[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        backtrack(board,n,0);
        return result;
    }
    
    private void backtrack(char[][]  board, int n, int i){
        if (n==0){
            prepareResponse(board);
            return;
        }
        for (int j=0;j<board.length;j++){
            if (canMove(board,i,j)){
                board[i][j]='Q';
                backtrack(board,n-1,i+1);
                board[i][j]='.';
            }
        }
    }
    
    private void prepareResponse(char[][] board){
        List<String> resp=new ArrayList<>();
        for (int i=0;i<board.length;i++){
            String tmp="";
            for (int j=0;j<board.length;j++){
                tmp+=board[i][j];
            }
            resp.add(tmp);
        }
        result.add(resp);
    }
    private boolean canMove(char[][] board,int i,int j){
        //check the column
        for (int r=0;r<i;r++){
            if (board[r][j]=='Q')
                return false;
        }
        //check left diagonal
       int x=i-1;
       int y=j-1;    
       while (x>=0 && y>=0){
           if (board[x][y]=='Q'){
               return false;
           }
           x-=1;
           y-=1;
       }     
        
        //check right diagonal
        x=i-1;
        y=j+1;
        while (x>=0 && y<board.length){
            if (board[x][y]=='Q'){
                return false;
            }
            x-=1;
            y+=1;
        }
        
        return true;
    }
}