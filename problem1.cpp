// Time Complexity : O(n!)
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Initially, we just given 'n', so we first need a matrix(2D) of type boolean filled with false.
// we then use a for loop based recurrsion over the columns of each row. we check if it is possible to place a queen on 
// that particular row,col and place it. then we backtrack to see all possibilities and store if we reach end;
// While storing we need to modify the answer to correct format.
// To check if its possible to place a queen at particular cell, we need to check there should not be any queen already placed 
// on upside of column, diagnolly left upwards, diagnolly right upwards.

class Solution {
public:
    vector<vector<string>>result;
    vector<vector<string>> solveNQueens(int n) {
        if(n==0){
            return {};
        }
        vector<vector<bool>>grid(n,vector<bool>(n,false));
        backtrack(grid,0);
        return result;
    }
    void backtrack(vector<vector<bool>>&grid, int row)
    {
        if(row == grid.size())
        {
            vector<string>v;
            for(int i = 0;i<grid.size();i++)
            {
                string s ="";
                for(int j=0;j<grid.size();j++)
                {
                    if(grid[i][j] == true)
                    {
                        s+= "Q";
                    }
                    else{
                        s+=".";
                    }
                }
                v.push_back(s);
            }
            result.push_back(v);
            return;
        }
        
        for(int i = 0;i<grid.size();i++)
        {
            if(isSafe(grid,row,i))
            {
                grid[row][i] = true;
                backtrack(grid,row+1);
                grid[row][i] = false;
            }
        }
    }
    bool isSafe(vector<vector<bool>>&grid, int row,int col)
    {
        for(int i = row;i>=0;i--)
        {
            if(grid[i][col] == true) return false;
        }
        for(int i = row,j=col;i>=0 && j>=0; i--,j--)
        {
            if(grid[i][j] == true) return false;
        }
        for(int i = row,j = col;i>=0 && j< grid.size();i--,j++)
        {
            if(grid[i][j] == true) return false;
        }
        return true;
    }
};