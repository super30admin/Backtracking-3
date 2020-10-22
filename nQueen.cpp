//time complexity:O(n!)
//space complexity:O(n)
//executed on leetcode: yes
//approach:using backtracking
//any issues faced? yes

class Solution {
public:
    vector<vector<string>>res;
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<int>>board(n,vector<int>(n));
        set<int>diagonal1;
        set<int>diagonal2;
        set<int>vertical;
        dfs(board,0,diagonal1,diagonal2,vertical);
        return res;
    }
    void dfs(vector<vector<int>>& board, int i, set<int>&diagonal1, set<int>diagonal2, set<int>&vertical)
    {
        if(i==board.size())
        {
            add(board);
            return;
        }
        for(int j=0; j<board.size(); j++)
        {
            if(diagonal1.find(i+j)==diagonal1.end() && diagonal2.find(j-i)==diagonal2.end() && vertical.find(j)==vertical.end())
            {
                board[i][j]=1;
                diagonal1.insert(i+j);
                diagonal2.insert(j-i);
                vertical.insert(j);
                dfs(board,i+1,diagonal1,diagonal2,vertical);
                board[i][j]=0;
                diagonal1.erase(i+j);
                diagonal2.erase(j-i);
                vertical.erase(j);
            }
        }
        
    }
    void add(vector<vector<int>>&board)
    {
        vector<string>curr;
        for(int i=0; i<board.size(); i++)
        {
            string temp="";
            for(int j=0; j<board.size(); j++)
            {
                if(board[i][j]==0)
                    temp+=".";
                else
                    temp+="Q";
            }
            curr.push_back(temp);
        }
        res.push_back(curr);
    }
};