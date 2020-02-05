//Time Complexity: N!
//Space Complexity: N*N ~ O(n)

class Solution {
    List<List<String>> result = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        placeQueen(board,0, n);
        return result;
    }
    
    private void placeQueen(int[][] board, int r, int n){
        //base case
        //when we reach end of row
        if(r == n){
            List<String> list = new ArrayList<>();
            //for row
            for(int i=0; i<n; i++){
                StringBuilder sb = new StringBuilder();
                //and column of board
                for(int j=0; j<n; j++){
                    //if board is 1 -> append it with queen
                    if(board[i][j] ==1)
                        sb.append('Q');
                    else
                        sb.append('.');
                }
                list.add(sb.toString());
            }
            //add list to the result
            result.add(list);
            return;
        }
        //logic
        //for i columns
        for(int i=0; i<n; i++){
            //only if it is safe to put queen
            //board = 1, call placequeen function to next row
            //and backtrack for next possible outcome and append 0
            if(isSafe(board, r, i, n)){
                board[r][i] = 1;
                placeQueen(board, r+1, n);
                //backtrack
                board[r][i] =0;
            }
        }
    }
    
    private boolean isSafe(int[][] board, int i, int j, int n){
        //column up
        //row 0 to i
        for(int k=0; k<i; k++){
            if(board[k][j] == 1) return false;
        }
        
        //diagonal up left
        int x = i-1;
        int y = j-1;
        while(x>=0 && y>=0){
            if(board[x][y] == 1) return false;
            x--; y--;
        }
        
        //diagona up right
        x = i-1;
        y = j+1;
        while(x>=0 && y<n){
            if(board[x][y] == 1) return false;
            x--; y++;
        }
        return true;
    }
}