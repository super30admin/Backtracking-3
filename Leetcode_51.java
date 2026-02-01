//Backtracking
//Declare a grid - n*n
//Check the possibilty by giving first row first element
//Helper recurssion start with first row first element
//It will check whether it is a valid or not
//If valid, mark as true and go to second row 
//Check for the valid block. If valid go to third row and so on
//At any place where the block is not valid, backtrack. Means make that block of grid as false
//As a base case, add the path to result
//TC: n!
//SC: O( n^2 ) for the board + O( n ) recursive stack space
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        boolean[][] grid=new boolean[n][n];
        helper(grid,0,ans);
        return ans;

        
    }

    private void helper(boolean[][] grid,int i,List<List<String>> result){
        //base case
        if(i==grid.length){
            List<String> curr=new ArrayList<>();
            for(int r=0;r<grid.length;r++){
                StringBuilder sb=new StringBuilder();
                for(int c=0;c<grid[0].length;c++){
                    if(grid[r][c]==true){
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }
                curr.add(sb.toString());
            }
            result.add(curr);
            return;
        }


        //actual logic
        for(int j=0;j<grid.length;j++){
            if(isValid(grid,i,j)){
                grid[i][j]=true;
                helper(grid,i+1,result);
                grid[i][j]=false;
                
            }
            
        }
    }

    private boolean isValid(boolean[][] grid,int i,int j){
        int r=0;
        while(r>=0 && r<i){
            if(grid[r][j]==true){
                return false;
            }
            r+=1;
        }

        r=i-1;
        int c=j-1;

        while(r>=0 && c>=0){
            if(grid[r][c]==true){
                return false;
            }
            r-=1;
            c-=1;
        }

        r=i-1;
        c=j+1;
        while(r>=0 && c<grid.length){
            if(grid[r][c]==true){
                return false;
            }
            r-=1;
            c+=1;
        }

        return true;


    }
}
