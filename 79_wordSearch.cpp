// Time Complexity : exponential (M*N* 3^L)
// Space Complexity :O(L) where L is the length of the word
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    vector<vector<int>> dirs;
    int m, n;
    bool exist(vector<vector<char>>& board, string word) {
        if(board.empty() || board.size() == 0)
            return false;
        m = board.size();
        n = board[0].size();
        dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == word[0]){
                    if(backtrack(board, word, 0, i, j))
                        return true;
                }
            }
        }
        return false;
    }
    
    bool backtrack(vector<vector<char>>& board, string word, int index, int row, int col){
        //base
        if(index == word.length())
            return true;
        if(row<0 || row==m || col<0 || col==n || board[row][col] != word[index])
            return false;
        
        //logic
        //action
        char ch = board[row][col];
        board[row][col] = '#';
        for(vector<int> dir : dirs){
            int r = dir[0] + row;
            int c = dir[1] + col;
            //recurse
            if(backtrack(board, word, index+1, r, c))
                return true;
        }
        //backtrack
        board[row][col] = ch;
        return false;
    }
};
