// Time Complexity : O(n!)  
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result=new ArrayList<>();
        boolean[][] matrix=new boolean[n][n];
        backtrack(matrix,n,0);
        
        return result;
    }
    
    private void backtrack(boolean[][] matrix, int n, int index)
    {
        if(index==n)
        {
            List<String> temp=new ArrayList<>();
            for(int i=0;i<matrix.length;i++)
            {
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<matrix[0].length;j++)
                {
                    if(matrix[i][j])
                    {
                        sb.append("Q");
                    }
                    else
                        sb.append(".");

                }
                temp.add(sb.toString());
            }
            result.add(temp);
            return;   
        }

        
        for(int j=0;j<n;j++)
        {
            if(check(index,j,matrix))
            {
                matrix[index][j]=true;
                backtrack(matrix,n,index+1);
                matrix[index][j]=false;
            }
        }
    }
    
    private boolean check(int r,int c,boolean[][] matrix)
    {
        for(int i=r-1;i>=0;i--) 
        {
            if(matrix[i][c]) return false;
        }
        
        int i=r-1;int j=c-1;
        while(i>=0 && j>=0)
        {
            if(matrix[i][j]) return false;
            i--;
            j--;
        }
        
        i=r-1;j=c+1;
        while(i>=0 && j<matrix[0].length)
        {
            if(matrix[i][j]) return false;
            i--;
            j++;
        }
        
        return true;
    }
}