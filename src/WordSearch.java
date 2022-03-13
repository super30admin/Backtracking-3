// Time Complexity:           O((3^l)*(m*n))
// Space Complexity:          O(l)
// where l is length of word
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        SolutionWordSearch obj = new SolutionWordSearch();
        System.out.println(obj.exist(board, word));
    }
}

class SolutionWordSearch {

    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(exist(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int i, int j, int wordIndex) {
        if(wordIndex == word.length())
            return true;

        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] == '#')
            return false;

        if(board[i][j] == word.charAt(wordIndex)) {

            // ACTION
            board[i][j] = '#';

            // RECURSION
            boolean found = exist(board, word, i, j-1, wordIndex+1)
                    || exist(board, word, i, j+1, wordIndex+1)
                    || exist(board, word, i+1, j, wordIndex+1)
                    || exist(board, word, i-1, j, wordIndex+1);

            // BACKTRACKING
            board[i][j] = word.charAt(wordIndex);

            return found;
        }
        return false;
    }
}


//// ****************************** Another Approach ******************************
//class SolutionWordSearch {
//
//    int[][] directions = {
//            {0,-1}, // LEFT
//            {0,1},  // RIGHT
//            {1,0},  // DOWN
//            {-1,0}  // UP
//    };
//
//    public boolean exist(char[][] board, String word) {
//        for(int i=0; i<board.length; i++) {
//            for(int j=0; j<board[0].length; j++) {
//                if(exist(board, word, i, j, 0))
//                    return true;
//            }
//        }
//        return false;
//    }
//
//    private boolean exist(char[][] board, String word, int i, int j, int wordIndex) {
//        if(wordIndex == word.length())
//            return true;
//
//        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] == '#')
//            return false;
//
//        if(board[i][j] == word.charAt(wordIndex)) {
//
//            // ACTION
//            board[i][j] = '#';
//
//            // RECURSION
//            for(int[] dir : directions) {
//                int newI = i + dir[0];
//                int newJ = j + dir[1];
//                if(exist(board, word, newI, newJ, wordIndex+1))
//                    return true;
//            }
//
//            // BACKTRACKING
//            board[i][j] = word.charAt(wordIndex);
//
//        }
//        return false;
//    }
//}