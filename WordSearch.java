/*
Time Complexity: O(N*M*word.length()), N is the number of rows, M is the number of columns
Space Complexity: O(word.length()), need to search each and every character of given string word
Run on leetcode: yes
Any difficulties: no
Approach:
1. I am using dfs to traverse the given board
2. Whenever I encounter a character which matches the character given in the string word, I am gonna make it '#' first
and gonna traverse all the four (up, down, right, left) directions and would increment in the index of the word too,
Once I will found the exact match for the word, I am gonna return true, otherwise false

 */
public class WordSearch {
    public static boolean wordSearch(char[][]board, String word){
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(traverseBoard(board, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean traverseBoard(char[][] board, int row, int col, String word, int strIndex){
        if(row<0 || col<0 || row>=board.length || col>=board[0].length ){
            return false;
        }

        if(board[row][col] == word.charAt(strIndex)){
            char temp = board[row][col];
            board[row][col]= '#';
            if(strIndex == word.length()-1){
                return true;
            }else if (
                    traverseBoard(board, row+1, col, word, strIndex+1)
                    || traverseBoard(board, row-1, col, word, strIndex+1)
                    || traverseBoard(board, row, col+1, word, strIndex+1)
                    || traverseBoard(board, row, col-1, word, strIndex+1)
            ){
                return true;
            }
            board[row][col] = temp;

        }
        return false;
    }

    public static void main(String[] args){
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        System.out.println(wordSearch(board, "ABCCED"));
    }
}
