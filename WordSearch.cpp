// Time Complexity - O(3^n), n -> length of word.
// Space Complexity - O(n), n -> length of word.
// Problems Faced - Gives a TLE on Leetcode.
// Attempt 1
class Solution {
    private:
    vector<vector<int>>dirs {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    int m;
    int n;
    bool backtrack(vector<vector<char>>& board, int i, int j, string word, int index){
        // base
        if(index == word.length())
            return true;
        if(i < 0 || j < 0 || i == m || j == n || board[i][j] == '#')
            return false;
        // logic
        if(board[i][j] == word[index]){
            for(vector<int> dir : dirs){
                int r = dir[0] + i;
                int c = dir[1] + j;
                // action
                board[i][j] = '#';
                
                // recurse
                if(backtrack(board, r, c, word, index+1))
                    return true;
                
                // backtrack the action
                board[i][j] = word[index];  
            }
        }
        return false;
    }
public:
    bool exist(vector<vector<char>>& board, string word) {
        m = board.size();
        n = board[0].size();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(word[0] == board[i][j]){
                    if(backtrack(board, i, j, word, 0))
                        return true;
                }
            }
        }
        return false;
    }
};

// Attempt 2 - Does not give TLE.
class Solution {
    bool dfs(vector<vector<char>>& board, string word, int index, int i, int j, vector<vector<int>>& dirs, int m, int n){
        // base
        if(index >= word.length())
            return true;
        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '#')
            return false;
        // logic
        
        if(board[i][j] == word[index]){
            for(auto& dir : dirs){              // Just iterating over the directions array using auto iterator saved me from a TLE.
                int nr = i + dir[0];
                int nc = j + dir[1];
                // action
                board[i][j] = '#';

                // recurse
                if(dfs(board, word, index+1, nr, nc, dirs, m, n))
                    return true;

                // backtrack
                board[i][j] = word[index];
            }
        }
        
        return false;
    }
public:
    bool exist(vector<vector<char>>& board, string word) {
        vector<vector<int>> dirs{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int m = board.size();
        int n = board[0].size();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word[0]){
                    if(dfs(board, word, 0, i, j, dirs, m, n))
                        return true;
                }
            }
        }
        return false;
    }
};