// https://leetcode.com/problems/word-search/
// Time complexity : O(Num of elements in board * 3^L) 
// Space complexity : O(word length)

class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(word.charAt(0) == board[i][j]){
                    if(helper(board,word,0,i,j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean helper(char board[][],String word,int index,int i,int j){
        if(i < 0 || j < 0 || i == board.length || j == board[i].length || board[i][j] == '-' || index == word.length() || word.charAt(index) != board[i][j])
            return false;
        
        if(index == word.length()-1)
            return true;
        
        char thisIsHowYouBackTrack = board[i][j];
        board[i][j] = '-';
        boolean found = false;
        for(int dir[] : new int[][]{{0,1},{1,0},{0,-1},{-1,0}}){
            int r = dir[0] + i;
            int c = dir[1] + j;
            found = found || helper(board,word,index+1,r,c);
        }
        board[i][j] = thisIsHowYouBackTrack;
        
        
        return found;
    }
}