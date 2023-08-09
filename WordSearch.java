// Time Complexity : O(m*n(3^L)) m- rows n - cols m*n (total cells) L - length of the word to be matched
// Space Complexity : O(L)  length of the word highesh stack size for recursion
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    System.out.println("start: "+ i + " "+ j);
                    if(recurse(board, word, 0, new int[] {i, j}, directions))
                        return true;
                }
                    
            }
        }


        return false;
    }

    public boolean recurse(char[][] board, String word, int index, int[] loc, int[][] dirs){
        if( word.charAt(index) != board[loc[0]][loc[1]]){
            return false;
        }
        
        if(word.length() - 1 == index){
            return true;
        }

        this.visited[loc[0]][loc[1]] = true;
        // System.out.println("path: "+board[loc[0]][loc[1]]);
        

        for(int[] dir: dirs){
            int newR = dir[0] + loc[0];
            int newC = dir[1] + loc[1];
            if(newR >= 0 && newR < board.length && newC >= 0 && newC < board[0].length && visited[newR][newC] == false){
                if(recurse(board, word, index + 1, new int[]{newR, newC}, dirs))
                    return true;
                
            }
            
        }
        this.visited[loc[0]][loc[1]] = false;
        return false;
    }
}