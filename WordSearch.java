// Time Complexity : O(mn*4^L) where L is the length of the word to be searched
// Space Complexity : O(L) for the recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Start from each cell and call dfs if you find the first char of the word
//  Check the neighbours for the next char and mark the cell as visited by changing its value to a '#'
// If the path is not feasible, backtrack by unmarking the cell to previous value and explore other paths

class Solution {
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    int m; int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        // search pruning : if length of word is greater than total elements in board, exit
        if(m*n<word.length()) return false;

        // search pruning : start from the end if the last char occurrence is less than first char occurrence (less possible routes to search)
        int first =0; int last =0;
        if(word.charAt(0) != word.charAt(word.length()-1)){
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(board[i][j] == word.charAt(0))
                        first++;
                    if(board[i][j] == word.charAt(word.length()-1))
                        last++;
                }
            }
        }
        // search from reversed word
        if(first > last)
            word = new StringBuilder(word).reverse().toString();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == word.charAt(0))
                    if(backtrack(board,i,j,word,0)) return true;
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, int r, int c, String word, int idx){
        //base
        if(idx == word.length()) return true;
        if(r<0 || c<0 || r>=m || c>=n) return false;
        //logic
        if(board[r][c] == word.charAt(idx)){
            board[r][c] = '#';
            for(int[] dir:dirs){
                int nr = r+dir[0];
                int nc = c+dir[1];
                
                if(backtrack(board,nr,nc,word,idx+1)) return true;
            }
            board[r][c] = word.charAt(idx);
        }

        return false;
    }
}