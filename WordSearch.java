
class WordSearch {
    // Approach - Backtracking
    // Time complexity - O(4^n)
    // Space complexity - O(m+n) where m is row and n is col
    // Tested in leetcode
    
    //iterate through each character of matrix, if matches with starting character of given string, recurse through all four valid direction to find out the           complete string.
    // If at any time character is not matching undo the recent move till character is matching and start recursing into the different direction.
    // If complete metrix cell is exhausted and word is not matched, return false.
    
    /**
    Pseudo Code
    1 . Loop through the element of matrix, if character is equal to the start character of the given string
        a) start recursion in one direction out of valid directions.
        b) if next character is not matched, undo the previous choice and look for character in next valid direction.
    2. recurse and traverse till all characters of string are found sequentially and return true.
    3. If complete matrix is exhausted and word is not found return false.
    
    
    **/
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(helper(board,word,i,j,0))
                    return true;
            }
        }
        return false;
    }
    
    public boolean helper(char[][] board, String word,int row, int col,int index){
        if(index == word.length())
            return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length)
            return false;
        if(board[row][col] == word.charAt(index)){
            char c = board[row][col];
            board[row][col] = '#';
            if(helper(board,word,row+1,col,index+1) || helper(board,word,row,col+1,index+1) || helper(board,word,row,col-1,index+1) || helper(board,word,row-1,col,index+1))
                return true;
            board[row][col] = c;
            index = index --;
 
        }
        return false;
    }  
}