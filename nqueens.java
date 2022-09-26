/*
Time Complexity: O(N!)
Space Complexity:  O(N^2)
*/
class Solution {
    char[][] checked;
    List<List<String>> ans;
    int N;
    public List<List<String>> solveNQueens(int n) {
        this.ans = new ArrayList<>();
        this.checked = new char[n][n];
        this.N = n;
        backtrack(0);
        return ans;
    }
    
    private void backtrack(int step){
        if(step == N){
            addToAns();
            return;
        }
        
        for(int i = 0; i < N; i++){
            if(validate(step, i)){
                choose(step, i);
                backtrack(step+1);
                eject(step, i);
            }
        }
    }
    
    private boolean validate(int step, int choice){
        if(checked[step][choice] == 0)
            return true;
        return false;
    }
    
    private void choose(int step, int choice){
        checked[step][choice] = 'Q';
        
        // tell children rows which choices aren't valid
        // choice - 1, choice, choice + 1 per step
        for(int left = choice - 1, right = choice + 1, row = step + 1; row < N; left--, right++, row++){
            if(left >= 0)
                checked[row][left] += 1;
            if(right < N)
                checked[row][right] += 1;
            checked[row][choice] += 1;
        }
    }
    
    private void eject(int step, int choice){
        checked[step][choice] = 0;
        
        // tell children rows which choices are valid again
        // choice - 1, choice, choice + 1 - per step
        for(int left = choice - 1, right = choice + 1, row = step + 1; row < N; left--, right++, row++){
            if(left >= 0)
                checked[row][left] -= 1;
            if(right < N)
                checked[row][right] -= 1;
            checked[row][choice] -= 1;
        }
    }
    
    private void addToAns(){
        List<String> sub = new ArrayList<>();
        for(int r = 0; r < N; r++){
            char[] choices = new char[N];
            for(int c = 0; c < N; c++){
                char choice = checked[r][c];
                if(choice == 'Q')
                    choices[c] = 'Q';
                else
                    choices[c] = '.';
            }
            sub.add(new String(choices));
        }
        
        ans.add(sub);
    }
}