/*
Time Complexity -  O(N * 3 ^ W) Visualize the board as a n-ary, at each step in the board, we have three options(direction) to move to. Fourth direction is 
                    omitted as it is same as going back to prev state. We proceed in this manner until 'W' steps in the worst case where each step matches with 
                    the word which is the length of the word. 
                    Hence O(3 ^ W).
                    O(N) to find a position where the char matches the first letter of the word.
        Total   -   O(N * 3 ^ W)
Space Complexity - O(W) where W is the length of input string "word" which represents the max depth upto which the recursive stack could grow.
*/
class Solution {
    public boolean exist(char[][] board, String word) {
        
        if(word == null || word.length() == 0) return true;
        if(board == null || board.length == 0) return false;

        int strLen = word.length();
        int rowLen = board.length;
        int colLen = board[0].length;

        if(strLen > rowLen * colLen) return false;

        boolean[][] visited = new boolean[rowLen][colLen];
        for(int i = 0; i < rowLen; i++)
            for(int j = 0; j < colLen; j++)
                if(board[i][j] == word.charAt(0) && search(board, i, j, word, 0, visited))
                        return true;
        return false;
    }

    public boolean search(char[][] board, int rowIndex, int colIndex, String word, int strIndex, boolean[][] visited) {

        if(strIndex == word.length())
            return true;

        if(rowIndex < 0 || colIndex < 0 || rowIndex >= board.length || 
              colIndex >= board[0].length || visited[rowIndex][colIndex] == true || 
                    board[rowIndex][colIndex] != word.charAt(strIndex))
            return false;
        
        visited[rowIndex][colIndex] = true;

        if(search(board, rowIndex - 1, colIndex, word, strIndex + 1, visited) ||
            search(board, rowIndex + 1, colIndex, word, strIndex + 1, visited) ||
                search(board, rowIndex, colIndex - 1, word, strIndex + 1, visited) ||
                    search(board, rowIndex, colIndex + 1, word, strIndex + 1, visited))
                    return true;
        visited[rowIndex][colIndex] = false;
        return false;
    }
}
