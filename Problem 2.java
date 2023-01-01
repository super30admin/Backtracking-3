// Time Complexity : O(row * col)
// Space Complexity :O(word)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, figuring out the directions was hard


// Your code here along with comments explaining your approach in three sentences only
/*
We find the position of first letter in the board , and then we will do DFS.
*/

class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public boolean exist(char[][] board, String word) {

        // we will do DFS on the board wherever we find the first matching character to see if we find matching words

       
        char firstchar = word.charAt(0);
        boolean result = false;
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
                if(board[row][col] == firstchar){
                    Set<Pair> visited = new HashSet<Pair>();
                    visited.add(new Pair(row,col));
                    if(DFS(board,word,row,col,visited,1)){
                        return true;
                    }
                }
            }
        }
        return result;
    }

    private boolean DFS(char[][] board, String word, int row, int col, Set<Pair> visited,int idx){
        //base case
        if(idx ==word.length()){
            return true;
        }


        //logic
        // we will check if the adjacents of current is matching the next word
        if(idx < word.length()){

            for(int[] dir:dirs){
                int nr = row + dir[0];
                int nc = col + dir[1];
        
                if(nr>=0 && nc >=0 && nr<board.length && nc<board[0].length && board[nr][nc]==word.charAt(idx)){
                    Pair coords = new Pair(nr,nc);
                    if(visited.contains(coords)){
                        continue;
                    }
                    // Adding the coords to visited
                    visited.add(coords);
                    //recurse
                    if(DFS(board,word,nr,nc,visited,idx+1)){
                        return true;
                    }
                    //back tracking
                    visited.remove(coords);
                }
            }
        
        }

        return false;        
    }
}

class Pair{
    int row;
    int col;

    Pair(int r, int c){
        row = r;
        col = c;
    }

    public int hashCode(){
        return Objects.hash(row) + 10 * Objects.hash(col);

    }

    public boolean equals(Object other){
        return ((Pair)other).row == this.row && ((Pair)other).col == this.col;
    }


}