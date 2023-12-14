/*Use DFS to explore all possible paths from each cell, checking if the word can be formed by moving horizontally or vertically.
For each cell, recursively explore neighbors, marking visited cells to avoid reuse, and backtracking after exploration.
If the word is found starting from any cell, return true; otherwise, return false.

Time Complexity: O(N * M * 4^L) where N and M are the dimensions of the grid, and L is the length of the word.
Space Complexity: O(L) for the recursive call stack (depth of the recursion).*/
#include<bits/stdc++.h>
using namespace std;
class Solution {
    int row, col;
public:
    bool exist(vector<vector<char>>& board, string word) {
        row=board.size();
        col=board[0].size();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(dfs(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    bool dfs(vector<vector<char>>& board, string word,int i,int j,int k){
        if(i<0||i>=row||j<0||j>=col||board[i][j]!=word[k]){
            return false;
        }
        if(k==word.size()-1){
            return true;
        }
        char temp=board[i][j];
        board[i][j]='#';
        bool found=dfs(board,word,i+1,j,k+1)||dfs(board,word,i-1,j,k+1)||dfs(board,word,i,j+1,k+1)||dfs(board,word,i,j-1,k+1);
        board[i][j]=temp;
        return found;
    }
};