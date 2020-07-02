//Time complexity - O(mn*4^L)
//space Complexity - O(mn)
//Ran successfully on leetcode
//3 point algo is as follows - 
	//1.do bfs or dfs
    //2.To backtrack, we store the previous element in a temp variable
    //3.In dfs, we visit one node and explore one of its 4 children. If any one equals the next character of our string, we move ahead.

class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        if(board.empty())
            return true;
        for(int i=0;i<board.size();i++)
            for(int j=0;j<board[0].size();j++)
                if(dfs(board,word,i,j,0))
                    return true;
        return false;
    }
    vector<vector<int>>dirs={{1,0},{0,1},{-1,0},{0,-1}};
    bool dfs(vector<vector<char>>&board,string word,int i,int j,int k)
    {
        if(k==word.size())
            return true;    
        if(i==board.size() || j==board[0].size() || i<0 || j<0 || word[k]!=board[i][j] || board[i][j]=='*')
            return false;
        char x=board[i][j];
        board[i][j]='*';
        for(auto dir:dirs)
        {
            int r=dir[0]+i;
            int c=dir[1]+j;
            if(dfs(board,word,r,c,k+1))
                return true;
        }
        k--;
        board[i][j]=x;
        return false;
    }
};