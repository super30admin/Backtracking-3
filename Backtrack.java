//Q1:Word search
//Logic: traverse through the string and for every character traversed mark it as visited and check for characters in corresponding row and 
//column of that character.

//time Complexity :0(N x^N)
//space complexity : O(n)

class Solution {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length ; i++){
            for(int j=0;j<board[0].length;j++){
                if((board[i][j]==word.charAt(0)) && helper(board,word,i,j,0)){
                    return true;
                }
            }
        }
      return false;  
    }
    
    private boolean helper(char[][] board, String word,int i,int j, int index){
        
        if(index == word.length()){
            return true;
        }
        //boundary
        if(i< 0 || i >= board.length || j<0 || j >= board[i].length || board[i][j]!=word.charAt(index) || visited[i][j] ){
            return false;
        }
            
        visited[i][j] = true;
        //move in 4 directions
        if(helper(board,word,i+1,j,index+1) || 
        helper(board,word,i-1,j,index+1) || 
        helper(board,word,i,j+1,index+1) || 
        helper(board,word,i,j-1,index+1) ){
          return true;  
        }
        
        visited[i][j] = false;
        return false;
        
    }
    
}

//Q2)N-Queens
//Q1:Word search
//Logic: Place the first queen Q1 and the next Q2 cannot be placed in ith row, jth column and diagonal of Q1.Backtrack through the solution and
//place rest of the queens

//time Complexity :0(N 8^N)
//space complexity : O(n)
//code : still working on it