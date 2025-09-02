#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We use DFS to move through the board matrix to find each letter from the word
Using recursion we then use it to find the word and return true if it is possible to
make that word or false if we are not able to get the word
TC : O(m*n)*3^L  SC: O(L) recursive stack
*/
class Solution{
    int m, n;
    vector<vector<int>> dirs;
public:
    bool exist(vector<vector<char>>& board, string word){
        m = board.size(); n = board[0].size();
        dirs = {{-1,0},{1,0},{0,1},{0,-1}};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
private:
    bool dfs(vector<vector<char>>& board, string word, int i, int j, int idx){
        if(idx == word.length()) return true;
        if(i<0 || j<0 || i==m || j==n || board[i][j] == '#') return false;
        if(board[i][j] != word[idx]) return false;

        board[i][j] = '#';
        for(vector<int>& dir : dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;
            if(dfs(board, word, r, c, idx+1)) return true;
        }

        //backtrack
        board[i][j] = word[idx];
        return false;
    }

};
