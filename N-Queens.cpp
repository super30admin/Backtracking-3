//Time Complexity- O(n!)
//Space Complexity- O(n^2)

class Solution {
public:
    vector<vector<string>> solveNQueens(int n) {
        
        bitset<30> col,diag1,diag2;
        vector<vector<string>> ans;
        string s(n,'.');
        vector<string> temp(n,s);
        helper(ans,temp,0,n,col,diag1,diag2);
        return ans;
    }
    
    void helper(vector<vector<string>> &ans,vector<string> &temp,int row,int n, bitset<30> &col, bitset<30> &diag1, bitset<30> &diag2){
        
        if(row==n){
            ans.push_back(temp);
            return;
        }
        
        for(int i=0;i<n;i++){
            if(!col[i] && !diag1[row-i+n-1] && !diag2[row+i]){
                col[i]=diag1[row-i+n-1]=diag2[row+i]=1;
                temp[row][i]='Q';
                helper(ans,temp,row+1,n,col,diag1,diag2);
                col[i]=diag1[row-i+n-1]=diag2[row+i]=0;
                temp[row][i]='.';
            }
        }
    }
};