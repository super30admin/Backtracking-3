// ## Problem1 
// N Queens(https://leetcode.com/problems/n-queens/)

// Time: O(N!)--> Exponential
// Space: O(N) recursive stack space + O(N^2) for visited array
class Solution {
    private List<List<String>> result;
    private boolean[][] visited;

    // Check if it os safe to place queen at current r,c
    private boolean isSafe(int r, int c, int n){
        // vertical check
        for(int i=0;i<r;i++){
            if(visited[i][c]){
                // queen found
                return false;
            }
        }

        // diagonal up-left
        int i=r, j=c;
        while(i>=0 && j>=0){
            if(visited[i][j]){
                // queen found
                return false;
            }
            i--; j--;
        }

        // diagonal up-right
        i=r; j=c;
        while(i>=0 && j<n){
            if(visited[i][j]){
                // queen found
                return false;
            }
            i--; j++;
        }

        // safe to place
        return true;
    }

    // DFS at given row 'r'
    private void dfs(int r, int n){
        //Base
        if(r==n){
            // Add to result
            List<String> currBoard=new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder currRow=new StringBuilder();
                for(int j=0;j<n;j++){
                    if(visited[i][j]==true){
                        //queen
                        currRow.append('Q');
                    }else{
                        //empty
                        currRow.append('.');
                    }
                }
                currBoard.add(currRow.toString());
            }

            result.add(currBoard);
            return;
        }

        //Logic
        //Place at each col of given row
        for(int c=0;c<n;c++){
            // check if it is safe to place here
            if(isSafe(r,c,n)){
                // action
                visited[r][c]=true;
                //recursion
                dfs(r+1,n);
                //backtrack
                visited[r][c]=false;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.result=new ArrayList<>();
        this.visited=new boolean[n][n];

        // Run dfs starting from first row
        dfs(0,n);

        return result;
    }
}