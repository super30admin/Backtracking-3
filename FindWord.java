 //Time Complexity : Exponential TC
//Space Complexity : O(L) L:length of word
class Solution {
    public boolean exist(char[][] board, String word) {

        int m= board.length;
        int n=board[0].length;
        boolean result= false;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(findWord(board,word,i,j,0))
                    result= true;
            }
        }
        return result;
    }

    private static Boolean findWord(char[][] board, String word, int i, int j, int k) {

        int m= board.length;
        int n=board[0].length;

        if(i<0 || j<0 || i>=m || j>=n)
            return false;

        if(board[i][j]== word.charAt(k)){
            char temp= board[i][j];
            board[i][j]='*';
            if(k == word.length()-1){
                return true;
            }else if(findWord(board,word,i-1,j,k+1)||
                    (findWord(board,word,i+1,j,k+1))
                    ||(findWord(board,word,i,j-1,k+1))||
                    (findWord(board,word,i,j+1,k+1))){
                return true;
            }
            board[i][j]=temp;
        }
        return false;
    }
}