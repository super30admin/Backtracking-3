import java.util.*;

class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        result.add(new ArrayList<String>());
        for(int i=0;i<n;i++){
            //List<String> row = new ArrayList<>();
            String row = "";
            for(int j=0;j<n;j++){
                row += ".";
            }            
            result.get(0).add(row);
        }

        solveNQueensHandler(result, n, 0);
        return result;
    }

    public boolean isSafe(List<List<String>> result, int row, int col){

        // left side of current row

        for(int i=0;i<col;i++){
            if(result.get(0).get(row).charAt(i) == 'Q'){
                return false;
            }
        }

        // upper diagonal

        for(int i=row-1, j=col-1; i>=0&&j>=0; i--, j--){
            if(result.get(0).get(i).charAt(j) == 'Q'){
                return false;
            }
        }

        //lower diagonal
        for(int i=row+1, j=col-1; i<result.get(0).size()&&j>=0; i++, j--){
            if(result.get(0).get(i).charAt(j) == 'Q'){
                return false;
            }
        }

        return true;
    }

    public boolean solveNQueensHandler(List<List<String>> result, int n, int col){

        //base case
        if(col == n){
            return true;
        }
        for(int i=0;i<result.get(0).size();i++){

            //check if safe
            if(isSafe(result, i, col) == true){
                
                String temp = result.get(0).get(i); 
                char[] tempArray = temp.toCharArray();
                tempArray[col] = 'Q';
                temp = String.valueOf(tempArray);
                result.get(0).remove(i);
                result.get(0).add(i, temp);
                
                if(solveNQueensHandler(result, n, col+1) == true){
                    return true;
                }
                
                String tempBacktrack = result.get(0).get(i); 
                char[] tempBacktrackArray = tempBacktrack.toCharArray();
                tempBacktrackArray[col] = '.';
                tempBacktrack = String.valueOf(tempBacktrackArray);
                
                result.get(0).remove(i);
                result.get(0).add(i, tempBacktrack);
            }
        }

        return false;
    }
}

class Solution {
    public static void main(String[] args){
        System.out.println("NQueens");
        NQueens obj = new NQueens();
        System.out.println(obj.solveNQueens(4));
    }
}