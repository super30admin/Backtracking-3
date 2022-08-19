
//TC - O(n!)
//SC - O(nxn)
class Solution {
    List<List<String>> res;
    int size;
    boolean [][] check;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        check = new boolean[n][n];
        size = n;
        backtrack(0);
        return res;
    }
    
    private void backtrack(int r){
        
        //base
        if(r==size){
            List<String> list = new ArrayList<>();
            //add to list
            for(int i=0;i<size;i++){

                String curr="";
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<size;j++){
                    if(check[i][j]==true){
                        sb.append("Q");
                    }
                    else{
                        sb.append(".");
                        
                    }
                }
                list.add(sb.toString());
            }
            
            res.add(list);
            return;
        }
        
        //logic
        for(int i=0;i<size;i++){
            if(isSafe(r,i)){
                //action
                check[r][i]=true;
                //recurse
                backtrack(r+1);
                //backtrack
                check[r][i]=false;
            }
        }
        
    }
    
    private boolean isSafe(int r,int c){
        
        //check column
        for(int i=r-1;i>=0;i--){
            if(check[i][c]==true) return false;
        }
        //check left diagonal
        int i=r,j=c;
        while(i>=0 && j >=0){
            if(check[i][j]==true) return false;
            i--;
            j--;
        }
        //check right diagonal
        i=r;
        j=c;
        while(i>=0 && j <size){
            if(check[i][j]==true) return false;
            i--;
            j++;
        }
        
        return true;
    }
}