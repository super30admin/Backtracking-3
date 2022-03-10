class Solution {
    //o(v+e)time and o(h) space
    private int[][] dirs;
    int m; int n;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) return false;
        m =board.length; n = board[0].length;
        dirs= new int[][]{{0,1},  {1,0}, {-1,0}, {0,-1}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(backtrack(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board, String word, int i, int j, int index){

        if(i < 0 || j < 0 || i ==m || j ==n || board[i][j] == '#') return false;
        if(index == word.length()) return true;

        if(word.charAt(index) == board[i][j]){
            if(index == word.length() - 1) return true;
            char c = board[i][j];
            board[i][j] = '#';
            for(int[] dir: dirs){
                int r = dir[0] + i;
                int col = dir[1] + j;
                if(backtrack(board, word, r, col, index +1)) return true;
            }
            board[i][j] = c;
        }
        return false;
    }


    //o(2^n) exponential and o(n^2) space
    List<List<String>> result;
    boolean [][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new boolean[n][n];
        dfs(0);
        return result;
    }
    private void dfs(int row){
        //base

        if(row == board.length){
            List<String> li = new ArrayList<>();
            for(int i = 0; i < board.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < board.length; j++){
                    if(board[i][j]){
                        sb.append('Q');
                    }else {
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }
        //logic
        for(int j = 0; j < board.length; j++){
            if(isSafe(row, j)){
                //action
                board[row][j] = true;
                //recursion
                dfs(row + 1);

                //backtrack
                board[row][j] = false;
            }
        }
    }
    private boolean isSafe(int r, int c){
        //col check
        for(int i = 0; i < r ; i++){
            if(board[i][c] == true) return false;
        }

        //diagonal check
        int i = r; int j = c;
        while(i >= 0 && j >= 0){
            if(board[i--][j--] == true) return false;
        }
        int k = r; int l = c;
        while(k >=0 && l < board.length){
            if(board[k--][l++] == true) return false;
        }
        return true;
    }

}