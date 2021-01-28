// Time Complexity : O(n!)
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : For each row in the n*n grid, find a valid position to place the queen and then go to the next row, if no valid position is found then backtrack and go to the next valid position and place the queen there.
 
public class NQueens {
    List<List<String>> result = new ArrayList<>();
    int col;
    char[][] grid;
    public List<List<String>> solveNQueens(int n) {
        grid = new char[n][n];
        col = n;
        helper(0);
        return result;
    }
    
    private void helper(int row){
        if(row == col){
            List<String> strList = new ArrayList<>();
            StringBuilder str;
            for(int i = 0; i < col; i++){
                str = new StringBuilder("");
                for(int j = 0; j < col; j++){
                    if(grid[i][j] == 'Q')
                        str.append('Q');
                    else
                        str.append('.');
                }
                strList.add(str.toString());
            }
            result.add(strList);
            return;
        }
        
        for(int i = 0; i < col; i++){
            if(isValid(row, i)){
                grid[row][i] = 'Q';
                helper(row + 1);
                grid[row][i] = '.';
            }
        }
    }
    
    private boolean isValid(int row, int column){
        for(int i = 0; i < row; i++){
            if(grid[i][column] == 'Q')
                return false;
        }
        
        int i = row; int j = column;
        while(i >= 0 && j >= 0){
            if(grid[i][j] == 'Q')
                return false;
            i--;
            j--;
        }
        
        i = row; j = column;
        while(i >= 0 && j < col){
            if(grid[i][j] == 'Q')
                return false;
            i--;
            j++;
        }
        
        return true;
    }
}
