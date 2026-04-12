// Time Complexity : O(m*n*4^L), L = length of word
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Start DFS from cells which have the starting char of the word
// Explore valid cells in all 4 directions, use a # symbol to mark a cell as visited
// Backtrack # to unmark as visited once that path has been explored

class Solution {
private:
    vector<vector<int>> dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    void dfs(int r, int c, int m, int n, vector<vector<char>>& board, int idx, string word, bool& flag) {
        if(idx == word.length()) {
            flag = true;
            return;
        }
        if(flag) return;
        for(auto& dir : dirs) {
            int nr = r + dir[0]; int nc = c + dir[1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && board[nr][nc] == word[idx] && board[nr][nc] != '#') {
                board[nr][nc] = '#';
                dfs(nr, nc, m, n, board, idx+1, word, flag);
                board[nr][nc] = word[idx];
            }
        }
    }
public:
    bool exist(vector<vector<char>>& board, string word) {
        int m = board.size();
        int n = board[0].size();
        bool flag = false;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == word[0]) {
                    char temp = board[i][j];
                    board[i][j] = '#';
                    dfs(i, j, m, n, board, 1, word, flag);
                    board[i][j] = temp;
                }
            }
        }
        return flag;
    }
};