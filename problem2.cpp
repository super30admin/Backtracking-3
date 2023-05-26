// Time Complexity :  O(m*n * 3^L)
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :




// Your code here along with comments explaining your approach

// we traverse through the entire m*n and do dfs at each cell.
// in the dfs, we check in 4 directions to find the next element of word.
// we change the value of a visited cell to any special value and proceed with dfs . after wards, we backtrack the value.
// if we reach the end of the word index, then we found an answer hence we return true.





class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        if(board.empty() || board.size()==0) return false;
        vector<vector<int>>dir = {{0,-1},{0,1},{-1,0},{1,0}};    //L R U D
        for(int i = 0;i<board.size();i++)
        {
            for(int j = 0;j<board[0].size();j++)
            {
                if(dfs(board,word,i,j,0,dir))
                    return true;
            }
        }
        return false;
    }
    bool dfs(vector<vector<char>>& board, string &word,int row, int col, int index,vector<vector<int>>&dir)
    {
        if(index >= word.size()) return true;
        if(row<0 || row>= board.size() || col <0 || col >=board[0].size()) return false;
        
        if(board[row][col] == word[index])
        {
            char ch = board[row][col];
            board[row][col] = '0';
            for(auto &v: dir)
            {
                int nr = row + v[0];
                int nc = col + v[1];
                if(dfs(board,word,nr,nc,index+1,dir))
                    return true;
            }
            board[row][col] = ch; 
        }
        return false;
    }
};