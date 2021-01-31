// Time Complexity : O(N*3^L) where N is the number of items in the board and L is the length of the word. 
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
/*
 * This approach is by using DFS recursive and backtracking it.
 * Firstly the 1st character of the word shall be searched in the board and from there the DFS will be performed and mark the visited 
 * positions as # and store the visited value in a temp variable so that if the path is incorrect the backtracking towards the valid path 
 * can be performed if the word is present in the board.
 */
public class WordSearch {
	int m;
    int n;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) return false;
        m = board.length;
        n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(backtrackHelper(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }
                   
    private boolean backtrackHelper(char[][] board, String word, int index, int i, int j){
        //base
        if(index == word.length()) return true;
        if(i < 0 || j < 0 || i == m || j == n || board[i][j] == '#') return false;
        //logic
        int [][] dirs = {{0,1}, {-1,0}, {0,-1}, {1,0}};
        if(word.charAt(index) == board[i][j]){
            char temp = board[i][j];
            //action
            board[i][j] = '#';
            for(int [] dir : dirs){
                int r = dir[0] + i;
                int c = dir[1] + j;
                if(backtrackHelper(board, word, index + 1, r, c)){
                    return true;
                }
            }
            //backtrack
            board[i][j] = temp;
        }
        return false;
    }
}
