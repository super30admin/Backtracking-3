/* Time complexity: O(m*n*3^n); where m and n are number of rows and columns
space complexity: O(l); where l is the length of the string given to search
*/

class Solution{
    int m; int n;
    public boolean exist(char[][] board, string word){
        if(board == null || board.length == 0) return false;
        m = board.length; n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dfs(board,word,i,j,0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index){
        if(i<0 || j<0 || i>=m || j>=n || board[i][j] = "#"){
            return false;
        }
        if(index == word.length()) return true;

        int[][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};
        if(word.charAt(index) == board[i][j]){
            char temp = board[i][j];
            board[i][j] = "#";
            for(int[] dir: dirs){
                int r = dir[0] + i;
                int c = dir[1] + j;
                if(dfs(board,word,r,c,index+1)) return true;
            }
            board[i][j] = temp;
        }
        return false;
    }
     
}