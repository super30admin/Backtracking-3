// Time Complexity : O(n!)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <vector>

using namespace std;

class Solution {
private:
    vector<vector<string>> result;
public:
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<bool>> board(n, vector<bool>(n, false));
        helper(board, 0);
        return result;
    }
private:
    void helper(vector<vector<bool>>& board, int i){
        //base
        if(i == board.size()){
            vector<string> row;
            for(int r = 0; r < board.size(); r++){
                string rowStr(board.size(), '.');
                for(int c = 0; c < board.size(); c++){
                    if(board[r][c]){
                        rowStr[c] = 'Q';
                    }
                }
                row.push_back(rowStr);
            }
            result.push_back(row);
            return;
        }
        //logic
        for(int j = 0; j < board[0].size(); j++){
            if(isSafe(board, i, j)){
                //action
                board[i][j] = true;
                //recurse
                helper(board, i + 1);
                //backtrack
                board[i][j] = false;
            }
        }
    }

    bool isSafe(vector<vector<bool>>& board, int r, int c){
        //column
        for(int i = 0; i < r; i++){
            if(board[i][c]){
                return false;
            }
        }
        //diagonal
        //left
        int i = r;
        int j = c;
        while(i >= 0 && j >=0){
            if(board[i][j]){
                return false;
            }
            i--;
            j--;
        }
        //right
        i = r;
        j = c;
        while(i >= 0 && j < board[0].size()){
            if(board[i][j]){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
};