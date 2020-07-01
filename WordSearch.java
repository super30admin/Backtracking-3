// Time Complexity: O(m*n*3^L) 3^L because we can go to 3 other directions (and we are coming from one another direction, so we dont go to that direction - so its just 3). L because each char in the string will be looked up 3 times in the board
// Space Complexity: O(h) h=ht of stack which can go upto len of given string in worst case

// Backtrack solution: Iterate over the board in DFS manner. If the current char in the board matches the the current index that we are at in the "word" string, 
// then explore that path further and mark it visited or replace it with a special charachter.
//  If it is not the case, then backtrack and return the recently visited character in the board to its original state.

class Solution {
    int m,n;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length==0) return false;
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                if(dfsBacktrack(board,word,i,j)) return true;
            }
        }
        return false;
    }
    
    private boolean dfsBacktrack(char[][] board, String word, int i, int j) {
        //base
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) return false;
        // logic
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        if(board[i][j]==word.charAt(0)) {
            char prev = board[i][j]; // storing the recent visited path
            board[i][j] = '#'; // marking visited path with spl char
            if(word.length()==1) return true; // edge case when word len is 1
            for(int[] dir:dirs) {
                int r = i+dir[0];
                int c = j+dir[1];
                if(dfsBacktrack(board,word.substring(1),r,c)) return true; // to visit all different directions
            }
            board[i][j] = prev;
        }
        return false;
    }
}