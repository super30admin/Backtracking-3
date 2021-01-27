//Problem : 75 - Word Search 1
// Time Complexity : O(m*n)*word.length | Suppose starting element is the last element and then there are several similar paths but exact path is only 1 which is from last element to first element. 
// Space Complexity : O(1), not considering recursion stack; | for recursive stack O(word length)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

 //As we have to find the path matching the given string, thus we have to traverse connected components so DFS. 
/* 1) Brute force : TC:O((m*n)*word length) | SC:O(m*n) for visted node array + O(word length) for recursive stack.  
                  Create visited array to keep track which nodes visited while doing dfs. Before executing the dfs mark that node as visited. While coming back from the dfs reverse the action of visited to not visited. If path is found then just return true.
   
   2) Optimal Space Complexity : //TC: O(m*n)*word.length || SC:O(1), not considering recursion stack; | for recursive stack O(word length)
                Before executing the dfs save that node element in some temp variable. Update that node to some other character so that it will give us an idea that it is visted. While coming back from the dfs reverse the action of visited to not visited, by updating the visited element to the temp variable value. If path is found then just return true.
                
    Note : Here visted is required because of the case : 
    [
     ["C","A","A"],
     ["A","A","A"],
     ["B","C","D"]
     ]
     | String to found "AAB".
     
     If I will mark "A" at row 1 and col 0 as visited then I cannot get AAB from row 1->col 1-> col 0 and then row 2->col 0

*/


class Solution75 {
    
    public boolean exist(char[][] board, String word) {
       
        //TC: O(m*n)*word.length || SC:O(1), not considering recursion stack; | for recursive stack O(word length)
        
        if(board==null || board.length==0 || word==null || word.length()==0) return false;
       
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                
                if(board[i][j]==word.charAt(0)){
                    char tempChar = board[i][j];
                    
                    board[i][j] = '.';//action
                    
                    boolean found = dfs(board,i,j,word,1);//recursive//start word search from 1st| this word_curr_idx way will help in preventing substring
                    
                    board[i][j] = tempChar; //backtrack
                    
                    if(found) return true;
                    
                }
                
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board,int i, int j,String word,int word_curr_idx){
     
        if(word_curr_idx==word.length()) return true;
        
        boolean found = false;//not a global variable i.e I have to initialise it
        
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        
        for(int[] dir: dirs){
            
            int r = i+dir[0];
            int c = j+dir[1];
            
            if(r>=0 && c>=0 && r<board.length && c<board[0].length && board[r][c]==word.charAt(word_curr_idx)){
                
                char tempChar = board[i][j];
                
                board[i][j] = '.';//action
                
                found = dfs(board,r,c,word,word_curr_idx+1);//recursive
                
                board[i][j] = tempChar;//backtrack
                
                if(found) return true;
            }
            
        }
      
        return found;
    } 
    
}