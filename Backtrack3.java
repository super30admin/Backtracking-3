// Time Complexity :O(n factorial) so all permutations 
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
// https://leetcode.com/problems/n-queens/

class Solution {
    List<List<String>> result;
    int n;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if(n == 0){
            return result;
        }
        boolean [][] board = new boolean[n][n];
        this.n = n;
        backtrack(board, 0);
        return result;
        
    }
    private void backtrack(boolean [][]board, int r){
        // base
        if(r == n){
           List<String> list = new ArrayList<String>();
           //iterate over the board
           for(int i=0; i<n; i++){
               StringBuilder br = new StringBuilder();
               for(int j=0; j<n; j++){
                   if(board[i][j] == true){
                       br.append('Q');
                   } else{
                       br.append('.');
                   }
               }
               list.add(br.toString());
           }
           result.add(list);
           return;
        }
        //logic
        for(int j=0; j<n; j++){
            if(isSafe(board, r, j)){
                //action
                board[r][j] = true;
                //recurse
                backtrack(board, r+1);
                //backtrack
                board[r][j] = false;
            }
        }
    }
    
    private boolean isSafe(boolean[][] board, int r, int c){
        //up col
        for(int i = 0; i<r; i++){
            if(board[i][c] == true) return false;
        }
        //dig up left
        int i = r, j = c;
        while(i>=0 && j>=0){
            if(board[i][j] == true) return false;
            i--;
            j--;
        }
        
        i = r;
        j = c;
         while(i>=0 && j<n){
            if(board[i][j] == true) return false;
            i--;
            j++;
        }
        return true;
    }
}

//-------------------
// Time Complexity :O(n factorial) so all permutations 
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
// https://leetcode.com/problems/word-search/submissions/

class Solution {
    
    int m;
    int n;
    int [][]dirs;
    public boolean exist(char[][] board, String word) {
        if(board == null || board[0].length == 0) return false;
        m = board.length;
        n = board[0].length;
        dirs = new int[][] {{-1,0},{1,0},{0,-1}, {0,1}};
        
        for(int i=0; i<m; i++){
            for(int j =0; j<n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(backtrack(board, i, j, word, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board, int i, int j, String word, int index){
        //base
        if(index == word.length()) return true;
        if(i < 0 || j<0 || i==m || j==n || board[i][j] == '#') return false;
        //logic
        if(board[i][j] == word.charAt(index)){
            board[i][j] = '#';
            //mark it as visited
            for(int[] dir: dirs){
                int r = i + dir[0];
                int c = j + dir[1];
                //recurse
                if(backtrack(board, r, c, word, index+1)){
                    return true;
                }
            }
            //backtrack
            board[i][j] = word.charAt(index);
        }
        
        return false;
    }
    

}