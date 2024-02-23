// TC = O(M*N*3^L), L is length of word, mn for finding first letter of word
// SC= O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// For loop based recursion with backtrack or can be solved with for loop based recursion
class Solution {
public:
    vector<vector<int>> dirs{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int m, n;
    bool exist(vector<vector<char>>& board, string word) {
        // null
        if(board.size() == 0) return false;
        m = board.size();
        n = board[0].size();
        for(int i = 0; i < m ; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.at(0)) { // 1st letter found
                    if(backtrack(board, i, j, word, 0)) return true; // start searching for the rest letters of the word
                }
            }
        }
        return false;
    }
    bool backtrack(vector<vector<char>>& board, int i, int j, string word, int index) {
        // base
        if(index == word.size()) return true;
        if(i < 0 || j < 0 || i == m || j == n || board[i][j] == '#') return false;
        // logic
        if(board[i][j] == word.at(index)) { // for (next) index, the char at board should match word's letter
            for(vector<int> dir: dirs) {
                int r = i + dir[0];
                int c = j + dir[1];
                // action
                board[i][j] = '#'; // reusing the same board & marking it as visited
                // recurse
                if(backtrack(board, r, c, word, index + 1)) return true; // found word, return true
                // backtrack
                board[i][j] = word.at(index); // marking it unvisited by assigining the original char
            }
        }
        return false;
    }
};