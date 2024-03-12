// Time Complexity : n* n!, n = length of matrix, exploring all the options.O(n) time extra for checking if it is safe to place the queen.
// At each row we have n n-2 , n-4, n-6 .... and so on options
// Space Complexity n*n, to maintain boolean map
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Explore all paths along with backtracking.


class Solution {
    List<List<String>> result;
    boolean[][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();

        board = new boolean[n][n];
        backtrack(0,n);

        return result;
    }

    private void backtrack(int r , int n){
        //base: all queens placed.
        if(r == n){
            System.out.println(result.size());
            List<String> li = new ArrayList<>();
            for(int i = 0 ; i < n ; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n ; j++){
                    if(board[i][j]){
                        sb.append("Q");
                    }
                    else{
                        sb.append(".");
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }
        
        //logic
        for(int c = 0 ; c < n ; c++){
            if(isSafe(r,c,n)){// move to next row as soon as we find a placement
                //action
                board[r][c] = true;
                //recurse
                backtrack(r+1,n);
                //backtrack
                board[r][c] = false;
            }
        }
    }

    // check directions up, up right, up left to see if queen is already in the path
    private boolean isSafe(int r, int c, int n){
        // up check
        for(int i = 0 ; i < r ; i++){
            if(board[i][c]){ // queen is present
                return false;
            }
        }

        //up left
        int i = r; int j = c;
        while(i >= 0 && j >= 0){
            if(board[i][j]){
                return false;
            }
            i--; j--;
        }

        //up right
        i = r;  j = c;
        while(i >= 0 && j < n){
            if(board[i][j]){
                return false;
            }
            i--; j++;
        }

        return true;// no queen found
    }
}