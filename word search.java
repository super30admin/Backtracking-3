// Time Complexity : O(n * 3^L) n = number of elements in matrix. L = length of the string
// Space Complexity : O(L) 	
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        //row
        m = board.length;
        //col 
        n = board[0].length;
        //edge
        if(board == null || board.length == 0) return false;
        //start a foor loop to find the first element in the strign
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //if the word is found then return true
                if(helper(board, word, i, j, 0)) return true;
            }
        }
    //else return false
    return false;
    }
    private boolean helper(char[][] board, String word, int i, int j, int idx){
        //base
        //if the length of the string has been gone through without any false calls the return true have found the word
        if(idx == word.length()) return true;
        //check boundaries to return false
        if(i < 0 || j < 0 || i == m || j == n || board[i][j] == '.') return false;
        //logic
        //create a directions array
        int[][] dirs = {{0,1},{-1,0},{0,-1},{1,0}};
        //if the string letter equals the word we are looking for then start checking neigbors and caling recursion and backtrack
        if(word.charAt(idx) == board[i][j]){
            //store the current string as a temp before changing it to a dot (.)
            char temp = board[i][j];
            //take the action
            //set it equal to dot (.) to indicate visited
            board[i][j] = '.';
            //now go through its neighbors
            for(int[] direc : dirs){
                //get row and col
                int row = i + direc[0];
                int col = j + direc[1];
                //call helper and if you find next letter return true
                if(helper(board, word, row, col , idx+1)) return true;
            }
            //backtrack and change the dot (.) back to temp which had the orignal letter because we need to check other directions
            board[i][j] = temp;
        } 
        //if no true passes
        return false;
    }
}


