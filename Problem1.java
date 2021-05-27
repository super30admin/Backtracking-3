class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        //base case
        if(n == 0){
            return result;
        }

        //create an empty board of size n*n
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }

        //call backtracking function
        backtracking(board, n, 0);

        //return result
        return result;
    }

    private void backtracking(char[][] board, int n, int index){
        //base case -> all n queens are placed
        if(n == 0){
            List<String> list = new ArrayList<>();
            for(int i = 0; i < board.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < board[0].length; j++){
                    sb.append(board[i][j]);
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }

        //logic
        for(int j = 0; j < board[0].length; j++){
            if(isValid(board, index, j)){
                board[index][j] = 'Q';
                backtracking(board, n - 1, index+1);
                board[index][j] ='.';
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col){
        int r = row;
        int c = col;
        //upward
        while(r >= 0){
            if(board[r][c] =='Q'){
                return false;
            }
            r--;
        }

        r = row;
        //up left diagonal
        while(r >= 0 && c >= 0){
            if(board[r][c] =='Q'){
                return false;
            }
            r--;
            c--;
        }

        r= row;
        c = col;
        //up right diagonal
         while(r >= 0 && c < board[0].length){
            if(board[r][c] =='Q'){
                return false;
            }
            r--;
            c++;
        }

        return true;
    }
} 