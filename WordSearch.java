// TC : O(mn*3^L)
// SC : O(mn)

package S30_Codes.Backtracking_3;

class WordSearch {
    char[][] board;
    String word;
    int n,m;

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        this.board = board;
        this.word = word;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == word.charAt(0)){
                    if(checkWord(i,j,0))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean checkWord(int i, int j, int wordIdx){
        if(wordIdx == word.length())
            return true;

        if(i < 0 || j < 0 || i>=n || j>=m)
            return false;

        if(board[i][j] == word.charAt(wordIdx)){
            board[i][j] = '#';
            boolean ans = checkWord(i,   j-1, wordIdx+1) ||
                    checkWord(i,   j+1, wordIdx+1) ||
                    checkWord(i-1, j,   wordIdx+1) ||
                    checkWord(i+1, j,   wordIdx+1);
            board[i][j] = word.charAt(wordIdx);
            return ans;
        }
        return false;
    }
}
