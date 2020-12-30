/*
Time Complexity : Exponential
Space Complexity :  O(Length of word)
Do a dfs search from the first word matched and backtrack if it does not lead to the word.
*/
class Solution {
    int row;
    int col;
    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        boolean[] visited = new boolean[row*col+1];;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                 if(board[i][j] == word.charAt(0)){
                     if(backtrack(board,i,j,word,visited,0)){
                         return true;
                     }
                 }
            }
        }
        return false;
    }
    
    public boolean backtrack(char[][] board, int i,int j,String word,boolean[] visited,int index){
        if(index == word.length()){
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j >=board[0].length || word.charAt(index)!= board[i][j] || visited[i*col+j]){
            return false;
        }
        visited[i*col+j] = true;
        boolean val = backtrack(board,i+1,j,word,visited,index+1) || backtrack(board,i-1,j,word,visited,index+1)
            || backtrack(board,i,j+1,word,visited,index+1)
            || backtrack(board,i,j-1,word,visited,index+1);
        visited[i*col+j] = false;
        return val;
    }
}