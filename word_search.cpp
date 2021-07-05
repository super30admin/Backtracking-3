// Time Complexity : O(N) (Total number m*n)
// Space Complexity :  O(l) (Length of word)
// Did this code successfully run on Leetcode : Almost (Got TLE on last test)
// Any problem you faced while coding this

class Solution {
private:
    bool check_rec(vector<vector<char>>& board, pair<int, int> cord, string &word, int ptr)
    {
        if(ptr == word.size())
            return true; //check
        
        int m = board.size();
        int n = board[0].size();
        
        char temp = board[cord.first][cord.second];
        board[cord.first][cord.second] = '#';
        
        vector<pair<int, int>> dir;
        dir.push_back(pair(-1,0));
        dir.push_back(pair(1,0));
        dir.push_back(pair(0,-1));
        dir.push_back(pair(0,1));
        
        int r, c;
        
        for(int i = 0 ; i < dir.size(); i++)
        {
            r = cord.first + dir[i].first;
            c = cord.second + dir[i].second;
            
            // next character matches
            if(r >= 0 && c >= 0 && r < m && c < n && board[r][c] == word[ptr])
            {
                if(check_rec(board, pair(r,c), word, ptr+1))
                {
                    board[cord.first][cord.second] = temp;
                    return true;
                }
            }
        }
        
        board[cord.first][cord.second] = temp;
        return false;
    }
    
public:
    bool exist(vector<vector<char>>& board, string word) {
        
        int m = board.size();
        int n = board[0].size();
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(board[i][j] == word[0])
                {
                    bool val = check_rec(board, pair(i,j), word, 1);
                    
                    if(val == true)
                    {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
};