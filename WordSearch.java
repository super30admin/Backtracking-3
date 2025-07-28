// Time Complexity : O(3^length of word * m*n)
// Space Complexity : O(length of word)//recursive stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : for each cell check if word can be formed by checking it's 4 neighbors. Use vis matrix and backtracking
/// to keep track of words we already visited (same pos characters cannot be repeated in word)
class Solution {
    boolean wordFound;
    public boolean exist(char[][] board, String word) {
        boolean vis[][] = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(helper(board, i, j, 0, word, vis)){
                    return true;
                }
            }
        }
        return wordFound;
    }
    private boolean helper(char[][] board, int i, int j, int idx, String word, boolean vis[][]){
        int m = board.length, n = board[0].length;
        int dirs[][] = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        if(idx == word.length()){
            wordFound = true;
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>= board[0].length || vis[i][j]){
            return false;
        }
        vis[i][j] = true;
        if(word.charAt(idx) == board[i][j]){
            //System.out.println("Found "+word.charAt(idx));
            for(int dir[]: dirs){
                int new_r = i + dir[0];
                int new_c = j + dir[1];
                //System.out.println("from "+i+" "+j+" going to "+new_r+" "+new_c);
                if(helper(board, new_r, new_c, idx+1, word, vis)){
                    return true;
                }
            }
        }
        vis[i][j] = false;
        return false;
    }
}