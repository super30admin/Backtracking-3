// dfs  and backtracking if we dont find match 

//TimeComplexity O(mxn * 4^L) where L is the length of word 


class Solution {
    int m ;
    int n;
    int[][] dirs; 
    public boolean exist(char[][] board, String word) {
        this.m = board.length;
        this.n = board[0].length;
        this.dirs = new int[][]{{0,1}, {0,-1}, {-1,0}, {1,0}};

        for(int i = 0 ; i< m ; i++){
            for(int j = 0 ; j <n ; j++){
               
                    if(helper(board, i , j , word, 0)) {
                        return true;
                    }
                  
                
            }
        }
        return false;
        
    }

    private boolean helper(char[][] board , int r , int c, String word , int index  ){

        if(r<0 || c < 0 || r>=m || c>= n ){ return false;}

        
        


        if(board[r][c] != word.charAt(index)){
            return false;
        }

         if(index == word.length()-1){
            return true;
        }

        board[r][c] = '#';
       

        for(int[] dir : dirs){

            int rc = dir[0] + r;

            int cc = dir[1] + c;

            if(helper(board, rc, cc, word, index+1)) {
                return true;
            }

         

        }

           board[r][c] = word.charAt(index);
           return false;




    }
}
