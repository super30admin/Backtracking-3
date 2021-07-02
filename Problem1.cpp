// Time Complexity :O(N!) where N is the number of Queens
// Space Complexity : O(N x N) Size of matrice
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// N -  Queens 

#include<vector>
#include<iostream>
using namespace std;
class Solution {
private:
    vector<vector<bool>> board;
    vector<vector<string>> result;
public:
    vector<vector<string>> solveNQueens(int n) {
        board.resize(n, vector<bool>(n, false));
        backtrack(0, n);
        return result;
    }
    
    
    void backtrack(int r, int n){
        // base
        if(r == n){
            vector<string> temp;
            for(int i = 0; i < n; i++){
                string str;
                for(int j = 0; j < n; j++){
                    if(board[i][j] == true){
                        str = str + "Q";
                    }
                    else{
                        str = str + ".";
                    }
                }
                temp.push_back(str);    // this is one possibility - array of strings 
            }
            result.push_back(temp); //  multiple array of strings / multiple possibilities 
        }
        
        // logic
            for(int j = 0; j < n; j++){
                if(isSafe(r, j, n)){
                    board[r][j] = true; // place queen - action
                    backtrack(r + 1, n);    // recurse
                    board[r][j] = false;    // backtrack action will only hit if path is invalid, if valid eventually r == n and exited 
                }
            }
        }
    
    bool isSafe(int r, int c, int n){
        
        // check the column from top to bottom
        for(int i = 0; i < r; i++){  // current row isn't included
            if(board[i][c])
                return false;
        }
        
        //  check diagonal left up 
        int i = r;  int j = c;
        while(i >= 0 && j >= 0){
            if(board[i][j])
                return false;
            i--; j--;
        }
        
        // check diagonal right up
        i = r; j = c;
        while(i >= 0 && j < n){
            if(board[i][j])
                return false;
            i--; j++;
        }
        
        return true;
    }
};