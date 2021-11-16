class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length() > board.length * board[0].length)
            return false;
        boolean visited[][] = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(helper(board, word, 0, i, j, visited))
                    return true;
            }
        }
        return false;

    }
    public boolean helper(char[][] board, String word, int index, int i, int j, boolean[][] visited){
        if(index==word.length())
            return true;
        boolean res;
        if(i>=0 && i<board.length && j>=0 && j<board[0].length && board[i][j] == word.charAt(index) && ! visited[i][j]){
            visited[i][j] = true;
            res = helper(board, word, index+1, i+1, j, visited) || helper(board, word, index+1, i-1, j, visited) || helper(board, word, index+1, i, j+1, visited)|| helper(board, word, index+1, i, j-1, visited);
            visited[i][j] = false;
            return res;
        }
        return false;
    }
}