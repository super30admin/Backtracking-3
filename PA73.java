//Leetcode: 79. Word Search
//Time Complexity: O(N*4^L) where N is the size of board and L is the length of the word
//Space Complexity: O(L) L is the length of the word
class Solution {

    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        if(word==null) return true;
        dirs=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        for(int i=0; i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    
                    if(helper(board,i,j,0,word)) return true; 
                }
            }
        }
              
          return false;    
    }          
         
        public boolean helper(char[][] board,int i, int j,int index, String word){
            if(index==word.length()) return true;
            if(i<0 || j>=board[0].length || j<0 || i>=board.length || board[i][j]=='#') return false;
            if( board[i][j] == word.charAt(index)){         
                     board[i][j] ='#';
                     for(int[] dir : dirs){
                        int r= i+dir[0];
                        int c= j+dir[1];
                       
                            if(helper(board,r,c,index+1,word)) return true;
      
                         }
                    board[i][j] =word.charAt(index);  
            }
            return false;
       
        }
}