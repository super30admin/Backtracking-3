class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<>();
        List<Integer> State = new ArrayList<>();
        backtrack(State, n, 0, result);
        // System.out.println(result);
        return result;

    }


    private void backtrack(List<Integer>State, int n, int row,List<List<String>> Solution){
        if (row == n){

            Solution.add(converter(new LinkedList<>(State),n));
            return;
        }

        for(int j = 0;j<n;j++){
            if(canPlace(row,j,State,n)){
                State.add(j);
                backtrack(State, n,row+1,Solution);
                State.remove(State.size()-1);
            }
        }
    }
    private boolean canPlace(int row, int col,List<Integer>State, int n ){
        return verticalCheck(row,col,State,n) && diagonalCheck(row,col,State,n);
    }
    private boolean verticalCheck(int row, int col,List<Integer>State, int n){
        int i = row - 1 ;
        while(i>=0){
            if(State.get(i)==col){
                return false;
            }
            i--;
        }
        return true;
    }
    private boolean diagonalCheck(int row, int col,List<Integer>State, int n){
        int  i = row -1; int j = col -1;
        while(i>=0 && j>=0){
            if(State.get(i)==j) return false;
            i--;j--;
        }

        i = row - 1;  j = col + 1;
        while(i>=0 && j<n ){
            if(State.get(i)==j) return false;
            i--;j++;
        }
        return true;

    }
    private List<String> converter( List<Integer> State, int n){
        List<String> tmp = new ArrayList<>();
        for (int i =0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j<n;j++){

                if(j==State.get(i)){
                    sb.append("Q");
                }
                else{
                    sb.append(".");
                }

            }
            tmp.add(sb.toString());
        }
        return tmp;
    }

}