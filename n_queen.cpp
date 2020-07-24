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
