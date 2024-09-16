// Time Complexity : O(mX n)  
// Space Complexity :   O(1). no extra space. with recursive stack is O(m X n).  
// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//the code uses recursion plus backtracking. The code follows the pattern action, recursion and backtrack. if we find the word we stop and 
// return true, otherwise we keep moving until end of matrix and return false; 
//Success
//Details 
//Runtime: Runtime: 5 ms, faster than 80.57% of Java online submissions for Word Search.
//Memory Usage: 42 MB, less than 23.47% of Java online submissions for Word Search.
class Solution {
     int[][] dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public boolean exist(char[][] board, String word) {
        if (board==null || board.length==0 || word==null || word.length()==0)
          return false;
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
               if (board[i][j]==word.charAt(0)){
                   if (backtracking(board,word,0,i,j))
                       return true;
               }
            }
        }
        return false ;
    }
    
    private boolean backtracking(char[][] board, String word, int ind,int i , int j){
        //base case
        if (ind==word.length()-1)
            return true;
        
        char tmp= board[i][j];
        board[i][j]='#';
        for (int [] dir:dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            
            if (r>= 0 && r< board.length && c >=0 && c<board[0].length && (ind+1 < word.length()) && (word.charAt(ind+1)==board[r][c])){
               if (backtracking(board,word,ind+1,r,c)){
                   return true;
               }                
            }      
        }
        board[i][j]=tmp;
        return false;
    }
    
   
    
}