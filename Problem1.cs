// Time Complexity : O(n!)
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I create a boolean matrix with dimensions n * n which represents the board. I call the Helper function with row = 0 at first.

Helper Function - 
Base Condition - 
    1. If row = n, then we have a valid solution. Traverse through each row and column of board and build it's state into a List<string> and
    add it to the final result

Core Logic - 
    1. For any given row, traverse each column. 
        1.1 Check if that particular cell is a valid position to place a queen
            1.2.1 If it is a valid position, place queen on that position (set that particular value in board to true) and call Helper
            method on next row
            1.2.2 Backtrack by removing the queen placed in the previous step. 

Logic to check if a particular cell is valid - 
    1. Check if a queen is present in the same column in the previous rows
    2. Check if a queen is present in the left diagonal starting from the position
    3. Check if a queen is present in the right diagonal starting from the position

    If any of these conditions are not satisfied, the cell is invalid. 
*/

public class Solution {
    List<IList<string>> result;
    int m;
    bool[,] board;
    public IList<IList<string>> SolveNQueens(int n) {
        result = new();
        m = n;
        board = new bool[m,m];
        Helper(0);
        return result;
    }

    public void Helper(int row)
    {
        // Base Condition
        if(row == m)
        {
            List<string> tempList = new();
            for(int i = 0; i < m; i++)
            {
                StringBuilder sb = new();

                for(int j = 0; j < m; j++)
                {
                    if(board[i,j])
                    {
                        sb.Append("Q");
                    }

                    else
                    {
                        sb.Append(".");
                    }
                }

                tempList.Add(sb.ToString());
            }

            result.Add(new List<string>(tempList));
            return;
        }

        for(int j = 0; j < m; j++)
        {
            if(isValid(row, j))
            {
                board[row,j] = true;
                Helper(row + 1);
                board[row, j] = false;
            }
        }
    }

    public bool isValid(int row, int column)
    {
        int nr, nc;

        // Column
        for(nr = 0; nr < row; nr++)
        {
            if(board[nr, column])
            {
                return false;
            }
        }

        // Diagonal Left
        nr = row;
        nc = column;

        while(nr>=0 && nc>=0)
        {
            if(board[nr, nc])
            {
                return false;
            }
            nr -= 1;
            nc -= 1;
        }

        // Diagonal Right
        nr = row;
        nc = column;

        while(nr>=0 && nc<m)
        {
            if(board[nr, nc])
            {
                return false;
            }
            nr -= 1;
            nc += 1;
        }

        return true;
    }
}