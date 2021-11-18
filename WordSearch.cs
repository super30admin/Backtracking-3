// Time: O(m*n*3^L) m is number of rows, n is number of coloumn, L is length of word to search
// Space: O(L)
// Leetcode: https://leetcode.com/submissions/detail/588835303/
public class Solution {
    int[][] dirs;
    public bool Exist(char[][] board, string word) {
        if(board == null || board.Length == 0 || board[0].Length == 0) {
            return false;
        }
        dirs = new int[][]{new int[]{0, 1}, new int[]{1,0}, new int[]{-1,0}, new int[]{0,-1}};
        for(int i = 0; i < board.Length; i++){
            for(int j = 0; j < board[i].Length; j++) {
                if(BackTrack(board, word, i, j, 0)){
                   return true;
                }
            }
        }	
        return false;
    }
    
    private bool BackTrack(char[][] board, string word, int i, int j, int index) {
	    //base condition
        if(index == word.Length) {
            return true;
        }
        
        if(i < 0 || j < 0 || i == board.Length || j == board[0].Length || board[i][j] == '#') {
            return false;
        }
        
        //logic
        if(board[i][j] == word[index]){
            char c = word[index];
            board[i][j] = '#';
            //recurse
            foreach(int[] d in dirs) {
                int nr = i + d[0];
                int nc = j + d[1]; 
                if(BackTrack(board, word, nr, nc, index+1))
                    return true;
            }
            board[i][j] = c;
        }
        return false;
	}
        
}