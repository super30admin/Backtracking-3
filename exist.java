// Time Complexity :O(m * n)
// Space Complexity :O(m * n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public boolean exist(char[][] board, String word) {
        boolean [][] visited = new boolean [board.length][board[0].length];
        
        for(int i=0; i<board.length; i++){
            for(int j=0;j<board[0].length; j++){
                
                if(word.charAt(0) == board[i][j] &&
                    bfs(board , 0, word, i, j, visited)){
                        return true;
                    }
                }
            }
        
        return false;
    }

    private boolean bfs(char [][] board, int index, String word, int row, int col, boolean [][] visited ){
        //base case 
        if (index >= word.length()) return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || 
           word.charAt(index) != board[row][col] || visited[row][col] == true ) {
            return false;
        }
        
        visited[row] [col] = true;
        
        if(bfs(board,index+1, word, row+1, col, visited)||
        bfs(board,index+1, word,  row-1, col, visited)||
        bfs(board,index+1, word, row, col+1, visited) ||
        bfs(board,index+1, word, row, col-1, visited) ){
            return true;
        }
        visited[row] [col] = false;
        return false;
    }
}
