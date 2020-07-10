/**
 * Time: Exponential - (n^n)
 * Space: O(n)
 */
class Solution {

    List<List<String>> res;
    int[] col;
    char[][] lst;
    int[][] dirs = new int[][]{{-1,-1},{-1,0},{-1,1}};

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        lst = new char[n][n];
        col = new int[n];

        Arrays.fill(col,0);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                lst[i][j] = '.';
            }
        }

        helper(n,0);

        return res;
    }
    private void helper(int n, int index){
        //base case
        if(n == index){
            List<String> newlst = new ArrayList<>();
            int c = 0;
            while(c<n){
                newlst.add(new String(lst[c]));
                c++;
            }
            res.add(newlst);
            return;
        }

        //cases: traverse thr each n locations in the row index and chk if further locations can place its queen in safe loc leading to a success case

        for(int i=0;i<n;i++){
            if(safe(index,i)){
                lst[index][i] = 'Q';
                col[i] = 1;
                helper(n,index+1);
                col[i] = 0;
                lst[index][i] = '.';
            }
        }
    }

    private boolean safe(int index, int i){
        //if(lst[index][i-1] == 'Q' || lst[index][i+1] == 'Q' || lst[index][i] == 'Q') return false;
        // for(int[] dir: dirs){
        //     int r = index + dir[0];
        //     int c = i + dir[1];
        //     if(!chkQ(r,c)) return false;
        // }
        // if(col[i] == 1) return false;
        // return true;

        // chk previous row
        if(col[i] == 1)return false;

        //chk previous left and right diagonal
        int row = index-1, lcol = i-1, rcol = i+1;
        while(row>=0 && lcol >= 0){
            if(lst[row][lcol] == 'Q') return false;
            lcol--;
            row--;
        }
        row = index-1;
        while(row>=0 && rcol<lst.length){

            if(lst[row][rcol] == 'Q') return false;
            rcol++;
            row--;
        }
        return true;

    }

    private boolean chkQ(int index, int i){
        if(index < 0 || i < 0 || i>= lst.length) return true;
        if(lst[index][i] == 'Q') return false;
        return true;
    }
}