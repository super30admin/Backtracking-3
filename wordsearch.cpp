//Time complexity : O(m*n* L^3)
//Space complexity : O(n)

class Solution {
public:
    int m,n;
    vector<vector<int>> dirs = {{0 , 1}, {0 , -1}, {1 , 0}, {-1 , 0}};
    bool exist(vector<vector<char>>& board, string word) {
        if(board.size() == 0)
            return false;
        
        m = board.size();
        n = board[0].size();
        for(int i = 0 ; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(board[i][j] == word[0])
                {
                    if(recurse(board,i,j,word,0))
                    {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    bool recurse(vector<vector<char>>& board, int row, int col, string word, int idx)
    {
        if(idx == word.size())
        {
            return true;
        }
        
        if(row < 0 || row == m || col < 0 || col == n || word[idx] == '#')
        {
            return false;
        }
        
        
        if(word[idx] == board[row][col])
        {
            char ch = board[row][col];
            board[row][col] = '#';

            for(int i = 0; i < dirs.size(); i++)
            {
                int nr = row + dirs[i][0];
                int nc = col + dirs[i][1];
                if(recurse(board,nr,nc,word,idx + 1))
                {
                    return true;
                }
            }

            board[row][col] = ch;
        }
        return false;
    }
};