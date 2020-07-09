/**
 * Time: O(m*n) m,n - rows and col of the input char array board
 * Space: O(m*n)
 */
class Solution {
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public boolean exist(char[][] board, String word) {
        //DFS only ------BFS wont wrk
        if(board == null || board.length == 0) return false;
        if(word == null || word.length()==0)return true;

        int widx = 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(helper(board,word,i,j,0)) return true;
            }
        }
        return false;
    }
    private boolean helper(char[][] b, String wrd, int i, int j, int widx){
        //base
        if(widx == wrd.length()) return true;
        if(widx >= wrd.length() || i<0 || i>= b.length || j<0 || j>= b[0].length
                || b[i][j]!=wrd.charAt(widx)) return false;

        //case
        char tmp = b[i][j];
        b[i][j] = ' ';
        for(int[] dir: dirs){
            int r = i+dir[0];
            int c = j+dir[1];
            if(helper(b,wrd,r,c,widx+1)) return true;
        }
        b[i][j] = tmp;
        return false;
    }
}