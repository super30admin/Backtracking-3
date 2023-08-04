// Time Complexity : O(m*n (3^l)) 
// Space Complexity : l due to the recursion stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    boolean result;
    public boolean exist(char[][] board, String word) {
        char c = word.charAt(0);
        int m = board.length;
        int n = board[0].length;
        //Run recursion on every char in board
        //If the char matches with the first char in word, go ahead with the recursion
        for(int i = 0; i<m; i++){
            for(int j=0; j<n; j++){
                if(result){
                    return result;
                }
                if(board[i][j] == c) helper(board, word, i, j, 1);
            }
        }
        return result;
    }

    int[][] dirs = new int[][]{{0,-1}, {0,1}, {1,0}, {-1,0}};

    private void helper(char[][] board, String word, int i, int j, int cnt){
        //base case
        //If we reach at the end of the word, ie we found all the chars of the word in board, make the result as true
        if(cnt == word.length()){
            result = true;
            return;
        }

        //logic
        //We go in all four directions to search for the next char matching with the word
        if(!result){
            char c = board[i][j];
            //Marking as '.' to keep track of visited char
            board[i][j] = '.';
            for(int[] dir: dirs){
                int m = i+dir[0];
                int n = j+dir[1];
                if(!result && m>=0 && n>=0 && m<board.length && n<board[0].length && board[m][n] == word.charAt(cnt) ){
                    helper(board, word, m, n, cnt+1);
                }
            }
            //Backtrack
            board[i][j] = c;
        }
        
        

    }
}