//
// Created by shazm on 8/7/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        if(board.empty()||word==""){return false;}
        for(int i = 0; i<board.size(); i++){
            for(int j = 0; j<board[0].size(); j++){
                if(board[i][j]==word[0]){
                    if(dfs(board,word,0,i,j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
private:
    bool dfs(vector<vector<char>>& board, string word, int index, int i, int j){
        if(index == word.size()){
            return true;
        }
        if(i<0 || i>=board.size() || j>=board[0].size() || j<0 || board[i][j]!=word[index]){
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '0';
        if(dfs(board,word,index+1,i+1,j)||dfs(board,word,index+1,i-1,j)||dfs(board,word,index+1,i,j+1)||dfs(board,word,index+1,i,j-1)){
            return true;
        }
        board[i][j] = temp;
        return false;
    }
};