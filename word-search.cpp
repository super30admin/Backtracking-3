// Time Complexity : O(m*n*3^L)
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <vector>

using namespace std;

class Solution {
    vector<vector<int>> dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int m, n;
    vector<vector<bool>> visited;

public:
    bool exist(vector<vector<char>>& board, string word) {
        m = board.size();
        n = board[0].size();
        visited = vector<vector<bool>>(m, vector<bool>(n, false));

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j))
                    return true;
            }
        }

        return false;
    }

private:
    bool dfs(vector<vector<char>>& board, string word, int i, int j) {
        // Base cases
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j])
            return false;

        // Logic
        if (word[0] == board[i][j]) {
            if (word.length() == 1)
                return true;

            visited[i][j] = true;

            for (auto dir : dirs) {
                int r = i + dir[0];
                int c = j + dir[1];

                if (dfs(board, word.substr(1), r, c))
                    return true;
            }

            // Backtrack
            visited[i][j] = false;
        }

        return false;
    }
};