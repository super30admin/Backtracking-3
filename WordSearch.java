// Time Complexity : O(N*3^L) where N is the number of cells in the board and L is the length of the word
// Space Complexity : O(L) Call stack space, where L is the length of the word
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// We can use a backtracking approach to solve this problem. First travers the board until we find a first character of the work. Once we find the first character we then use a dfs approach to visit nearby neighbours to check the second character of the word. While peforming the dfs, to keep track of the visited nodes we simply relace the visited elements matching the word with '#' and contiue the search. If the dfs traversal doesnot find the complete word we come back and replace '#' with the actual character, this is where we are implementing backtracking. Finally we return true if we find the word else false. 

class Solution {
    
    int m,n;
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0) return false;
        if(word==null || word.length()==0) return true;
        
        n=board.length;
        m=board[0].length;
        
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(word.charAt(0)==board[i][j]){
                    if(backtracking(board, word, 0, i, j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean backtracking(char[][] board, String word, int index, int i, int j){
        //base
        if(index==word.length()) return true;
        if(i<0 || j<0 || i>=n || j>=m || board[i][j]=='#' || board[i][j]!=word.charAt(index) ) return false;
        
        // logic
        board[i][j]='#';
        int dirs[][] = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        for(int[] dir: dirs){
            if(backtracking(board, word, index+1, i+dir[0], j+dir[1])){
                return true;
            }
        }
        board[i][j]=word.charAt(index);
        return false;
    }
   
}
