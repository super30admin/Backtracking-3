class NQueens {
    boolean[][] arr ;
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        if(n == 0){
            return new ArrayList<>();
        }
        arr = new boolean[n][n];
        dfs(0, n);
        return result;
    }

    private void dfs(int row, int n){
        //base
        if(arr.length == row){
            List<String> sol = new ArrayList<>();
            for(int i=0;i<arr.length; i++){
                StringBuilder solRow = new StringBuilder();
                for(int j=0;j<arr.length; j++){
                    if(arr[i][j]){
                        solRow.append('Q');
                    }else{
                        solRow.append('.');
                    }
                }
                sol.add(solRow.toString());
            }
            result.add(sol);
            return;
        }

        for(int i=0; i<arr.length; i++){
            if(isSafe(row, i)){
                arr[row][i] = true;
                dfs(row+1, i);
                arr[row][i] = false;
            }
        }

    }

    private boolean isSafe(int row, int col){
        //logic
        for(int i=row; i>=0;i--){
            if(arr[i][col] == true){
                return false;
            }
        }

        int i=row;
        int j=col;
        while(i>=0 && j>=0){
            if(arr[i][j] == true){
                return false;
            }
            i--;
            j--;
        }

        i=row;
        j=col;
        while(i>=0 && j<arr.length){
            if(arr[i][j] == true){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}
