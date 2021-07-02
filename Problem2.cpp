// Time Complexity :O(N * 3^L) where L is the length of the word 
// Space Complexity : O(L) Length of word which will be in the system stack  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Word Search 

#include<vector>
#include<iostream>
using namespace std;

class Solution {
private:
    int m;
    int n;
    //dirs array
    int dirs[4][2] = {{-1,0},{1,0},{0,1},{0,-1}}; //  L-R-U-D
public:
    bool exist(vector<vector<char>>& board, string word) {
         m = board.size();  // rows
         n = board[0].size();   // columns
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(backtrack(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }
    
    bool backtrack(vector<vector<char>>& board, int r, int c, string word, int index){
        
        //base case
        if(word.size() == index)
            return true;
        
        if(r < 0 || c < 0 || r == m || c == n || word[index] != board[r][c])
            return false;
        
        //logic
        char temp = board[r][c];    // once the char is equal, replace and dfs
        board[r][c] = '$';
        
        for(auto dir : dirs){
            int i = r + dir[0];
            int j = c + dir[1];
            
            if(backtrack(board, i, j, word, index + 1))
                return true;
        }
        
        // if we go along that one path and don't find anything then backtrack
        board[r][c] = temp;
        return false;
    }
};