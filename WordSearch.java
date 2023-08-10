//Time Complexity = 3^l, where l is level of the tree
//Space Complexity = l
class Solution {
    int m;
    int n;
    int [][] dirs = new int [][]{{0,1},{1,0}, {-1,0}, {0,-1}};
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        for(int i =0; i<m;i++){
            for(int j =0; j<n; j++){
                if(word.charAt(0) == board[i][j]){
                    if(helper(board, word, 0, i,j)) return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int index, int i , int j){
        if(index == word.length()) return true;
        if(i<0 || j<0 || i ==m || j==n) return false;
        if(word.charAt(index)== board[i][j]){
            board[i][j]= '#';
            for(int []dir: dirs){
                int r = dir[0]+i;
                int c = dir[1]+j;
                if(helper(board, word, index+1, r ,c)) return true;
            }
            board[i][j] = word.charAt(index);
        }
        return false; 
    }
}