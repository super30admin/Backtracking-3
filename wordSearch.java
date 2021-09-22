// Time Complexity: Exponential time complexity O(m*n*3^length) as is a solution is found we return immediately
// Space Complexity: recursive stack has O(n) space complexity
// Did you complete it on leetcode: Yes
// Any problems faced: identified logic correctly needed some help in implementation

// Write your approach:
// Idea here is to iterate through each cell and perform a dfs on them
// if character on board cell is not same as word, recursion is stopped
// and next iteration is performed. Recursing on next cell we perform
// replace and directions array dfs. Replacement ensures we are not taking the same cell again.
// if on dfs of directions, word is found by checking index and word length,
// we return true, if it goes beyond, we backtract to earlier board value.
class Solution {
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        if(board==null && word==null) return true;
        if(board==null || word==null || board.length==0) return false;
        String path = "";
        dirs = new int[][]{{0,-1}, {-1,0}, {0,1}, {1,0}};
        for(int i=0; i<board.length; i++) {
            for(int j = 0; j<board[0].length; j++) {
                if(dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, String word, int rowIdx, int colIdx, int index) {
        // base
        if(word.length()==index) {
            return true;
        }
        if(rowIdx<0 || rowIdx==board.length || colIdx<0 || colIdx==board[0].length ||
          word.charAt(index)!=board[rowIdx][colIdx]) return false;

        
        // logic
        boolean flag = false;
        board[rowIdx][colIdx] = '@';
        for(int[] dir: dirs) {
            int currRow = rowIdx + dir[0];
            int currCol = colIdx + dir[1];
            if(dfs(board, word, currRow, currCol, index+1)) {
                flag = true;
                break;
            }        
        }
        board[rowIdx][colIdx] = word.charAt(index);
        return flag;
    }
}