//79. Word Search - https://leetcode.com/problems/word-search/description/
//Time Complexity: O((m*n)3^L) : L is the length of the word
//Space Complexity: O(n - length of the string)

class Solution {
    private int[][] dirs;
    int m,n;
    boolean flag;
    public boolean exist(char[][] board, String word) {
        this.dirs = new int[][] {{0,1},{0,-1},{-1,0},{1,0}};
        this.m = board.length;
        this.n = board[0].length;
        this.flag = false;
        //edge case
        if(board==null || board.length==0 || board[0].length==0 || word.length()==0)
            return false;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!flag){
                    dfs(board, i, j, word, 0);
                } else{
                    break;
                }
            }
        }
        return flag;
    }

    private void dfs(char[][] board, int i, int j, String word, int currIdx){
        //base case
        if(currIdx == word.length()){
            flag = true;
            return;
        }
        if (i<0 || i==m || j<0 || j==n || board[i][j]=='#') return;

        //logic
        if(board[i][j]==word.charAt(currIdx)){
            board[i][j] = '#'; //visited
            //recurse on all directions
            for (int[] dir : dirs) {
                int r = dir[0] + i;
                int c = dir[1] + j;
                dfs(board, r, c, word, currIdx + 1);
            }
            //backtrack after checking all 4 directions
            board[i][j] = word.charAt(currIdx);
        }
        return;
    }
}