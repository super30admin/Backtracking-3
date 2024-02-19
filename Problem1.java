//Accepted on LT
//Time should be exponnential 

class Solution {
    List<List<String>> l ;
    boolean[][] grid;
    public List<List<String>> solveNQueens(int n) {
        this.l = new ArrayList<>();
        this.grid = new boolean[n][n];
        bct(n,0);
        
        return l;
    }
    public void bct(int n,int r){
        //base
        if(n==r){
            List<String> li = new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sr = new StringBuilder();
                for(int j=0;j<n;j++){
                    if(grid[i][j]){
                        sr.append('Q');

                    }
                    else{
                        sr.append('.');
                    }
                    
                }
                li.add(sr.toString());
            }
            l.add(li);

            return;
        }



        for(int c=0;c<n;c++){
            if(isSafe(r,c,n)){
                //action
                grid[r][c] = true;
                //recurse
                bct(n,r+1);
                //bct
                grid[r][c] = false;
            }


        }
    }

    public boolean isSafe(int r, int c, int n ){
        for(int i=0;i<r;i++){
            if(grid[i][c]) return false;
        }
        int i = r;
        int j=c;
        while(i>=0 && j>=0){
            if(grid[i][j]) return false;
            i--;
            j--;

        }
        int k = r;
        int l=c;
        while(k>=0 && l<n){
            if(grid[k][l]) return false;
            k--;
            l++;

        }
        return true;
    }
}