//Time Complexity:O(N) where N is the number of cells in the board.
//Space Complexity:O(N)
//In this problem, I'll be having a dfs function, which will return true, if I can find a given word that can be formed by the sequentially adjacent cells. As I traverse through the board, I'll be checking the boundary conditions at every instant. If i have encountered a letter in the word, I'll be marking that word in the board and call the dfs functions for all 4 directions. If any of them returns true, that means I have found the word and so, I'll be returning true. Else, I'll be returning false.
//This code was executed successfully and got accepted in leetcode.

class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==word.charAt(0)&&dfs(board,0,i,j,word)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board,int count, int i, int j, String word){
        if(count==word.length()){
            return true;
        }
        if(i<0||i>=board.length||j<0||j>=board[i].length||board[i][j]!=word.charAt(count)){
            return false;
        }
        char temp=board[i][j];
        board[i][j]=' ';
        boolean found=dfs(board,count+1,i+1,j,word)||
            dfs(board,count+1,i-1,j,word)||
            dfs(board,count+1,i,j+1,word)||
            dfs(board,count+1,i,j-1,word);
        board[i][j]=temp;
        return found;
    }
}