//Time Complexities - O(n!)
//Space Complexitites - O(1)
class Solution {
public:
    vector<vector<string>> res;
    bool isSafe(vector<string> &board, int row, int col) {
        
        // col check
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q') return false;
        
        //left diagonal
        for(int i = row,j=col; i>=0&&j>=0; i--,j--)
            if(board[i][j] == 'Q') return false;
        
        //For Right Diagonal
        for(int i = row,j=col; i>=0&&j>=0; i--,j++)
            if(board[i][j] == 'Q') return false;
        
        return true;
    }
    void solve(int i,vector<string> temp){
        if(i == temp.size()){
            res.push_back(temp);
            return;
        }
        for(int j = 0; j<temp.size(); j++){
            if(isSafe(temp,i,j)){
                temp[i][j] = 'Q';
                solve(i+1,temp);
                temp[i][j] = '.';
            }
        }
    }
    vector<vector<string>> solveNQueens(int n) {
        vector<string> temp(n,string(n,'.'));
        solve(0,temp);
        return res;
    }
};