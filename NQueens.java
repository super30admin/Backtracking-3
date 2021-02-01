class nQueens {
    public List<List<String>> solveNQueens(int n) {

        char matrix[][] = new char[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = '.';
            }
        }
        backtracking(matrix,0,n);
        return answer;
    }

    List<List<String>> answer = new ArrayList<>();

    private void backtracking(char[][] matrix,int index,int queensLeft){
        // base
        if(queensLeft<=0){
            answer.add(makeOutput(matrix));
            return;
        }

        for(int i=0;i<matrix.length;i++){

            if(isSafe(matrix,index,i)){
                matrix[index][i] = 'Q';
                backtracking(matrix,index+1,queensLeft-1);
                matrix[index][i] = '.';
            }
        }
    }

    private List<String> makeOutput(char[][] matrix){
        List<String> returnList = new ArrayList<>();

        for(int i=0;i<matrix.length;i++){
            String temp = "";
            for(int j=0;j<matrix[0].length;j++){
                temp += matrix[i][j];
            }

            returnList.add(temp);
        }

        return returnList;
    }

    private boolean isSafe(char[][] matrix,int i,int j){
        int r = i;
        int c = j;

        // upper column
        while(r>=0){
            if(matrix[r][c]=='Q')
                return false;

            r -= 1;
        }

        r = i;
        c = j;
        //left diagonal
        while(r>=0&&c>=0){
            if(matrix[r][c]=='Q')
                return false;

            r -= 1;
            c -= 1;
        }

        r = i;
        c = j;
        //right diagonal
        while(r>=0 && c<matrix.length){
            if(matrix[r][c]=='Q')
                return false;

            r -= 1;
            c += 1;
        }

        return true;
    }
}