/**
 * Time complexity:
 * O(M*3^N) where is the total number of cells in the board.
 * N is th elength of the given word.
 * We are exploring four directions at every step. But since we have marked 
 * one of them as visited the directions are reduced to 3. Now, in the worst case we
 * have to explore every cell of the board. So it is O(M*3^N).
 */


/**
 * Space complexity:
 * O(N) where N is the length of the string and the size of the stack
 * depends on it.
 */

/**
 * Backtracking Approach:
 * This is a typical example of backtracking approach.
 * In every cell of the given matrix we have to check if the given
 * letter matches with the letter of the given word. Then the next
 * letter we have to look in the adjacent cells.
 * 
 * Based on this condition we develop our solution. The first thing
 * we have to make sure is that we are not going to start until 
 * we find the first letter of the given word in the board matrix.
 * Then we have to mark each cell as visited too and later on changing
 * it back to the original character (Backtrack). Then we start looking with
 * the help of recursion in every direction. 
 */

//The code ran perfectly on leetcode

class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        if(board.size() == 0) return false;
        int r = board.size();
        int c = board[0].size();
        for(int i =0; i<r; i++){
            for(int j =0; j <c; j++){
                if(board[i][j] == word[0]){
                    if(bkTrk(board, i, j, word, 0)) return true;
                }
            }
        }
        return false;
    }
    
    private:
    bool bkTrk(vector<vector<char>>& board, int i, int j, string word, int wordIdx){
        //base
        if(wordIdx == word.size()) return true;
        if(i < 0 || j < 0 || i >= board.size()|| j >= board[0].size()) return false;
        //logic
        if(board[i][j]== word[wordIdx]){
            board[i][j] = '@';
            if(bkTrk(board, i+1, j, word, wordIdx +1 ) ||
               bkTrk(board, i-1, j, word, wordIdx +1) ||
               bkTrk(board, i, j+1, word, wordIdx +1) ||
               bkTrk(board, i, j-1, word, wordIdx +1))
            return true;
            board[i][j] =  word[wordIdx];
        }
        return false;  
    }
};