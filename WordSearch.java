// Time Complexity :O(MXN)4^l
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :yess
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach in three sentences only: recursion

class Solution {
    private int dirs[][]={{1,0}, {0,1}, {0,-1}, {-1,0}};
    public boolean exist(char[][] board, String word) {
        int m= board.length;
        int n= board[0].length;

        for(int i=0; i<m;i++){
            for(int j=0; j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(search(board, word, m, n, i, j, 0)){
                        return true;
                    }
                }    
            }
        }
        return false;
    }

    public boolean search(char[][] board, String word,int m, int n, int i, int j, int k){
        if(k==word.length()) return true;

        if(i==m || j==n || i<0 || j<0 || board[i][j]!=word.charAt(k)){
            return false;
        }

        char temp= board[i][j];
        board[i][j]='*';

        for(int dir[]: dirs){
            int nr= i+dir[0];
            int nc= j+dir[1];
            if(search(board, word, m, n, nr, nc, k+1)) return true;
        }

        board[i][j]=temp;
        return false;
    }
}