    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/word-search/
    Time Complexity for operators : o(n*3^n) .. n is the length of the string
    Extra Space Complexity for operators : o(1)  without recursive stack
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. Backtracking
                    A) First check all the starting points start with first letter of word and theen do 
                       backtracking on it.
                    B) In backtracking, base case will be check if index is greater than word.length()
                       that means we reached end return true;
                    C) in for loop, ravswrse in all the four directions and check if matches with the next word in the wors string
                    D) if it matches then again do backtracking on it till we found next element
                    E) if we find the element return true else at the end return false;
                    F) in main function return true if backtracking return true else return flase in the end.
    */  


class wordSearch {
    public boolean exist(char[][] board, String word) {
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0))
                    if(backtracking(board,word,0,i,j))
                        return true;
            }
        }
        return false;
    }
    
    int[] []  directions = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public boolean backtracking(char[][] board, String word, int index,int i, int j){
        if(index>=word.length()-1){
            return true;
        }
        
        char temp = board[i][j];
        board[i][j] = '#';
        
        for(int[] dirs : directions){
            int r = i + dirs[0];
            int c = j + dirs[1];
            
            if(r>=0 && r< board.length && c>=0 && c<board[0].length && (index+1<word.length()) && word.charAt(index+1)==board[r][c]){
                if(backtracking(board,word,index+1,r,c))
                    return true;
            }
        }
        
        board[i][j] = temp;
        
        return false;
    }
}