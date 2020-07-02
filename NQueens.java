// Time Complexity: O(n^n/2)
// Space Complexity: O(n)

class Solution{
    int board[][];
    int m;
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if(n == 0) return result;
        m = n;
        board = new int[n][n];   //board creation
        backtrack(0);  //starting with the first row;
    }

    private void backtrack(int r){
        //base case
        if(r == m){      // last row is m-1
             List<String> li = new ArrayList<>();
             for(int i = 0 ; i < m ; i++){
                 for(int j = 0 ; j < m ; j++){
                     if(board[i][j] == 0) sb.append('.');
                     else{
                         sb.append('Q');
                     }
                 }
                 li.add(sb.toString());

             }
             result.add(li);
        }


        //logic
        for(int i = 0 ; i < m ; i++){
            if(isSafe(r,i)){
                // action
                board[i][j] = 1;  //place queen
                // recurse
                backtrack(r + 1); //recurse on next row
                // backtrack
                board[i][j] = 0; // remove queen to restore it to the original state
            }
        }
    }

    private boolean isSafe(int r, int c){
        // column
        for(int k = 0 ; k < r ; k++){
            if(board[k][c] == 1) return false;
        }
        //diagonal up to the left
        int i = r - 1 ; int j = c - 1;

        while(i >= 0 && j >= 0){
            if(board[i][j] == 1) return false;
            i--;
            j--;
        }


        //diagonal up to the right
        //diagonal up to the left
        i = r - 1 ;  j = c + 1;

        while(i >= 0 && j<m){
            if(board[i][j] == 1) return false;
            i--;
            j++;
        }

        return true;
    }
}
