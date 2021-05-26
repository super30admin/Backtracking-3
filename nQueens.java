import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n!)
// Space Complexity :O(n*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class nQueens {
    List<List<String>> result;    
    int [][] board;
    public List<List<String>> solveNQueens(int n) {
         result=new ArrayList<>();
        board =new int[n][n];
        backtrack(0,n);
        
    return result; 
        
    }
    
    private void backtrack(int r, int n){
        //base 
        if(r==n){
            List<String> li=new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<n;j++){
                    if(board[i][j]==1){
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
            
        }
        
        //logic
        
        for(int c=0;c<n;c++){
            if(isSafe(r,c,n)){
                board[r][c]=1;
                backtrack(r+1,n);
                board[r][c]=0;
            }
        }
    } 
    
    private boolean isSafe(int r, int c,int n){
        
        //column up
        for(int i=0;i<r;i++){
            if(board[i][c]==1)
                return false;
        }
        
        //diagonal up right
        int i=r; int j=c;
        while(i>=0 && j<n){
            if(board[i][j]==1)
                return false;
            i--;j++;
        }
        
        //diagonal up left
         i=r; j=c;
        while(i>=0 && j>=0){
            if(board[i][j]==1)
                return false;
            i--;j--;
        }
        
        return true;
    }
    
}

