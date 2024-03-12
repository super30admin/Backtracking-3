class Solution {
    List<List<String>> result = new ArrayList<>();
   boolean [][]board;
    public List<List<String>> solveNQueens(int n) {
          board = new boolean[n][n];
        backtrack(0,n);
        return result;
    }

    void backtrack(int r, int n) {
        
        if(r == n) {
           List<String> path = new ArrayList<>();
            for(int i =0; i<n;i++) {
                StringBuilder sb = new StringBuilder();
                for(int j =0; j<n;j++) {
                    if(board[i][j]) {
                      sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                path.add(sb.toString());
            }
            result.add(path);
        }
    
            for(int j =0; j<n;j++) {
                 if(isSafe(r,j,n)) {
                     board[r][j] = true;
                     backtrack(r+1,n);
                     board[r][j] = false;
            }
            
    }
    }

    boolean isSafe(int r, int c,int n) {
        //column up
        
        for(int i=0;i<r;i++) {
            if(board[i][c]) {
                return false;
            }
        }

        // diagnol up left
         int l =r;
         int m = c;
         while(l >= 0 && m >=0) {
             if(board[l][m]) {
                 return false;
             }
             l--;
             m--;
         }

         // diagnol up right
         int e =r;
          int f = c;
          while(e >=0 && f < n) {
              if(board[e][f]) {
                  return false;
              }
              e--;
              f++;
          } 

          return true; 

    }
}