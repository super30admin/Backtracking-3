class Solution {
    private static final char e='.', q='Q';
    private int n;
        private char[][] board;
        private List<List<String>> r;
        private Set<Integer> colSet, ludSet, rudSet;
    public List<List<String>> solveNQueens(int n) {
        this.n =n;
        board = new char[n][n];
        r = new ArrayList<>();
        colSet=new HashSet<>();
        ludSet=new HashSet<>();
        rudSet=new HashSet<>();

        for(char[] row : board){
            Arrays.fill(row, e);
        }

        snq(0);

        return r;
    }

    private void snq(int row){
        if(row ==n){
            List<String> boardList = new ArrayList<>();
            for(char[] boardRow : board){
                boardList.add(new String(boardRow));
            }
            r.add(boardList);
            return;
        }

        for(int col = 0; col<n; ++col){
            if(isSafe(row,col)){
                board[row][col] =q;
                colSet.add(col);
                ludSet.add(row-col);
                rudSet.add(row+col);
                snq(row+1);
                board[row][col] =e;
                colSet.remove(col);
                ludSet.remove(row-col);
                rudSet.remove(row+col);
            }
        }
    }
    private boolean isSafe(int row, int col){
        return sc(row, col)&&sl(row,col)&&ru(row,col);

    }
    private boolean sc(int row, int col){
        return !colSet.contains(col);}
        private boolean sl(int row, int col){
        return !ludSet.contains(row-col);}
        private boolean ru(int row, int col){
        return !rudSet.contains(row+col);}
}
//tc=n!
//sc=n!
