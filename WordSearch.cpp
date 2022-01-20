//Time Complexity O(m*n)
// Space Complexity O(1)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<stack>
using namespace std;

class Solution {
public:
    int dirs[4][2]={{0,1},{0,-1},{1,0},{-1,0}};
    bool exist(vector<vector<char> >& board, string word) {
        for(int i=0;i<board.size();i++)
        {
            for(int j=0;j<board[0].size();j++)
            {
                
                if(helper(board,word,i,j,0))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    
    bool helper(vector<vector<char> >& board,string word,int row, int col, int index)
    {
        //base
        if(index==word.size())
        {
            return true;
        }
        if(row<0 || row>=board.size() || col<0 || col>=board[0].size() || board[row][col]=='#')
        {
            return false; 
        }
        
        //logic
        if(board[row][col]==word[index])
        {
            char c = board[row][col];
            board[row][col]='#';
            for( auto &dir : dirs)
            {
                int nr=row+dir[0];
                int nc=col+dir[1];
                if(helper(board,word,nr,nc,index+1))
                {
                    return true;
                }
            }
            board[row][col]=c;
        }
        
        return false;
    }
};