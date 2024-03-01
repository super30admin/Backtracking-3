// ## Problem2
// Word Search(https://leetcode.com/problems/word-search/)

//DFS+backtracking based solution
// Time: O(MN*3^L), where M*N size of input, and L is the length of word to be searched
// Space: O(L) recursive stack space

class Solution {
    private int m;
    private int n;
    private int[][] dirs={{0,1},{1,0},{-1,0},{0,-1}};

    private boolean dfs(char[][] board, int r, int c, String word, int idx){
        //base
        if(idx==word.length()){
            // entire word found
            return true;
        }
        if(r<0||c<0||r==m||c==n||board[r][c]!=word.charAt(idx)){
            return false;
        }

        //logic
        if(board[r][c]==word.charAt(idx)){
            //action
            board[r][c]='#';

            //recurse in all directions
            for(int[] dir: dirs){
                int nr=r+dir[0];
                int nc=c+dir[1];

                if(dfs(board,nr,nc,word,idx+1)){
                    //found
                    return true;
                }
            }
            //backtrack
            board[r][c]=word.charAt(idx);
        }

        // not found
        return false;
    }

    public boolean exist(char[][] board, String word) {
        this.m=board.length;
        this.n=board[0].length;

        // Search entire board to match first char of word
        // If found do a dfs at that place
        for(int i=0;i<m;i++){   // O(M*N)
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){// O(3^L), l is length of word
                    if(dfs(board, i, j, word, 0)){
                        // if word found at i,j
                        return true;
                    };  
                }
            }
        }

        // not found
        return false;
    }
}