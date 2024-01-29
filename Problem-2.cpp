// Time Complexity : O(M*N)^2 - MN - for checking starting letter and another MN for DFS 

// Space Complexity : O(M*N)

// Did this code successfully run on Leetcode : YES

// Appoarch: Recursion + Backtracking - Check for the first char of word and change it to visited.

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<vector<int>> dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    int m;
    int n;
    bool backtrack(vector<vector<char>>& board, string &word, int r,int c,int idx){
        if(idx == word.length()) return true;
        if(r < 0 || c < 0 || r == m || c == n || board[r][c] == '#') return false;
        if(board[r][c] == word[idx]){
            board[r][c] = '#';
            for(int i = 0; i<dirs.size(); i++){
                int nr = r + dirs[i][0];
                int nc = c + dirs[i][1];
                if(backtrack(board,word,nr,nc,idx+1)){
                    return true;
                }
            }
            board[r][c] = word[idx];
        }
        return false;
    }
    bool exist(vector<vector<char>>& board, string word) {
        m = board.size();
        n = board[0].size();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == word[0]){
                    if(backtrack(board,word,i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
};