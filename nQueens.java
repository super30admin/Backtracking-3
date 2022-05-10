class Solution {

    //Time Complexity : 0(n!) where n is the input
    //Space Complexity : 0(n) where n is the recursive stack
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while writing this code: No

    //In short explain your approach:

    List<List<String>> result;
    boolean isTrue [][];
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        isTrue = new boolean[n][n];
        helper(0);  //passing the row to the recurse as column keeps on changing
        return result;
    }
    public void helper(int row){
        //base
        if(row == isTrue.length){   //checking the no. of queens and printing as per requested output
            List<String> newList = new ArrayList<>();
            for(int c= 0; c < isTrue.length; c++){
                StringBuilder sb = new StringBuilder();
                for(int d = 0; d < isTrue.length; d++){
                    if(isTrue[c][d] == true){
                        sb.append('Q');
                    }
                    else{
                        sb.append('.');
                    }
                }
                newList.add(sb.toString());
            }
            result.add(newList);
        }
        //logic
        for(int i = 0; i < isTrue.length; i++){
            if(isValid(row, i)){    //checking if queen exists in all mentioned dirs
                //action
                isTrue[row][i] = true;
                //recurse
                helper(row + 1);
                //backtrack
                isTrue[row][i] = false;
            }
        }
    }
    public boolean isValid(int row, int column){
        //check for column
        for(int i = 0; i < row; i++){
            if(isTrue[i][column] == true){
                return false;
            }
        }
        int a = row;
        int b = column;
        //check for top right diagonal
        while(a >= 0 && b < isTrue.length){
            if(isTrue[a][b] == true){
                return false;
            }
            a--;
            b++;
        }
        a = row;
        b = column;
        //check for top left diagonal
        while(a >= 0 && b >= 0){
            if(isTrue[a][b] == true){
                return false;
            }
            a--;
            b--;
        }
        return true;
    }
}