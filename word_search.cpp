// Apporach 1 : DFS
// Time Complexity : O(n * m) * 3^L       
// Space Complexity : O(L)       ...... L is size of word
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
/*
Leetcode : https://leetcode.com/problems/word-search/description/

Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are
 horizontally or vertically neighboring. The same letter cell may not be used more than once.
*/


class Solution {
    vector<vector<int>>dir{{0,-1}, {0,1}, {-1,0}, {1,0}};
    bool flag{false};
public:
    bool exist(vector<vector<char>>& board, string word) {
        
        for(int i=0; i<board.size(); i++){
            for(int j=0; j<board[0].size(); j++){
                if(board[i][j] == word[0]){
                    dfs(board, i, j, word, 0);
                }
            }
        }
        return flag;
    }

    void dfs(vector<vector<char>>& board, int i, int j, string &word, int idx){

        if(idx == word.size()) {
            flag = true;
            return;
        }
        if(i <0 || j<0 || i >= board.size() || j>= board[0].size() || board[i][j] != word[idx]){
            return;
        }

        board[i][j] = '#';
        for(auto &pair : dir){
            int ni = i + pair[0];
            int nj = j + pair[1];
            if(flag) return;
            dfs(board, ni, nj, word, idx+1);
        }
        board[i][j] = word[idx];
    }
};