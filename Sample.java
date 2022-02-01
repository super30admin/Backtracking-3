// Time Complexity :O(n!)
// Space Complexity :O(n) 
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    List<List<String>> result;
    boolean board [][];
    int N;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        board = new boolean[n][n];
        N = n;
        helper(0);
        return result;
    }
    private void helper(int i){ //i = row
        //base
        //if we explore all the rows then we found result
        if(i == N){
            List<String> li = new ArrayList<>();
            StringBuilder sb;
            for(int k =0; k < N;k++){
                sb = new StringBuilder();
                for(int j =0;j<N;j++){
                    if(board[k][j]){
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
        
        //logic
        for(int j = 0;j < N;j++){
            if(isSafe(i,j)){
            //action
            board[i][j] = true;
            //recurse
            helper(i+1);
            //backtrack
            board[i][j] = false; 
            }
            
        }
    }
    
    private boolean isSafe(int r , int c){
        //row up check
        for(int i = 0;i<r;i++){
            if(board[i][c]) return false;
            //r--;
        }
        //diagnol right up
        int i = r; int j = c;
        while(i >= 0 && j < N){
            if(board[i][j]) return false;
            i--;
            j++;
        }
        i =r;j=c;
        //diagno; left up
         while(i >= 0 && j >=0 ){
            if(board[i][j]) return false;
            i--;
            j--;
        }
        return true;
    }
}
// Time Complexity :O(2 ^mn)
// Space Complexity :O(mn) 
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    int dirs[][];
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length ==0) return false;
        dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for(int i =0;i<board.length;i++){
            for(int j =0;j<board[0].length;j++){
                if(helper(board,i,j,0,word)) return true;
            }
        }
        return false;
    }
    private boolean helper(char[][] board,int i, int j,int index, String word){
        //base
        if(index == word.length()) return true;
        if(i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] == '#') return false;  
        //logic
            if(board[i][j] == word.charAt(index)){
                char ch = board[i][j];
                board[i][j] = '#';
                for(int [] dir : dirs){
                    int nr = dir[0] +i;
                    int nc = dir[1] +j;
                    if(helper(board,nr,nc,index+1,word)) return true;
                }
                board[i][j] = ch;
            }
            return false;
        }
        
        
    }

