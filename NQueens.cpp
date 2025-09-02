#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
Place one queen per row and explore columns with recursion.
Use colSet, mainDiagSet, and antiDiagSet to O(1)-check if a position is safe.
When a full placement is built, convert the board booleans into strings and add to result
TC : O(n!), SC : O(n^2)
*/
class Solution{
public:
    vector<vector<string>> solveNQueens(int n){
        result.clear();
        board = vector<vector<bool>>(n, vector<bool>(n, false));
        colSet = vector<bool>(2*n, false);
        mainDiagSet = vector<bool>(2*n, false);
        antiDiagSet = vector<bool>(2*n, false);

        helper(0, n);
        return result;
    }
private:
    vector<vector<string>> result;
    vector<vector<bool>> board;
    vector<bool> colSet;
    vector<bool> mainDiagSet;
    vector<bool> antiDiagSet;

    void helper(int r, int n){
        if(r == n){
            vector<string> list;
            for(int i=0; i<n; i++){
                string sb;
                sb.reserve(n);
                for(int j=0; j<n; j++){
                    if(board[i][j]) sb.push_back('Q');
                    else sb.push_back('.');
                }
                list.push_back(sb);
            }
            result.push_back(list);
            return;
        }

        for(int c=0; c<n; c++){
            int md = r + c;
            int ad = r - c + n;

            if(!colSet[c] && !mainDiagSet[md] && !antiDiagSet[ad]){
                colSet[c] = true;
                mainDiagSet[md] = true;
                antiDiagSet[ad] = true;

                board[r][c] = true;
                helper(r+1, n);
                board[r][c] = false;

                colSet[c] = false;
                mainDiagSet[md] = false;
                antiDiagSet[ad] = false;
            }
        }
    }
};
