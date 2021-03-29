class Solution {
    
     List<List<String>> result;
  
        
        int [][] board;
        int m;
        
          public List<List<String>> solveNQueens(int n) {
              result = new ArrayList<>();
                  board = new int[n][n];
              m =n;
              bk(0);
              return result;
    }
    private void bk(int r){
        if(r==m){
            
            List<String> li =new  ArrayList<>();
            for(int i =0; i<m ; i++)
            {
                StringBuilder sb = new StringBuilder();
                for(int j =0; j<m ; j++)
                    if(board[i][j] == 1){
                        sb.append('Q');
                        
                    }
                    else{
                        sb.append('.');
                    }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }
        for(int j = 0; j < m; j++){
            if(isSafe(r,j)){
                board[r][j] = 1;
                bk(r+1);
                board[r][j]=0;
            }
        }
    }
    private boolean isSafe(int r, int c){
        for(int i =0; i< r; i++){
            if(board[i][c] == 1)
                return false;
            
        }
        int i =r; int j =c;
        while(i >=0 && j >= 0){
            if(board[i][j] == 1)
                return false;
            i--; j--;
        }
        i = r; j=c;
        while(i >=0 && j < m){
            if(board[i][j] == 1)
                return false;
            i--; j++;
        }
        return true;
    }
}