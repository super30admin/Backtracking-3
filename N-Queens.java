//at each row we are reducing the number of children, like in first row we have all the places for the queen 
//then in next we have n-2, 2 places will not be valid, then in next we have n-4 positions valid
//in this way n,n-1,n-2 ...its n factorial, patter is n! here.
//and then checking valid placement of cell, there will additional of checking of diagonal, and columns so O(n)
//SC-(n^2) n- recurssion stack, n- matric traverse

class Solution {
    List<List<String>> result;
    boolean[][] board;
    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        this.board = new boolean[n][n];
        helper(0,n);
        return result;
        
    }

    private void helper(int i, int n){
        //base
        if(i == n){
            List<String> path = new ArrayList<>();

            for(int r = 0; r < n; r++){
                StringBuilder sb = new StringBuilder();
                for(int c=0; c<n; c++){
                    if(board[r][c]){
                        sb.append("Q");
                    }
                    else{
                        sb.append(".");
                    }
                }
                path.add(sb.toString());
            }
            result.add(path);
            return;

        }


        //logic
        for(int j = 0; j<n; j++){
            if(isSafe(i,j,n)){
                //action

                board[i][j] = true;

                //recurssion

                helper(i+1, n);

                //backtrack

                board[i][j] = false;
            }
        }
    }

    private boolean isSafe(int i, int j, int n){
        int r = i;
        int c = j;

        while(r>=0){//all row above and same colum
        if(board[r][c]) return false;
        r--;

        }
        //top diagonal left
        r =i; c= j;
        while(r>=0 && c>=0){
         if(board[r][c]) return false;
         r--; c--;
        }

         //top diagonal right
        r =i; c= j;
        while(r>=0 && c<n){
         if(board[r][c]) return false;
         r--; c++;
        }



        return true;

    }
}
