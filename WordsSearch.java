//Brute Force
class Solution {
    public boolean exist(char[][] board, String word) {
        int n = word.length();
        int count = word.length();
        for(int row = 0;row<board.length;row++){
            for(int col = 0; col <board[0].length;col++){
                int i =0;
                if(i< n && word.charAt(i) == board[row][col] && board[row][col] != '.'){
                    i++;
                    count--;
                    board[row][col]='.';
                
                }
            }
        }
        if(count ==1)return true;
        else return false;
    }
}
