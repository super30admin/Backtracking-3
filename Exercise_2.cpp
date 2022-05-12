/* 
    Time Complexity                             :  O(N * 3^L) where N is the total number of cells in 
                                                    the board and L is the length of the given word.
                                                    Since at every stage in the recursion, the forward
                                                    flow has 3 options of the 4 directions (left, right,
                                                    up and down). 3 options because one direction from 
                                                    which the recursion came to the current point cannot 
                                                    be retraced.
    Space Complexity                            :  O(L) - max length of the recursion stack which will
                                                    be the length of the given word.
    Did this code successfully run on Leetcode  :  Yes
    Any problem you faced while coding this     :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/word-search/

class Solution {
private: 
    int n, m;
    vector<vector<int>> dirs{{1,0},{0,1},{-1,0},{0,-1}};
    
public:
    bool exist(vector<vector<char>>& board, string word) {
        n = board.size();
        m = board[0].size();
        
        for(int i=0;i<n;i++) 
        {
            for(int j=0;j<m;j++) 
            {
                if(board[i][j] == word[0] and dfs(board, word, i, j, 0)) 
                {
                      return true;
                }
            }
        }
        return false;
    }
    
    bool dfs(vector<vector<char>>& board, const string& word, int i, int j, int wi) {
        if(wi == word.size()) 
        {
            return true;
        }
        
        if(i < 0 or i == n or j < 0 or j == m or board[i][j] != word[wi]) {
            return false;
        }
        
            board[i][j] = '-';
            for(int k=0;k<dirs.size();k++) {
                int ni = i + dirs[k][0];
                int nj = j + dirs[k][1];
                if(dfs(board, word, ni, nj, wi+1)) {
                    return true;
                }
            }

            board[i][j] = word[wi];
        
        return false;
    }
};