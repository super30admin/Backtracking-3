//Time Cpmplexity : O(n!)
//Space Complexity : O(n^2)
#include<iostream>
#include<vector>
using namespace std;

// Try placing a queen in each column of the current row.
// Use a helper to recursively place queens in next rows if the current placement is safe.
// The check function ensures no queen exists in the same column or diagonals.
// If a full board is valid, convert it to a string format and store it in the answer.

class Solution {
public:
    vector<vector<string>>ans;
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<bool>>mat(n,vector<bool>(n));
        helper(n,mat,0);
        return ans;
    }
    void helper(int n,vector<vector<bool>>&mat,int row){
        if(row==n){
             vector<string>temp;
            for(int i = 0;i < n;i++){
                string s;
                for(int j=0;j<n;j++){
                    if(mat[i][j]){
                        s += "Q";
                    }else{
                        s += ".";
                    }
                }
                temp.push_back(s);
            }
            ans.push_back(temp);
            return;
        }
        for(int i=0;i<n;i++){
            mat[row][i]=true;
            if(check(mat,row,i,n)){
                helper(n,mat,row+1);
            }
            mat[row][i]=false;
        }
    }

    bool check(vector<vector<bool>>&mat,int row,int col,int n){
        for(int j=0;j<row;j++){
            if(mat[j][col]==true){
                return false;
            }
        }
        for(int i=row-1,k=col-1;i>=0 && k>=0;i--,k--){
            if(mat[i][k]==1){
                return false;
            }
        }
        for(int i=row-1,k=col+1;i>=0 && k<n;i--,k++){
            if(mat[i][k]==1){
                return false;
            }
        }
        return true;
    }
};