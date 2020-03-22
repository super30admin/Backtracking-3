# Time complexity:O(m*n)
# Space complexity: 0(m*n)
# Did code run successfully on leetcode: yes
# Any problem you faced: No



class Solution {
    public List<List<String>> solveNQueens(int n) {
        List <List<Integer>> solution = new LinkedList<>();
        List<Integer> state = new ArrayList<>();
        backtrack(solution, state, n, 0);
        System.out.println(solution);

        return null;
    }

    private void backtrack(List<List<Integer>> solution, List<Integer> state, int n, int row){

        if(row == n){
            solution.add(new LinkedList<>(state));
            return;
        }

        for(int j = 0; j < n; j++){
            if(canPlace(state, n, row, j)){
                state.add(j);
                backtrack(solution, state, n, row + 1);
                state.remove(state.size() - 1);
            }
        }
    }

    private boolean canPlace(List<Integer> state, int n, int row, int col){

        return verticalSafe(state, row, col, n) && diagonalSafe(state, row, col, n);
    }

    private boolean verticalSafe(List<Integer> state, int row, int col, int n){
        int i = row - 1;
        while(i >= 0){
            if(state.get(i) == col)
                return false;
             i--;
        }
       return true;
    }

    private boolean diagonalSafe(List<Integer> state, int row, int col, int n){

        int i = row - 1;
        int j = col - 1;
        while(i >= 0 && j >= 0){
            if(state.get(i) == j){
                return false;
            }
            i--; j--;
        }

        i = row - 1 ;
        j = col + 1;
        while(i >= 0 && j < n){
            if(state.get(i) == j){
                return false;
            }
            i--; j++;
        }
        return true;
    }
}
