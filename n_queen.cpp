// Time Complexity : O(n!)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
// There was a problem with traversal. 
// Your code here along with comments explaining your approach
//1. Create a temp string with all dots. Place Queens at each row and traverse through the columns
//2. If at any column the Queen cannot be placed backtrack
//3. Continue this process to find all possible solutions.

class Solution {
public:
    vector<vector<string>> result;
    vector<vector<string>> solveNQueens(int n) {
        //edge
        if(n<=0) return result;
        
        //string creation
        string s1=".";
            string s2;
        for(int i=0; i<n; i++){
            s2+= s1;
        }
        
        //backtrack;
        vector<string> temp (n, s2);
        backtrack(n, temp, 0);
        return result;
    }
    void  backtrack(int n, vector<string> & temp, int row){
        //return
        if(row==n){
           result.push_back(temp);
            return;
        }
        bool upright = false , upleft = false , up=false;
        for(int col_index=0; col_index<n; col_index++){
             //action: Check if the queen can be places
            if(row==0) temp[row][col_index] ='Q';
            else{
                int i=row-1, j = col_index-1;
                while( i>=0 && j>=0){ //upleft diagonal
                    if(temp[i][j] == 'Q') {
                        upleft = true;  break;
                    }
                    i--;j--;
                }
                i=row-1; j = col_index+1;
                while( i>=0 && j<n){
                    if(temp[i][j] == 'Q'){ //upright diagonal
                        upright = true;  break;
                    } 
                    i--;j++;
                }
                i=row-1;
                while(i>=0){ //up straight
                    if(temp[i][col_index] == 'Q'){
                        up = true; break;
                    } 
                    i--;
                }
             }
            //Check if any place found
            if(upright == false && upleft == false && up==false){ //not found
                    temp[row][col_index] ='Q';
            } else if(upright == true || upleft == true || up==true){ //found
                upright = false , upleft = false , up=false;
                continue;
            }
            //recurse
            backtrack(n, temp, row+1);
            //backtrack
            temp[row][col_index] ='.';
        }
        
    }
};

//Concise solution
class Solution {
public:
    vector<vector<string>> result;
    vector<vector<string>> solveNQueens(int n) {
        //edge
        if(n==0){
            return result;
        }
        if(n==1){
            vector<string> temp {"Q"};
            result.push_back(temp);
            return result;
        }
        
        string str;
        for(int i=0; i<n;i++){
            char c= '.';
            str.push_back(c);
        }
        
        vector<string> temp(n, str);
        back_track(n, 0, temp);
        return result;
    }
    
    void back_track(int n, int row, vector<string>& temp){
        if(row ==n){
            result.push_back(temp);
            return;
        }
        
        for(int i=0; i<n; i++){
            if(cab_be_placed(n, row, i, temp)){
                //action
                temp[row][i] = 'Q';
                //recurse
                back_track(n, row+1, temp);
                //backtrack
                temp[row][i] = '.';
            }
        }
    }
    
    bool cab_be_placed(int n, int row, int col, vector<string>& temp){
        
        for(int r=0; r<row; r++){
            string str= temp[r];
            if(str[col] == 'Q')
                return false;
        }
        int r=row-1;
        int c=col-1;
        while(r>=0 && c>=0){
            string str=temp[r];
            if(str[c] == 'Q')
                return false;
            r--; c--;
        }
        
        r=row-1;
        c=col+1;
        while(r>=0 && c<n){
            string str=temp[r];
            if(str[c] == 'Q')
                return false;
            r--; c++;
        }
        return true;
    }
    
};
