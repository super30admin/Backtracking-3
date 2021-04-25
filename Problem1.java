//N Queens
//tc - O(n!)
//sc - O(n*n) for the matrix
import java.util.*;
class Problem1{
    int[][] matrix;
    int m;
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        if(n==0){
            return res;
        }
        
        matrix = new int[n][n];
        m = n;
        
        backtrack(0);
        
        
        return res;
        
    }
    public void backtrack(int index){
        //base
        if(index==m){
            List<String> curr = new ArrayList<>();
            for(int i = 0;i< matrix.length;i++){
            // res.set(i, new ArrayList<>());
                StringBuilder sb = new StringBuilder();
                for(int j = 0;j< matrix[0].length; j++){
                    if(matrix[i][j] ==1){
                        sb.append("Q");
                    }
                    else{
                        sb.append(".");
                    }
                }
                curr.add(sb.toString());
            }
            res.add(curr);
            return;
        }
        //logic
        //action
        //start placing in each column
        for(int col = 0;col< m; col++){
            if(isValid(index,col)){
                matrix[index][col]=1;   //action
                backtrack(index+1);   ///recurse
                matrix[index][col]=0;   //backtrack matrix[index][col]=0
            }
        }
    }
    public boolean isValid(int row, int col){
        //upper column
        for(int i=0;i< row; i++){
            if(matrix[i][col] == 1){
                return false;
            }
        }
        //uper left diagonal
        int k = row-1, j = col-1;
        while(k >= 0 && j>=0){
            if(matrix[k][j] ==1){
                return false;
            }
            k--;
            j--;
        }
        
        //upper right diagonal
        
        k = row-1;
        j = col+1;
        while(k>=0 && j< m){
            if(matrix[k][j] ==1){
                return false;
            }
                k--;
                j++;
        }
        return true;
    }
    public static void main(String args[]){
        Problem1 p = new Problem1();
        p.solveNQueens(4);
        System.out.println(p.res);
        }

}