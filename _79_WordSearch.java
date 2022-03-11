// Time Complexity : o(n^2))*n where n is length of string as at eevry step we have two choices to choose or not
// Space Complexity : o(n*n)) length of recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// For every cell in frid, we need to call dfs which  will serach the word in its neighbors by going to dfs path
class Solution {

    boolean res = false;

    int[] xArr = {-1,1,0,0};
    int[] yArr = {0,0,-1,1};

    public boolean exist(char[][] board, String word) {
        res = false;
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i=0; i<board.length; i++ ){
            for(int j=0; j<board[0].length; j++ ){
                visited[i][j] = true;
                dfs(board, word, i,j,0, visited);
                visited[i][j] = false;
                if(res) return res;
            }
        }
        return res;
    }

    public void dfs(char[][]board, String word, int x, int y, int index, boolean[][] visited){

        if(res) return;

        if(board[x][y] != word.charAt(index)) return;

        if(index == word.length()-1){
            res = true;
            return;
        }

        for(int i=0; i<xArr.length; i++){

            int xNew = x + xArr[i];
            int yNew = y + yArr[i];

            if(xNew >= 0 && xNew<board.length && yNew >=0 && yNew<board[0].length
               && !visited[xNew][yNew] ){
                visited[xNew][yNew] = true;
                dfs(board, word, xNew, yNew, index+1, visited);
                visited[xNew][yNew] = false;
            }
        }


    }
}
