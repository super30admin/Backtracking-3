//Time Comp: O(N!)
//Space Comp: O(N)
class Solution {
public:
    vector<vector<string>> result;
    vector<string> temp;
    bool isSafe(int n, int r, int c){
        for(int i=0; i<n;i++){
            if (i==r) continue;    
            if(temp[i][c]=='Q') return false;
        }
        
        for(int j=0; j<n;j++){
            if (j==c) continue;    
            if(temp[r][j]=='Q') return false;
        }
        
        for(int i=r-1, j=c-1; i>=0 && j>=0; i--, j--){
            if(temp[i][j]=='Q') return false;
        }
        for(int i=r+1, j=c+1; i<n && j<n; i++, j++){
            if(temp[i][j]=='Q') return false;
        }
        for(int i=r+1, j=c-1; i<n && j>=0; i++, j--){
            if(temp[i][j]=='Q') return false;
        }
        for(int i=r-1, j=c+1; i>=0 && j<n; i--, j++){
            if(temp[i][j]=='Q') return false;
        }
        return true;
    }
    bool solve(int n, int c){
        if(c == n){
            return true;
        }
        for(int i=0; i<n;i++){
            if(isSafe(n,i,c)){
                temp[i][c] = 'Q';
                if(solve(n,c+1)){
                    result.push_back(temp);          
                } 
                temp[i][c]='.';
            }
        }
        return false;
    }
    
    
    vector<vector<string>> solveNQueens(int n) {
        result.clear();
        temp.clear();
        string t = "";
        for(int i=0; i<n; i++) t+=".";
        for(int i=0; i<n; i++) temp.push_back(t);
        solve(n,0);
        return result;
    }
    
};