// Time Complexity : Exponential - O(N^N) 

// Space Complexity : O(N^2) - recursion stack space

// Did this code successfully run on Leetcode : YES

// Appoarch: Recursion + Backtracking

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool isSafe(int r,int c,vector<string> board,int n){
        int duprow = r;
        int dupcol = c;
        // upper diagonal
        while(r >=0 && c >= 0){
            if(board[r][c] == 'Q') return false;
            r--;
            c--;
        }
        // left
        r = duprow;
        c = dupcol;
        while(c >= 0){
            if(board[r][c] == 'Q') return false;
            c--;
        }
        // lower diagonal
        r = duprow;
        c = dupcol;
        while(r < n && c >= 0){
            if(board[r][c] == 'Q') return false;
            r++;
            c--;
        }
        return true;
    }
    void solve(vector<string>& board,int col,vector<vector<string>>& ans,int n){
        if(col == n){
            ans.push_back(board);
            return;
        }
        for(int row=0;row<n;row++){
            if(isSafe(row,col,board,n)){
                board[row][col] = 'Q';
                solve(board,col+1,ans,n);
                board[row][col] = '.';
            }
        }
    }
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> ans;
        vector<string> board(n);
        string s(n,'.');
        for(int i=0;i<n;i++){
            board[i] = s;
        }
        solve(board,0,ans,n);
        return ans;
    }
};