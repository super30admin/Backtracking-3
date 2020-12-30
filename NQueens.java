/*
Time Complexity : O(N!) 
Space COmplexity : O(N^2)
Idea : represent the board using int array with set of 0 and 1 where 1 represents the queen
is present and 0 represent the queen isn't we place the queen row wise for each column
and check if it is safe to keep it there if not the decision is backtracked and next position id tried.
*/
class Solution {
    int[][] board;
    List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        board = new int[n][n];
        helper(board,0,n);
        return ans;
    }
    
    public void helper(int[][] board,int row,int n){
        if(row == n){
            List<String> temp = new ArrayList<String>();
            for(int i=0;i<n;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n;j++){
                    if(board[i][j] == 1){
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }
                temp.add(sb.toString());
            }
            ans.add(temp);
            return;
        }
        for(int i=0;i<n;i++){
            if(isSafe(board,row,i,n)){
                board[row][i] =1;
                helper(board,row+1,n);
                board[row][i]=0;
            }
        }
    }
    
    public boolean isSafe(int[][] board,int row,int col,int n){
        for(int i=row;i>=0;i--){
            if(board[i][col] == 1){
                return false;
            }
        }
        int i = row;
        int j = col;
        while(i>=0 && j>=0){
            if(board[i][j] == 1){
                return false;
            }
            i--;
            j--;
        }
        i=row;
        j=col;
        while(i>=0 && j<n){
            if(board[i][j] == 1){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}