// Time Complexity - 
// Space Complexity - O(n^2)
// Problems Faced - No!
// It runs on leetcode.

class Solution {
    vector<vector<string>> answer;
    private:
    bool isSafe(vector<vector<bool>> board, int r, int c, int n){
        for(int i = 0; i < r; i++){
            if(board[i][c])
                return false;   
        }
        int row = r; int col = c;
        while(row >= 0 && col >= 0){
            if(board[row][col]) 
                return false;
            row--;
            col--;
        }
        
        row = r; col = c;
        while(row >= 0 && col < n){
            if(board[row][col])
                return false;
            row--;
            col++;
        }
        return true;
        
    }
    void backtrack(vector<vector<bool>> board, int r, int n){
        // base
        if(r == n){
            vector<string> convert;
            string q("Q");
            string dot(".");
            for(int i = 0; i < n; i++){
                string temp;
                for(int j = 0; j < n; j++){
                    if(board[i][j])
                        temp += q;
                    else
                        temp += dot;
                }
                convert.push_back(temp);
            }
            answer.push_back(convert);
            return;
        }
        
        //logic
        for(int i = 0; i < n; i++){
            if(isSafe(board, r, i, n)){
                //action
                board[r][i] = true;
                //recurse
                backtrack(board, r+1, n);
                //bactrack
                board[r][i] = false;
            }
            
        }
    }
public:
    vector<vector<string>> solveNQueens(int n) {
        if(n == 0)
            return answer;
        vector<vector<bool>> board(n, vector<bool>(n, false));
        backtrack(board, 0, n);
        return answer;
    }
};