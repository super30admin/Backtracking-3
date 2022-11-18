package s30.backTracking.b3;

//Algo
// start the dfs for every index
// go to all the directions and check if it matches to the word

//TC: O(mn * 3 ^l ) l being the length of the word.
//SC: O(l) for recursive stack
public class WordSearch {

    private String word;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        this.word = word;

        for( int i =0; i < m; i++){
            for(int j=0; j < n; j++){
                if(exist(board, i, j, 0)) return true;
            }
        }
        return false;
    }

    private  boolean exist(char[][] board, int row, int col, int strIndex){

        //base
        if(strIndex == word.length()){
            return true;
        }


        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;


        char ch = board[row][col];
        if(ch == word.charAt(strIndex)){

            board[row][col] = '#';
            boolean isfound =  exist(board, row + 1, col, strIndex+1)   // down
                    || exist(board, row - 1, col, strIndex+1) // up
                    || exist(board, row , col -1 , strIndex+1) // left
                    || exist(board, row , col + 1, strIndex+1); // right

            board[row][col] = word.charAt(strIndex);

            return isfound;
        }

        return false;

    }

    public static void main(String[] args) {

    }
}
