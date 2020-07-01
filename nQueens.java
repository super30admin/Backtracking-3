//time complexity O(n!)
//space complexity O(n)

class Solution {
    int m; int[][] board;
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new int[n][n];
        m = board.length;
        placequeens(0);
        return result;
    }

    private void placequeens(int i){
        //base
        if(i == m){
            List<String> li = new ArrayList<>();
            for(int r = 0; r < m; r++){
                StringBuilder sb = new StringBuilder();
                for(int c = 0; c < m; c++){
                    if(board[r][c] == 1){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
        }

        //logic
        for(int j = 0; j < m; j++){
            if(isSafe(i, j)){
                board[i][j] = 1;//action
                placequeens(i+1);//recurse
                board[i][j] = 0;//backtrack
            }
        }
    }
    private boolean isSafe(int i,int j){
        //up
        for(int k = 0; k < i; k++){
            if(board[k][j] == 1) return false;
        }

        //diag up left
        int r = i - 1; int c = j - 1;
        while(r >= 0 && c >= 0){
            if(board[r][c] == 1){
                return false;
            } else{
                r--; c--;
            }
        }

        //diag up right
        r = i - 1; c = j + 1;
        while(r >= 0 && c < m){
            if(board[r][c] == 1){
                return false;
            } else{
                r--; c++;
            }
        }
        return true;
    }
}
