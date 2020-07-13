//Time Complexity : O(n!)
// Space Complexity :O(n) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
public:
    bool isSafe(int row, int col,vector<vector<int>> &board ){
        //column above
        for(int k=0; k<row; k++){
            if(board[k][col]==1) return false;
        }
        
        //diagonal left
        int i=row-1; int j=col-1;
        while(i>=0 && j>=0){
            if(board[i][j]==1){
                return false;
            }
            i--;
            j--;
        }
        
        //diagonal right
        i=row-1; j=col+1;
        while(i>=0 && j<board.size()){
            if(board[i][j]==1) return false;
            i--; j++;
        }
        
        return true;
    }
    
    void backtrack(vector<vector<int>> &board,vector<vector<string>> &res, int row ){
        if(row==board.size()){
            vector<string> temp;
            for(int i=0; i<board.size(); i++){
                string t = "";
                for(int j=0; j<board.size();j++){
                    if(board[i][j]==0){
                        t+='.';
                    }
                    else{
                        t+='Q';
                    }
                }
                temp.push_back(t);
            }
            res.push_back(temp);
            return;
        }
        
        for(int col=0; col<board.size(); col++){
            //action
            if(isSafe(row, col, board)){
                board[row][col]=1;
                
                //recurse
                backtrack(board, res, row+1);
            
                //backtrack
                board[row][col]=0;
            }

        }
        
    }
    
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> res;
        if(n==0) return res;
        vector<vector<int>> board;
        
        //make board
        for(int i=0; i<n; i++){
            vector<int> temp;
            for(int j=0; j<n; j++){
                temp.push_back(0);
            }
            board.push_back(temp);
        }
        
        backtrack(board,res,0);
        return res;
    }
};