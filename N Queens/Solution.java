import java.util.*;

class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        // result.add(new ArrayList<String>());
        List<String> tempList = new ArrayList<>();
        for(int i=0;i<n;i++){
            //List<String> row = new ArrayList<>();
            String row = "";
            for(int j=0;j<n;j++){
                row += ".";
            }            
           // result.get(0).add(row);
           tempList.add(row);
        }

        solveNQueensHandler(result, tempList, n, 0);
        return result;
    }

    public boolean isSafe(List<String> tempList, int row, int col){

        // left side of current row

        for(int i=0;i<col;i++){
            if(tempList.get(row).charAt(i) == 'Q'){
                return false;
            }
        }

        // upper diagonal

        for(int i=row-1, j=col-1; i>=0&&j>=0; i--, j--){
            if(tempList.get(i).charAt(j) == 'Q'){
                return false;
            }
        }

        //lower diagonal
        for(int i=row+1, j=col-1; i<tempList.size()&&j>=0; i++, j--){
            if(tempList.get(i).charAt(j) == 'Q'){
                return false;
            }
        }

        return true;
    }

    public void solveNQueensHandler(List<List<String>> result, List<String> tempList, int n, int col){

        //base case
        if(col == n){
            result.add(new ArrayList<>(tempList));
            // return true;
        }
        for(int i=0;i<tempList.size();i++){

            //check if safe
            if(isSafe(tempList, i, col) == true){
                
                String temp = tempList.get(i); 
                char[] tempArray = temp.toCharArray();
                tempArray[col] = 'Q';
                temp = String.valueOf(tempArray);
                tempList.remove(i);
                tempList.add(i, temp);
                
                // if(solveNQueensHandler(result, tempList, n, col+1) == true){
                //     return true;
                // }
                solveNQueensHandler(result, tempList, n, col+1);
                
                String tempBacktrack = tempList.get(i); 
                char[] tempBacktrackArray = tempBacktrack.toCharArray();
                tempBacktrackArray[col] = '.';
                tempBacktrack = String.valueOf(tempBacktrackArray);
                
                tempList.remove(i);
                tempList.add(i, tempBacktrack);
            }
        }

        //return false;
    }
}

class Solution {
    public static void main(String[] args){
        System.out.println("NQueens");
        NQueens obj = new NQueens();
        System.out.println(obj.solveNQueens(4));
    }
}