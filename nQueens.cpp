// Time Complexity :O(n!) where n is the number of queens 
// Space Complexity : O(n)   
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    vector<vector<string>> result;
    vector<vector<int>> board;
public:
    
    vector<vector<string>> solveNQueens(int n) {
        //vector<vector<int>> board(n, vector<int>(n));
        board.resize(n,vector<int>(n,0));
        helper(n,0);
        return result;
    }
    void helper(int n,int r){
        //base
        if(r == n){
            vector<string> temp;
            for(int i= 0;i<board.size();i++){
                string s;
                for(int j = 0;j< board[0].size();j++){
                    if(board[i][j] == 1){
                        s= s+"Q";
                    }
                    else{
                        s= s+".";
                    }
                }
                temp.push_back(s);
            }
            result.push_back(temp);
            return;
        }
        //logic
        for(int c=0; c<n; c++){
            if(isSafe(r,c)){
                board[r][c] = 1;
                helper(n,r+1);
                board[r][c] = 0;
            }
        }
    }
    bool isSafe(int r, int c){
        //Case 1
        int a=0;
        int b=0;
        a=r;
        while(a >= 0){
            if(board[a][c] == 1) return false;
            a--;
        }
        //Case 2
        a=r;
        b=c;
        while(a>=0 && b< board[0].size()){
            if(board[a][b] == 1) return false;
            a--;b++;
        }
        //Case 3
        a=r;
        b=c;
        while(a>=0 && b>= 0){
            if(board[a][b] == 1) return false;
            a--;b--;
        }
        return true;
    }
};