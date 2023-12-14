/*
Use backtracking to explore all possible queen placements in each row, marking positions on the chessboard.
Utilize a recursive DFS approach, checking safety conditions to avoid conflicts along rows, columns, and diagonals.
Record valid placements and construct the result as a vector of vectors representing the chessboard configurations.

Time Complexity: O(N!), where N is the size of the chessboard (number of queens). The factorial arises from the exponential growth in possibilities.
Space Complexity: O(N^2) for the chessboard matrix and recursive call stack during backtracking. The space needed scales with the size of the chessboard.*/
#include<bits/stdc++.h>
using namespace std;
class Solution {
    vector<vector<string>>result;
    vector<vector<bool>> board;
public:
    vector<vector<string>> solveNQueens(int n) {
        board.resize(n, vector<bool>(n, false));
        helper(0,n);
        return result;
    }

    void helper(int row,int n){
        if(row==n){
            vector<string>temp;
            for(int i=0;i<n;i++){
                string sb;
                for(int j=0;j<n;j++){
                    if(board[i][j]){
                        sb.push_back('Q');
                    }else{
                        sb.push_back('.');
                    }
                }
                temp.push_back(sb);
            }
            result.push_back(temp);
            return;
        }
        for(int j=0;j<n;j++){
            if(isSafe(row,j,n)){
                board[row][j]=true;
                helper(row+1,n);
                board[row][j]=false;
            }
        }
    }

    bool isSafe(int i, int j, int n){
        int r=i,c=j;
        while(r>=0){
            if(board[r][c])return false;
            r--;
        }
        r=i,c=j;
         while(r>=0&&c>=0){
            if(board[r][c])return false;
            r--;c--;
        }
        r=i,c=j;
         while(r>=0&&c<n){
            if(board[r][c])return false;
            r--;c++;
        }
        return true;
    }
};