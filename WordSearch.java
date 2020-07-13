class Solution {
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
           
         m = board.length;
         n = board[0].length;
        for(int i = 0 ;i < m ;i++){
            for(int j = 0;j <n ;j++){
            if(backtrack(board,word,i,j,0)) {
                return true;
        }}}
        return false;
    }
    
    private boolean backtrack(char[][]board ,String word ,int i ,int j ,int index ){
        
       
        //base condition 1:
         if(index==word.length()) return true;
        //base condition 2:
        if(i<0 || j<0 || i== m || j == n || board[i][j]=='#'){
            return false;
        }
        
      /**  if(index==word.length()) return true; // exit condition imp to avoid string out of bounds exception */
        
        if(word.charAt(index)== board[i][j]){
             int[][]dirs = {{0,1},{0,-1},{-1,0},{1,0}};
            //action
            char temp = board[i][j];
             board[i][j] = '#' ; //visited        
            //recurse
              for(int[] dir : dirs){
                  int r = i +dir[0];
                  int c = j + dir[1];
              
                 if( backtrack(board,word,r,c,index+1)) { return true;} 
              }  //closing the dirs array to complete the backtrack important
            //backtrack
              board[i][j] = temp;
        }
         return false;   
    }
        
}

/*
TimeComplexity: O(mxn)* 3^L  mxn is the matrix visited and L is length of string choosen over the 3 directions
SpaceComplexity:O(mxn
*/