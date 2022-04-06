// Time Complexity : O( N * (3 ^ L) )
// Space Complexity : O(L) -- L is length of the Word to search
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    int[][] directions;
    int m,n;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0)   return false;
        
        directions = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1} };
        m = board.length; n = board[0].length;
        for(int i = 0; i< m; i++){
            for(int j = 0; j< n; j++){
                if(helper(board, word, 0, i, j)) return true;
            }
        }
        
        return false;
    }
    
    public boolean helper(char[][] board, String word,int index, int row, int col){
        //Base case
        if(row < 0 || row == m || col < 0 || col == n || board[row][col] == '#')    return false;
        
        if( index == word.length() ) return true;
        
        
        if(board[row][col] == word.charAt(index)){
            if(index + 1 == word.length())  return true;
            char t = board[row][col]; //Storing character in temp variable
            board[row][col] = '#'; //Marking cell as visited
            
            for(int[] d : directions){ // Check for all 4 neighbours
                int i = d[0] + row;
                int j = d[1] + col;
                
                if(helper(board, word, index + 1, i, j))    return true; 
            }
            
            
            //When Backtracting, reseting the cell to its original Value
            board[row][col] = t;
        }
        
        
        return false;
    }
}