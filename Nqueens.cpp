class Solution {
public:
    bool isSafe(vector<vector<bool>>& grid, int row, int col) {
        for (int i=0;i<row;i++) {
            if (grid[i][col]) return false;
        }

        int i = row; 
        int j = col;
        while (i >= 0 && j >=0 ) {
            if (grid[i][j]) return false;
            i--;
            j--;
        }

        i = row; 
        j = col;
        while (i >= 0 && j < grid[0].size() ) {
            if (grid[i][j]) return false;
            i--;
            j++;
        }
        return true;
    }

    void backtrack(vector<vector<bool>>& grid, int n, int row, vector<vector<string>>& result) {
        // termination condition
        if (row == n) {
            vector<string> v;
            for (int i=0;i<n;i++) {
                string temp;
                for (int j=0;j<n;j++) {
                    if (grid[i][j]) {
                        temp+="Q";
                    } else {
                        temp+=".";
                    }
                }
                v.push_back(temp);
            }
            result.push_back(v);
        }

        //logic
        for (int col=0; col<n; col++) {
            if (isSafe(grid, row, col)) {
                grid[row][col] = true;
                backtrack(grid, n, row+1, result);
                grid[row][col] = false;
            }
        }
    }

    vector<vector<string>> solveNQueens(int n) {
        vector<vector<bool>> grid(n, vector<bool>(n, false));
        vector<vector<string>> result;
        backtrack(grid, n, 0, result);
        return result;
    }
};
