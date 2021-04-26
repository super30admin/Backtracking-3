//Time Complexity:O(m*n* 3^n) n is the length of word
//Space Compexity:O(n) n is the length of word
class Solution {
    public boolean exist(char[][] board, String word) {

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(helper(board,word, i,j,0)) return true;
            }
        }
    return false;
    }
    
    private boolean helper(char[][] board, String word, int i, int j,int index){
        //base
        if(index==word.length()) return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]=='#'){return false;}
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        //logic
        if(board[i][j]==word.charAt(index)){
            //storing value to replace it back
            char temp=board[i][j];
            board[i][j]='#';
            for(int[] dir:dirs){
                int r= i+dir[0];
                int c =j+dir[1];
                if(helper(board,word, r, c, index+1)==true) return true;
            }
            //replacing back
            board[i][j]=temp;
        }
        return false;
    }
}