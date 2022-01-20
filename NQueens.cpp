//Time Complexity O(m*n)
// Space Complexity O(m*n)
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
    vector<vector<string> >  result;
    vector<vector<bool> > board;
    int dirs[4][2]={{0,1},{0,-1},{1,0},{-1,0}};
    vector<vector<string> >  solveNQueens(int n) {
        vector<vector<bool> > board1(n,vector<bool>(n,false));
        board=board1;
        
        helper(0);
        return result;
    }
    
    void helper(int row)
    {
        //base
        vector<string> vecStr;
        if(row==board.size())
        {
            for( int i=0;i<board.size();i++)
            {
                string s="";
                for(int j=0;j<board[0].size();j++)
                {
                    if(board[i][j]==true)
                    {
                        s+="Q";
                    }
                    else
                    {
                        s+=".";
                    }
                }
                vecStr.push_back(s);
            }
            result.push_back(vecStr);
            return;
        }
        
        
        
        //logic
        
        for(int c=0;c<board[0].size();c++)
        {
            if(isSafe(row,c))
            {
                board[row][c]=true;
                helper(row+1);
                board[row][c]=false;
            }
            
        }
    }
    
    
    bool isSafe(int row, int col)
    {
        int i=row;
        int j=col;
        
        while(j>=0)
        {
            if(board[i][j]==true)
            {
                return false;
            }
            j--;
        }
        
        j=col;
        while(i>=0)
        {
            if(board[i][j]==true)
            {
                return false;
            }
            i--;
        }
        
        i=row;
        
        //left upper diagonal
        while(i>=0 && j>=0)
        {
            if(board[i][j]==true)
            {
                return false;
            }
            i--;
            j--;
        }
        
        i=row;
        j=col;
        
        while(i>=0 && j<board[0].size())
        {
            if(board[i][j]==true)
            {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
};