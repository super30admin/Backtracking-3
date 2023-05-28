// TC (Time Complexity): O(N!)
// SC (Space Complexity): O(N^2) for matrix


// Here as grid is not given we take a grid of size n*n

// Place a queen at 1st col in 1st row and then move onto next row
// And check for suitable position in next row if we find suitable move on to next row using recursive call,if we dont find suitable location
// backtrack on to previous row and move position from 1st to next col 
// In this way if a suitable arrangemet is found add it to results;

class Solution {
public:
    vector<vector<string>>results;
   
    vector<vector<string>> solveNQueens(int n) {

        vector<vector<bool>>grid(n, std::vector<bool>(n));
        if(n==0) 
        return results;

        backtrack(0,grid);

        return results;   
    }

    void backtrack(int row,vector<vector<bool>>&grid)
    {
        // base
        if(row==grid.size())
        {
            // As we took a boolean grid in result it asked to return a list<list<strings>> so converting into it
            vector<string>final;
            for(int i=0;i<grid.size();i++)
            {
                string a="";
                for(int j=0;j<grid.size();j++)
                {
                     if(grid[i][j]==1)
                     a+='Q';
                     else
                     a+='.';
                }
                final.push_back(a);
            }
            results.push_back(final);
            return;
        }

        // logic--for loop based recursion
     
        for(int i=0;i<grid[0].size();i++)
        {
           // iterating on columns of row to place a queen ,checking is it safe to place a queen at that particular column   
             if(isSafe(row,i,grid))
             {
         //  if it is safe we place the queen and then we move on to next row by calling the recursive function on next row;              
                //  ACTION
                  grid[row][i]=1;
                //   RECURSE
                  backtrack(row+1,grid);
                //   BACKTRACK
                 grid[row][i]=0;
             }   
        }
    }

    bool isSafe(int row,int col,vector<vector<bool>>&grid)
    {
        // A good position for queen is the one in which there is no queen present in the "upper columns |" and "upper right diagonal /" and "upper left diagonal \"

        // checking for UPPER column
        for(int i=row;i>=0;i--)
        {
            if(grid[i][col]==1)
            return false;
        }
        

        // checking Upper left 
        int i=row;
        int j=col;
        while(i>=0 && j>=0)
        {
            if(grid[i][j]==1)
                return false;
            i--;
            j--;
        }

        //checking Upper right 
        i=row;
        j=col;
        while(i>=0 && j<grid.size())
        {
            if(grid[i][j]==1)
                return false;
            i--;
            j++;
        }

        return true;
    }
};