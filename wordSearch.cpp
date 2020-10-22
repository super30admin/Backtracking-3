//time complexity:O(n*3^l)
//space complexity:O(l)
//executed on leetcode: yes
//approach:using backtracking
//any issues faced? yes


class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        if(board.size()==0)
            return false;
        for(int i=0; i<board.size(); i++)
        {
            for(int j=0; j<board[0].size(); j++)
            {
                if(board[i][j]==word.at(0) && dfs(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }
    bool dfs(vector<vector<char>>& board, int i, int j, string word, int count)
    {
        if(count==word.size())
            return true;
        if(i<0 || j<0 || i>=board.size() || j>=board[0].size() || board[i][j]!=word.at(count))
            return false;
        char temp=board[i][j];
        board[i][j]=' ';
        bool found=dfs(board,i+1,j,word,count+1) || dfs(board,i-1,j,word,count+1) || dfs(board,i,j+1,word,count+1) || dfs(board,i,j-1,word,count+1);
        board[i][j]=temp;
        return found;
    }
};