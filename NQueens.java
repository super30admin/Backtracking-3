//space O(n2)
//time O(n!)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
       List<List<String>> result = new ArrayList<>();
        if(n==0){
            return List.of();
        }
        helper(board,n,0,result);
        return result;
    }
    private void helper(boolean[][] board, int n, int r,  List<List<String>> result){
        if(r == n){
            List<String> li = new ArrayList<>();
            for(int i =0 ; i<n; i++){
                StringBuilder st = new StringBuilder();
                for(int j =0 ; j<n ; j++){
                    if(board[i][j] == true){
                        st.append("Q");
                    }else{
                        st.append(".");
                }
                        
            }
                li.add(st.toString());
                
        }
            result.add(li);
     }
                                  
        for(int j =0; j<n; j++){
            if(isValid(board,r,j, n)){
                board[r][j] = true;
                helper(board, n, r+1, result);
                board[r][j] = false;

            }
        }
    }
    
    boolean isValid(boolean[][] board, int r, int c, int n){
       //col
        for(int i =0; i<n; i++){
            if(board[i][c]) return false;
        }
        
        int i =r; int j = c;
        while(i>=0 && j>=0){
            if(board[i][j]) return false;
            i--;j--;
        }
        
        i =r; 
        j = c;
        while(i>=0 && j<n){
            if(board[i][j]) return false;
            i--; j++;
        }
        return true;
    }
}