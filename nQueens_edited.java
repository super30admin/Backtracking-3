Time complexity-Exponential
Space Complexity-row^2(board)
Leetcode Submission successful
class Solution {
    private List<List<String>> result=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
       int[][]board=new int[n][n];
        placeQueen(board,0,n);
        return result;
    
    }
    
    private boolean placeQueen(int[][] board,int row, int n)
    {
        if(row==n)
        {
            List<String> temp=new ArrayList<>();
            
        for(int i=0;i<n;i++)
        {
            StringBuilder s= new StringBuilder();
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==1)
                    s.append("Q");
                else
                    s.append(".");
            }
            temp.add(s.toString());
        }
            result.add(temp);
            return false;
        }
        for(int i=0;i<n;i++)
        {
        if(isSafe(board,row,i))
        {
            board[row][i]=1;
            if(placeQueen(board,row+1,n))return true;;
            board[row][i]=0;
        }
    }
        return false;
}
    private boolean isSafe(int[][] board,int row,int col)
    {
        for(int i=0;i<row;i++)
        {
            if(board[i][col]==1)
                return false;
        }
            int r=row-1;
            int c=col-1;
            while(r>=0 && c>=0)
            {
                if(board[r][c]==1)return false;
                r--;
                c--;
            }
        r=row-1;
        c=col+1;
            while(r>=0 && c<board[0].length)
            {
                if(board[r][c]==1)return false;
                r--;
                c++;
            }
         return true;
        }
       
    }
    
