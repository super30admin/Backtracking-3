// Time Complexity : O(n!)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
Find the row position of queen in the row , store it pos as true
move to the next row, and found the suitable place by checking upwared diagonal left and right and upper column
for the queen . if not found in current row go back to previous row and check the next safe space.
Do it until all rows are filled with queens and save the solution
*/

#include<iostream>
#include<vector>
#include<string>

using namespace std;

class Solution {
    vector<vector<string>> res;

    bool check(int pivot,int j,const vector<vector<bool>>& flags){
        
        //check upward column at j
        for(int m{pivot};m>=0;--m){
            if(flags.at(m).at(j) == true) return false;
        }
        //check left above diagonal
        for(int m{pivot},n{j};(m>=0 && n>=0);--m,--n){
            if(flags.at(m).at(n) == true) return false;
        }
        //check right above diagonal
        for(int m{pivot},n{j};(m>=0 && n<flags.size());--m,++n){
            if(flags.at(m).at(n) == true) return false;
        }

        return true;
    }

    void convert_flag(const vector<vector<bool>>& flags){
        vector<string> to_send{};
        int n = flags.size();
        for(int i{};i<n;++i){
            string send{};
            for(int j{};j<n;++j){
                if(flags.at(i).at(j)){
                    send.push_back('Q');
                }
                else{
                    send.push_back('.');
                }
            }
            to_send.push_back(send);
        }
        res.push_back(to_send);
    }

    void helper(int pivot,vector<vector<bool>>& flags){
        //base case
        int n = flags.size();
        if(pivot == n){
            convert_flag(flags);
            return;
        }
        //logic check all the elements in row
        for(int j{};j<n;++j){
            if(check(pivot,j,flags)){
                flags.at(pivot).at(j) = true;
                helper(pivot+1,flags);
                flags.at(pivot).at(j) = false;
            }
        }
    }
public:
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<bool>> flags(n,vector<bool>(n,false));
        helper(0,flags);
        return res;
    }
};

