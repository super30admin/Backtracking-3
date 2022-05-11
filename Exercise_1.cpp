/* 
    Time Complexity                              :  O(N!) At every step the number of options reduce by 2.
    Space Complexity                             :  O(N^2)
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/n-queens/

class Solution {
private: 
    vector<vector<string>> grid;
    vector<vector<string>> ans;
    int sz;
    
    void dfs(int r) {
        if(r == sz) {
            updateAns();
            return;
        }
        
        for(int j=0;j<sz;j++) {
            if(isSafe(r,j)) {
                grid[r][j] = "Q";
                dfs(r+1);
                grid[r][j] = ".";
            }
        }
    }
    
    bool isSafe(int r, int c) {
        int i=r, j=c;
        while(i>=0) {
            if(grid[i][j] == "Q") return false;
            i--;
        }
        
        i=r;j=0;
        while(j<sz) {
            if(grid[i][j] == "Q") return false;
            j++;
        }
        
        i=r;j=c;
        while(i >= 0 and j >= 0) {
            if(grid[i][j] == "Q") return false;
            i--;
            j--;
        }
        
        i=r;j=c;
        while(i>=0 and j<sz) {
            if(grid[i][j] == "Q") return false;
            i--;
            j++;
        }
        
        return true;
    }

    void updateAns() {
        
        vector<string> scalarAns;
        for(int i=0;i<sz;i++) {
            string str = "";
            for(int j=0;j<sz;j++) {
                str += grid[i][j];
            }
            scalarAns.push_back(str);
        }
        
        ans.push_back(scalarAns);
    }
    
public:
    vector<vector<string>> solveNQueens(int n) {
        sz = n;
        grid.resize(n,vector<string>(n,"."));
        dfs(0);
        return ans;
        
    }

    
};