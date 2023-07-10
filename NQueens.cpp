// Time Complexity: O(n^2)
// Space Complexity: O(n)


class Solution {
public:
    vector<vector<string>> result; 
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> grid(n, vector<string>(n, "."));

        for(int j = 0; j < n; j++) {
            cout << "Starting on: 0," << j << endl; 
            grid[0][j] = "Q"; 
            helper(grid, 1, 0, n);
            grid[0][j] = "."; 
            cout << endl << endl << endl; 
        }

        return result; 
          
    }

    void helper(vector<vector<string>>& grid, int row, int col, int n) {
        //base
        if(row == n) {
            vector<string> intermediateResult; 
            for(int i = 0; i < n; i++) {
                string s = ""; 
                for(int j = 0; j < n; j++) {
                    s += grid[i][j]; 
                }
                intermediateResult.push_back(s);
            }

            result.push_back(intermediateResult);  
            return; 
        }

        //logic
        /*
            Check Column
            Check Diagonal
            If all is good, place Queen there. 
        */

        for(int j = 0; j < n; j++) {
            if(checkColumn(grid, row, j) && checkDiagonals(grid, row, j, n)) {
                grid[row][j] = "Q"; 
                helper(grid, row+1, 0, n); 
                grid[row][j] = "."; 
            }
        }
       
        
    }

    bool checkColumn(vector<vector<string>>& grid, int row, int col) {
        for(int i = row; i >= 0; i--) {
            if(grid[i][col] == "Q"){ 
                return false;
            }; 
        }
        //cout << "column: row,col: " << row << " " << col << endl; 
        return true; 
    }

    bool checkDiagonals(vector<vector<string>>& grid, int row, int col, int n) {
        cout << "diagonal: row,col: " << row << " " << col << endl; 
        //Check Left Diagonal
        int i = row; 
        int j = col; 
        while( i >= 0 && j >= 0) {
            if(grid[i][j] == "Q") return false; 
            i--; 
            j--; 
        }

        //Check Right Diagonal 
        i = row; 
        j = col; 
        while( i >= 0 && j < n) {
            if(grid[i][j] == "Q") return false; 
            i--; 
            j++; 
        }


        return true;     
    }
};