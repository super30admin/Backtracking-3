//Time complexity-O[4^Length of the word]

class Solution {
    public boolean exist(char[][] board, String word) {
        //Creating an array to check if a particular position is already visited or not
        boolean[][] considered=new boolean[board.length][board[0].length];
        //Iterating through the array and checking if it forms the required string with its neighbours
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++){
                if(check(board,i,j,word,0,considered)) return true;
            }
        return false;
    }

    public boolean check(char[][] board,int i,int j,String word,int start,boolean[][] considered){
        // If the length of the string is reached then return true
        if(start==word.length()) return true;
        //Checking for edge conditions and already visited positions
        if(i<0||j<0||i>=board.length||j>=board[0].length||considered[i][j]||board[i][j]!=word.charAt(start)) return false;
        considered[i][j]=true;
        //Check in all the four direction of the considered position to check if the desired string is formed with its neighbours
        if(check(board,i+1,j,word,start+1,considered) || check(board,i-1,j,word,start+1,considered) || check(board,i,j+1,word,start+1,considered) || check(board,i,j-1,word,start+1,considered)) return true;
        // if not convert the visited to unvisited and return false
        considered[i][j]=false;
        return false;
    }
}