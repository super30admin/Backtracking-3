/**
 * Time Complexity: O(m*n*4^k) - k is size of word
 * Space Complexity - O(1) - no extra space except stack space
 * Idea:
 * 1. Iterate through every character and explore all four directions 
 * 2. if current character is equal to the position in word proceed further else break
 * 3. When the whole word in traversed the word is found in board
 * 
 * Leetcode: Yes
 * 
 */


class WordSearch {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(helper(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board, String word, int i, int j, int position){

        //base case 
        if(i<0 || j<0 || i>=board.length || j>= board[0].length) return false;

        if(board[i][j] == word.charAt(position)){
            char temp = board[i][j];
            board[i][j]='#';

            // word found
            if(position == word.length() -1 ){
                return true;
            }
            else {
                if(helper(board, word, i+1, j, position+1) 
                || helper(board, word, i-1, j, position+1)
                || helper(board, word, i, j+1, position+1)
                || helper(board, word, i, j-1, position+1)
                ){
                    return true;
                }
            }
            board[i][j] = temp;



        }

        return false;
    }
}

class Solution {
    public static void main(String[] args){
        System.out.println("Word Search");
        WordSearch obj = new WordSearch();
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };

        String word = "ABCB";
        System.out.println(obj.exist(board, word));
    }
}