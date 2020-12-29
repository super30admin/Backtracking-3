//Time - O(n!)
//Space - O(n)

class Solution {
public:
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> ret;
        vector<int> row (n,-1);
        
        formTheBoard(ret,row,0,n);
        return ret;
        
    }
    vector<string> createPattern(vector<int> rows){
        
        vector<string> pattern;
        
        for(int i=0;i<rows.size();i++){
           string s = "";
            for(int j=0;j<rows.size();j++){
                if(rows[i] == j) s = s + "Q";
                else s = s + "."; 
            }
            pattern.push_back(s);
        }
       
        return pattern;
        
    }
    
    bool isValid(vector<int> rows, int r, int c){
        for(int i=0;i<rows.size();i++){
            int filledCol = rows[i];
            if(rows[i] != -1){ 
                if(i==r || c == rows[i] || i+rows[i] == r+c || i-rows[i] == r-c) return false;
            }
        }
        return true;
    }
    
    void formTheBoard(vector<vector<string>>& ret, vector<int> rows,int r,int n){
        if(r == n){
            ret.push_back(createPattern(rows));
            return;
        }
        
        for(int i=0;i<n;i++){
            if(isValid(rows,r,i)){
                rows[r] = i; 
                formTheBoard(ret,rows,r+1,n);
                rows[r] = -1;
            }
        }
    }
};