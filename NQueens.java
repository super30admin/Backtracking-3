//Time Complexity :O(N^N)
//Space Complexity :O(N^2) + recursion stack.
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this :Nope


//Your code here along with comments explaining your approach
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[][] board = new int[n][n];
        placeQueens(board,0,n,result);
     return result;
    }
    public boolean placeQueens(int[][] board, int row, int n, List<List<String>> result){
        if(row == n){
            addToResult(board,result);
            return false;
        }
        for(int i = 0; i < n; i++){
            if(isSafe(board,row,i)){
                board[row][i] = 1;
                if(placeQueens(board,row+1,n,result)){return true;}
                board[row][i] = 0;
            }
        }
        return false;
    }
    public boolean isSafe(int[][] board, int row, int col){
        for(int i = 0; i < row; i++){
            if(1 == board[i][col]){return false;}
        }
        int r = row - 1;
        int c = col -1;
        while(r >= 0 && c >= 0){
            if(1 == board[r][c]){return false;}
            r--;c--;
        }
        r = row - 1;
        c = col + 1;
        while(r >= 0 && c < board.length){
            if(1 == board[r][c]){return false;}
            r--;
            c++;
        }
        return true;
    }
    public void addToResult(int[][] board, List<List<String>> result){
        List<String> list = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            StringBuilder sb = new StringBuilder("");
            for(int j= 0; j < board[0].length; j++){
                if(1 == board[i][j]){
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
        result.add(list);   
    }
}