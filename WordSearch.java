// Time Complexity : O(n*3^L) where n is the board size and L is the length of the word to find.
// Space Complexity : O(L) where L is the length of the word to find.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class WordSearch {
    boolean flag = false;
    int [][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0) return false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(helper(board, i, j, word, 0)) return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, int i, int j, String word, int index){
        //base
        if(index==word.length()){
            return true;
        }
        if(i<0||j<0||i==board.length||j==board[i].length||board[i][j]=='#') return false;

        //logic
        if(board[i][j] == word.charAt(index)){
            for(int[] dir:dirs){
                int r = i + dir[0];
                int c = j + dir[1];
                //action
                board[i][j] ='#';
                //recurse
                if(helper(board, r, c, word, index+1)) return true;
                //backtrack
                board[i][j] = word.charAt(index);
            }
        }
        return false;
    }

    public static void main(String [] args){
        WordSearch ws = new WordSearch();
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(ws.exist(board, "ABCCED"));
    }
}