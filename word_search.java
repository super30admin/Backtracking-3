// Time Complexity : O(m*n + 3^l), where m and n are the row and columns of the board and l is the length of word
// Space Complexity : O(l), where l is the length of word (space for recursive stack)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : correct me on the time complexity

//Three liner explanation in plain english of your approach
//1. start the dfs from the 1 st cell of the board, and keep checking if the char in the board at i j, matches
        // the char int the word at index
//2. If no return false, else replace the char in the word at i j with '#' and call dfs on its 4-neighbours
        //to find the complete word
//3. If none of the 4-neighbours have the next char in the word, put the original char back at place of hash
        //(backtrack)

// Your code here along with comments explaining your approach

class Solution {
    int m;
    int n;
    int [][] dirs; 
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        //directions array
        dirs = new int [][]{{0,1}, {-1,0}, {0,-1}, {1,0}};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                //if backtrack return true, you found the word
                if(backtrack(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board, String word, int i, int j, int index){
        //base
        //happy path
        if(index == word.length()) return true;
        //sad path
        if(i< 0 || i>=m || j<0 || j>=n) return false;
        
        //logic
        if(board[i][j] == word.charAt(index)){
            //action
            char temp = board[i][j];
            board[i][j] = '#';
            //recurse
            //check if any of the neighbours of i and j in the board has the next character in the word String, if yes change that neighbour to a hash and continue recursion (dfs)
            //if not no neighbours matches the character in the string, replace the hash with the original value it had (backtrack)
            for(int[] dir : dirs){
                int r = dir[0]+i;
                int c = dir[1]+j;
                
                if(backtrack(board, word, r, c, index+1)){
                    return true;
                }
            }
            //backtrack
            board[i][j] = temp;
        }
        //if the char in the word does not match the char in the board at i j, return false
        return false;
    }
}