// Time Complexity : o(npowern)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    List<List<String>> result;
    boolean[][] board;
    public List<List<String>> solveNQueens(int n) {
        
        result=new ArrayList<>();
        
        if(n==2||n==3)
            return result;
        
        board=new boolean[n][n];
        
        helper(n,0);
        
        return result;
    }
    
    private void helper(int n,int r)
    {
        //base
        if(r == n) {
            List<String> temp = new ArrayList();

            for(int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    if(board[i][j]) {
                       sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                temp.add(sb.toString());
            }
            result.add(temp);
        }
        
        //logic
        for(int c=0;c<n;c++)
        {
            if(isSafe(r,c,n))
            {
                board[r][c]=true;
                helper(n,r+1);
                board[r][c]=false;
            }
        }
    }
    
    private boolean isSafe(int r,int c, int n) {
        //column
        for(int i = 0; i < r; i++) {
            if(board[i][c]) {
                return false;
            }
        }
        //diagonal left
        int i = r;
        int j = c;
        while(i >= 0 && j >= 0) {
            if(board[i][j]) {
                return false;
            }
            i--;
            j--;
        }

        //diagonal right
        i = r;
        j = c;
        while(i >= 0 && j < n) {
            if(board[i][j]) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}