import java.util.*;

public class Backtracking {
    //time complexity : n!
    // space complexity : n^2
    // did it run on leetcode : yes
    // any doubts : no
    //https://leetcode.com/problems/n-queens/submissions/
    //N-queens
    List<List<String>> result;
    boolean[][] board;
    public List<List<String>> solveNQueens(int n) {        
        result = new ArrayList<>();
        board = new boolean[n][n];
        backtrack(0);
        return result;
        
    }
    private void backtrack(int r){
        if(r==board.length){
            List<String> li = new ArrayList<>();
            for(int i =0;i<board.length;i++){
                StringBuilder sb = new StringBuilder();                
                for(int j =0;j<board.length;j++){
                    if(board[i][j]==true){
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
            return;
        }
        for(int i =0;i<board.length;i++){
            if(ispossible(r,i)){
                board[r][i]= true;
                backtrack(r+1);
                board[r][i] = false;
            }
        }
    }
    
    private boolean ispossible(int r,int c){
        
        // top
        for(int i=0;i<r;i++){
            if(board[i][c]){
                return false;
            }
        }
        
        //left diagonal
        int m= r;
        int n = c;
        while(m>=0 && n>=0){
            if(board[m][n]){
                return false;
            }
            m--;
            n--;
        }
        
        //right diagonal
         m= r;
         n = c;
        while(m>=0 && n<board.length){
            if(board[m][n]){
                return false;
            }
            m--;
            n++;
        }
        
        return true;
    
    }
    //time complexity : (m*n)3^L (length of word)
    // space complexity : length of word
    // did it run on leetcode : yes
    // any doubts : no  

    int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(backtrack(board,i,j,word,0)) return true;
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board,int r,int c,String word,int index){
        //base condition
        if(index == word.length()){
            return true;
        }
        if(r<0 || c <0 || r>= board.length || c >= board[0].length) return false;
        // logic
        if(board[r][c]== word.charAt(index) ){
            char ch = board[r][c];
            board[r][c]='#';
            for(int[] dir: dirs){
               int nr = r+dir[0];
               int nc = c+dir[1];
               if(backtrack(board,nr,nc,word,index+1)) return true; 
            }
            board[r][c]=ch;
        }
        return false;
    }
}
