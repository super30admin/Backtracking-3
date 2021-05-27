// Time Complexity :O(m*n*(4^N))-> O(4^N), m=num of rows, n=num of columns, N=word length
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class WordSearch {
    public boolean exist(char[][] board, String word) {
        //if word is empty
        if(word.length()==0 || word==null) return true;
        //if board is empty
        if(board.length==0||board[0].length==0) return false;
        //get max row and col of board
        int m = board.length;
        int n = board[0].length;
        //looping through the board
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                //call backtrack method
                if(backtrack(board, word, i, j,0)){
                    //if word found
                    return true;
                }
            }
        }
        //if word not found
        return false;
    }
    //method to check if a word exists
    public boolean backtrack(char[][] board, String word, int i, int j, int index){

        //base
        //
        if(word.length() == index) return true;
        // if row and colum not in the bounds
        //if character at current index is not same as character at current row and column of board
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!=word.charAt(index)) return false;

        //logic
        //store the current character
        char temp = board[i][j];
        //update board to mark visited
        board[i][j]='#';
        //array to loop through four direction
        int[][] dirs =  {{-1,0}, {0,1}, {1,0}, {0,-1}};
        //looping through all neighbor nodes
        for(int k=0; k<dirs.length; k++){
            //next neighbour
            int r = dirs[k][0] + i;
            int c = dirs[k][1] + j;
            //backtrack for neighbour
            if(backtrack(board, word, r,c, index+1)){
                //if word found
                return true;
            }


        }
        //backtrack
        //undo the changes
        board[i][j]=temp;

        //if word not found
        return false;
    }
}