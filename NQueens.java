import java.util.ArrayList;
import java.util.List;

//Time Complexity: O(n!)
//Space Complexity: O(n^2)

/*
This code solves the N-Queens problem using a backtracking approach.
It recursively places queens on the board, row by row,
ensuring that no two queens can attack each other by checking the validity of
each position using the isValid function. If a valid placement is found, it moves to the next
row; otherwise, it backtracks by removing the queen and trying the next position.
Once all rows are filled, the board configuration is added to the result list.
The solution generates all possible valid arrangements of N queens on an NxN chessboard.
* */

public class NQueens {
    List<List<String>> result=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board=new boolean[n][n];
        dfs(board,0,n);
        return result;
    }

    private void dfs(boolean[][] board,int row,int n)
    {
        if(row==n)
        {
            List<String> ans=new ArrayList<>();

            for(int i=0;i<board.length;i++)
            {
                StringBuilder temp=new StringBuilder();
                for(int j=0;j<board[0].length;j++)
                {
                    if(board[i][j]==true)
                    {
                        temp.append("Q");
                    }
                    else
                    {
                        temp.append(".");
                    }
                }
                ans.add(temp.toString());
            }
            result.add(ans);
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(isValid(board,row,i))
            {
                board[row][i]=true;
                dfs(board,row+1,n);
                board[row][i]=false;
            }
        }
    }
    private boolean isValid(boolean[][] board,int row,int col)
    {
        int n=board.length;
        int r=row;
        int c=col;
        while(r>=0)
        {
            if(board[r][c]==true)
                return false;
            r--;
        }
        r=row;
        while(r>=0 && c>=0)
        {
            if(board[r][c]==true)
                return false;
            r--;
            c--;
        }

        r=row;
        c=col;
        while(r>=0 && c<n)
        {
            if(board[r][c]==true)
                return false;
            r--;
            c++;
        }
        return true;
    }
}
