// Time Complexity :O(m*n*4^L) L: Length of word
// Space Complexity :O(L)
// Did this code successfully run on Leetcode :yes
class Solution {
    int m,n;
    int direction[][];
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        direction = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        for(int i=0;i<m;i++){//loop through all cells(i,j)
            for(int j=0;j<n;j++){
                if(board[i][j] == word.charAt(0)){//if (i,j) has 1st character of the word
                if(helper(board,word,i,j,0)) return true;
                //if we find a successful dfs, return true
                }
            }
        }
        return false;
    }
    private boolean helper(char[][] board,String word,int i,int j,int index){
        if(index == word.length()) return true;//reached end
        if(i < 0 || j < 0 || i == m || j == n || board[i][j] == '#') return false;//if out of grid or cell is already visited
        if(board[i][j] != word.charAt(index)) return false;//wrong path
        //mark as visited and move to find next index
        board[i][j] = '#';
        for(int[] dir: direction){
            int r = dir[0] + i;
            int c = dir[1] + j;
            if(helper(board,word,r,c,index+1)) return true;
        }
        board[i][j] = word.charAt(index);//unmark
        return false;
    }
}