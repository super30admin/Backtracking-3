//Time Compelxity : O(n*m*4^L)
//space Complexity : O(L)
#include<iostream>
#include<vector>
using namespace std;

// Start DFS from each cell that matches the first letter of the word.
// Explore 4 directions (up, down, left, right) using DFS to match the entire word.
// Mark visited cells with '#' to avoid revisiting during the current path.
// Backtrack if needed and return true if the full word is found.

class Solution {
public:
    vector<vector<int>>dir;
    int m,n;
    bool exist(vector<vector<char>>& board, string word) {
        dir = {{-1,0},{1,0},{0,1},{0,-1}};
        m = board.size();
        n = board[0].size();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dfs(board, i, j, word, 0)) 
                    return true;
            }
        }
        return false;
    }

    bool dfs(vector<vector<char>>& board, int i, int j, string& word, int idx){
        if(idx == word.length()) 
            return true;
        if(i < 0 || j < 0 || i == m || j == n || board[i][j] == '#') 
            return false;
        if(board[i][j] != word[idx]) 
            return false;
        board[i][j] = '#';
        for(vector<int>& x : dir){
            int r = x[0] + i;
            int c = x[1] + j;
            if(dfs(board, r, c, word, idx+1)) 
                return true;
        }
        board[i][j] = word[idx];

        return false;
    }
};