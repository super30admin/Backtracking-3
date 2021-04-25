//WORD SEARCH
//tc- O(n*3^L)
//sc- O(L)  recursive stack space of longest word at a time
//dfs and backtracking

public class Problem2 {

    public static void main(String[] args){
        Problem2 p = new Problem2();
        char board[][] = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(p.exist(board, "ABCCED"));

    }
    int row, col;
    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        for(int i = 0;i< row; i++){
            for(int j = 0;j< col; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, i, j,0, word)){
                        return true;
                    }
                }
            }
        }
        return false;
        
    }
    int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    public boolean dfs(char[][] board, int i, int j,int index, String word){
        if(index == word.length()){
            return true;
        }
        if(i <0 || j <0 || i >=row || j >= col || board[i][j] == '#'){
            return false;
        }
        //logic
        if(board[i][j] == word.charAt(index)){
            char curr = board[i][j];
            board[i][j] = '#';
            for(int[] dir : dirs){
                int new_row = i+dir[0];
                int new_col =j+dir[1];
                if(dfs(board, new_row, new_col, index+1, word)){
                    return true;
                }
            }
            board[i][j] = curr;
            
        }
        return false;
    }
    
}
