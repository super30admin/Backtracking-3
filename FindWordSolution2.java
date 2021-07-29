//Time Complexity : O(M*N*3^L), M -> No. of rows, n -> No of columns, l -> Length of word to search
//Space Complexity : O(L)
class Solution {
    int[][] dist = {{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        int m= board.length;
        int n=board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] != word.charAt(0)) {
                    continue;
                }
                if(findWord(board,word,i,j,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean findWord(char[][] board, String word, int i, int j, int indexWord) {

        int m= board.length;
        int n= board[0].length;
        if(indexWord == word.length()){
            return true;
        }
        if(i<0 || j<0 || i>=m || j>=n || board[i][j] != word.charAt(indexWord))
            return false;

        char temp = board[i][j];
        board[i][j] = '*';

        for(int x=0;x<dist.length;x++){
            int row=i+dist[x][0];
            int col=j+dist[x][1];
            if(findWord(board,word,row,col,indexWord+1)){
                return true;
            }
        }

        board[i][j]=temp;
        return false;
    }
}