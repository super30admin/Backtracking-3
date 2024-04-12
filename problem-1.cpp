// 51. N-Queens
// Time Complexity : O(n!)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
public:
    void solve(int col,vector<vector<string>> &ans,vector<string> &board,int n, vector<int> &leftRow,vector<int> &upperDiagonal,vector<int> &lowerDiagonal){
        if(col == n)
        {
            ans.push_back(board);
            return;
        }
        for(int row = 0;row<n;row++)
        {
            if(lowerDiagonal[row+col]==0 && upperDiagonal[n-1+col-row]==0 && leftRow[row]==0){
                lowerDiagonal[row+col]=1;
                upperDiagonal[n-1+col-row]=1;
                leftRow[row]=1;
                board[row][col]='Q';
                solve(col+1,ans,board,n,leftRow,upperDiagonal,lowerDiagonal);
                board[row][col]='.';
                leftRow[row]=0;
                upperDiagonal[n-1+col-row]=0;
                lowerDiagonal[row+col]=0;
            }
        }
    }
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> ans;
        vector<string> board(n);
        string s(n,'.');
        for(int i=0;i<n;i++) board[i]=s;
        vector<int> leftRow(n,0), upperDiagonal(2*n-1,0), lowerDiagonal(2*n-1,0);
        solve(0,ans,board,n,leftRow,upperDiagonal,lowerDiagonal);
        return ans;

    }
}; 
