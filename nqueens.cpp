//Time complexity - O(n!)
//space Complexity - O(n^2)
//Ran successfully on leetcode

class Solution {
public:
    vector<vector<string>>result;    
    vector<vector<string>>solveNQueens(int n) {
        //Initializing board with .
        vector<string>board(n,string(n,'.'));
        placequeens(0,n,board);
        return result;
    }
    void placequeens(int r,int n,vector<string>&board)
    {
        //base case
        if(r==n)
        {
            result.push_back(board);
            return;
        }
        //logic
        for(int j=0;j<n;j++)
            if(issafe(r,j,n,board))
            {
                //action
                board[r][j]='Q';
                //recurse
                placequeens(r+1,n,board);
                //backtrack
                board[r][j]='.';
            }   
    }
    bool issafe(int r,int c,int n,vector<string>&board)
    {
        //check if the column has a queen
        for (int i = 0; i<r; i++)
            if (board[i][c] == 'Q')
                return false;
        //check if the 45° diagonal has a queen
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q')
                return false;
        //check if upper right diagonal has a queen
        for (int i = r - 1, j = c + 1; i >= 0 && j < n;i--, j++)
            if (board[i][j] == 'Q')
                return false;
        return true;
    }
};