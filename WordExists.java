//Time Complexity :O(N^2*3^N)
//Space Complexity :O(1) + recursion stack.
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this :Nope


//Your code here along with comments explaining your approach
class WordExists {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board,i,j,0,word)){return true;}
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int i, int j,int index, String word){
        if(i >= 0 && j >= 0 && i < board.length && j < board[0].length && board[i][j] != '`'){
            char ch = board[i][j];
            if(ch == word.charAt(index)){
                if(index == word.length()-1){
                    return true;
                }
                board[i][j] = '`';
                if(dfs(board,i+1,j,index+1,word) || dfs(board,i-1,j,index+1,word) || dfs(board,i,j-1,index+1,word) || dfs(board,i,j+1,index+1,word)){
                    return true;
                }
                board[i][j] = ch;
            }
        }
        return false;
    }
}