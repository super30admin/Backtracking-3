TC: m*n*3^k  k = length of word  or exponential
SC: O(n)

Runtime: 12 ms, faster than 19.33% of Java online submissions for Word Search.
Memory Usage: 39 MB, less than 91.84% of Java online submissions for Word Search.
Next challenges:

Approach: We explore all directions to find each subsequent letter.If it is  found it will be added to a visited list. If we reach till last
character, we will return false which will be propagated directly to higher levels.If a character is not matching , then we will backtrack and
go back to the last character till which matching happened and check in remaining directions.A visited list is used to prevent the cycling condition.
While backtracking we will remove the current character which mathced but could not match with the next character.

class Solution {
    int[][] dirs = new int [][] { {1,0},{0,1},{-1,0},{0,-1}};
    int m; int n; boolean [][] visited;
    public boolean exist(char[][] board, String word) {
      
        m=board.length;
        n=board[0].length;
        visited = new boolean[m][n];
        for(int i=0; i<m ;i++){
            for(int j=0; j<n; j++){
                if(dfs(board,i,j,word)) return true;
            }
        }
        return false;

    }
    private boolean dfs(char[][] board, int i, int j, String word ){
        if(i<0 || i>= m || j<0 || j>=n || visited[i][j] == true) return false;
        // if(word.length() == 0) return true;
        
        if(word.charAt(0)== board[i][j]){
            if(word.length() == 1) return true;  // if it is the last character and it matches means stop right there
            visited[i][j]= true;
            for(int[] dir : dirs){
                int k = i+ dir[0];
                int t = j+ dir[1];
                if( dfs(board, k, t, word.substring(1))) return true;
            }
            visited[i][j]= false;  // backtracking
        }
        
        return false;
    }
}
