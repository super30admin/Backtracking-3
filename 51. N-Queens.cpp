/*
Time Complexity = O(!N)
Space Complexity = O(N*N)
where N is the number of rows or the number of coloumns of the matrix.
*/
class Solution {
public:
    vector<vector<bool>> grid;
    vector<vector<string>> result;
    vector<vector<string>> solveNQueens(int n) {
        bool x=false;
        for(int i=0;i<n;i++)
        {
            vector<bool> temp;
            for(int j=0;j<n;j++)
            {
                temp.push_back(x);
            }
            grid.push_back(temp);
        }
        backtrack(n,0);
        return result;
    }
    void backtrack(int n, int row)
    {
        //base
        if(row == n)
        {
            vector<string> temp;
            for(int i=0;i<n;i++)
            {   string s;
                for(int j=0;j<n;j++)
                {
                    if(grid[i][j]) s.push_back('Q');
                    else s.push_back('.');
                }
             temp.push_back(s);
            }
            result.push_back(temp);
            return;
        }
        //logic
        for(int i=0;i<n;i++)
        {
            if(issafe(n , row, i))                      //this function is checking is it safe to put the queen at that row and that coloumn.
            {
                //action
                grid[row][i] = true;
                //recurse
                backtrack(n,row+1);
                //backtrack
                grid[row][i] = false;
            }
        }
    }
    bool issafe(int n, int row, int col)
    {
        int i,j;
        //checking the upper rows.
        for(i=0;i<row;i++)
            if(grid[i][col]) return false;
        
        //check the upper left diagonals.
        i = row;
        j = col;
        while(i>=0 && j>=0)
        {
            if(grid[i][j])
                return false;
            i--;
            j--;
        }
        
        //check the upper right diagonals.
        i = row;
        j = col;
        while(i>=0 && j<n)
        {
            if(grid[i][j])
                return false;
            i--;
            j++;
        }
        return true;
    }
};
