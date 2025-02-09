class Solution {
    //Time Complexity:O(n*m*(4^l)
    //Space Complexity:O(1)
    public boolean exist(char[][] board, String word) {
        if (board.length == 0)        {
            return false;
        }
        int n = board.length;
        int m = board[0].length;
        for (int i = 0;i < n;i++){
        for (int j = 0;j < m;j++){
            if (board[i][j] == word.charAt(0)){
                if (recurse(board, i,j,0 ,word))
                return true;
            }
            
        }
    }
    return false;
}
    private boolean recurse (char[][] board, int i, int j, int index, String word){
        //base case
        if (index == word.length()){
            return true;
        }
        //logic
        if (i >=0 && i < board.length && j>=0 && j < board[0].length && board[i][j] != '#' && board[i][j] == word.charAt(index)){
            char temp = board[i][j];
            board[i][j] = '#';
            boolean ans = recurse(board,i-1,j,index+1,word) || recurse(board,i+1,j,index+1,word) || recurse(board,i,j-1,index+1,word) || recurse(board,i,j+1,index+1,word);
           board[i][j] = temp; 
           return ans;
        }
return false;
    }
}
