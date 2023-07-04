class Solution {
    List<List<String>> result;
    int[][] dirs;
    public List<List<String>> solveNQueens(int n) {
        dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}}; // right,down,left,up
        result = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        helper(board,0);
        return result;
    }

    private void helper(boolean[][] board, int row){
        // base
        if(row == board.length){
            List<String> li = new ArrayList<>();
            for(int j = 0; j < board.length; j++){
                StringBuilder sb = new StringBuilder();
                for(int k = 0; k < board[0].length; k++){
                    if(board[j][k]){
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }

        // logic
        for(int i=0;i<board[0].length;i++){
            
            if(isSafe(board,row,i)){
                board[row][i] = true; // action
                helper(board,row+1); // recurse
                board[row][i] = false; // backtrack
            }
            
            
        }
    
    }

    private boolean isSafe(boolean[][] board, int row, int col){
        int i = row;
        int j = col;
        while(i>=0 && j>=0){
            if(board[i][j]) return false;
            i--; j--;
        }

        i = row;
        j = col;
        while(i>=0 && j<board[0].length){
            if(board[i][j]) return false;
            i--; j++;
        }

        i = 0;
        while(i<row){
            if(board[i][col]) return false;
            i++;
        }

        return true;
    }
}