// Time Complexity : O(m*n)*3^L
//we have to traverse through the board so m*n
// and for one successful match the recusion goes into 3 directions
// sor for every word character we have 3 choices and not 4 because we eleminate the direction nwe are coming from
// Space Complexity :O(L) maximum recusrive calls ina  stack will be equal to the length of the word
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No 


// Your code here along with comments explaining your approach
class Solution {
    int [][]dirs;
    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0)
            return false;
        dirs= new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    return dfs(board,word,i,j,0);
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][]board,String word, int i, int j, int wordIdx){
        
        //base
        if(wordIdx==word.length())
            return true;
        if(i<0 ||i>=board.length||j<0||j>=board[0].length||board[i][j]=='#')
            return false;
        //logic
    
            char c=word.charAt(wordIdx);
            if(board[i][j]==c){
                //action
                board[i][j]='#';
                
                //recursion
                for(int[] dir:dirs){
                    int nr=i+dir[0];
                    int nc=j+dir[1];
                    if(dfs(board,word,nr,nc,wordIdx+1))
                        return true;
                }
                //bactracking
                board[i][j]=c;
            }
        
            return false;       
}
