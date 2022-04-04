// Time Complexity : O(N * 3 ^ L) L is the length of string to be matched
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We will check all the positions in the board to be the starting position
// We will then match the characters of word starting from first to last
// If we find no matching we will backtrack and match in other directions
// If we reach the end while matching we will return true as we found the match

class Solution {
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                boolean x = find(board, i, j, word, 0);   
                if(x) return true;
            }
        }
      return false;
    }
    private boolean find(char[][]board, int i, int j, String word, int index){
        //base
        if(word.length() == index)
            return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#')
            return false;
        //recurse
        if(word.charAt(index) == board[i][j]){
            board[i][j] = '#'; 
            boolean found = false;
            boolean yes = false;
            for(int[] dir: directions){
                int x = dir[0] + i;
                int y = dir[1] + j;
                found = find(board, x, y, word, index + 1);
                if(found) yes = true;  
            }
            board[i][j] = word.charAt(index);
            return yes;
        }
        return false;
    }
}