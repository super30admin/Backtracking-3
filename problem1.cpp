class Solution {
public:
    int m;
    vector<vector<string>> result;
      vector<vector<bool>> grid;
    vector<vector<string>> solveNQueens(int n) {
   
         m = n;
         grid.resize(n, vector<bool>(n));
         dfs(0);
        return result;
    }
    
    void dfs(int row) {
        
        if(row == grid.size()){
             vector<string> v;
            for(int i=0;i<m;i++){
               string s;
                for(int j=0;j<m;j++){
                    
                    if(grid[i][j] == true) {
                       s += "Q";
                    } else {
                         s += ".";
                    }
                }
                cout<<s;
                v.push_back(s);
            }
            result.push_back(v);
            return;
        }
        
        for(int i =0;i<grid.size();i++){
            if(isSafe(row,i)){
              //cout<<"---";
                grid[row][i] = true;
                dfs(row+1);
                // cout<<"++";
                grid[row][i] = false;
            }
        }  
    }
    
    bool isSafe(int r, int c){
        
        for(int i = 0;i<r;i++){
            if(grid[i][c] == true) return false;
        }
        
        
        int i = r, j=c;
        while(i>=0 && j>=0) {
             if(grid[i][j] == true) return false;
            i--;
            j--;
            
        }
        
          i = r; j=c;
        while(i>=0 && j<m) {
             if(grid[i][j] == true) return false;
            i--;
            j++;
            
        }
        
        return true;
    }
};