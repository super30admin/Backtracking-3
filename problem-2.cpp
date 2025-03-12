// https://leetcode.com/problems/word-search/
// Time Complexity : O(n*m*4^k) where n, m is the rows and cols in board, k is the length of the word 
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public:
        bool helper(vector<vector<char>>& board, string word, int i, int j, int idx, vector<pair<int,int>> &dir){
            if(idx == word.length()) return true;
            if(i<0 || i==board.size() || j<0 || j==board[0].size() || board[i][j] == '#') return false;
            if(board[i][j] == word[idx]){
                board[i][j] = '#';
                for(auto [x,y]:dir){
                    int dx = x+i;
                    int dy = y+j;
                    if(helper(board, word, dx, dy, idx+1, dir)) return true;
                }
                board[i][j] = word[idx];
            }
            return false;
    
        }
        bool exist(vector<vector<char>>& board, string word) {
            int n = board.size();
            int m = board[0].size();
            vector<pair<int,int>> dir = {{-1,0},{1,0},{0,-1},{0,1}};
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(board[i][j] == word[0]){
                        if(helper(board, word, i, j, 0, dir)) return true;
                    }
                }
            }
            return false;
        }
    };