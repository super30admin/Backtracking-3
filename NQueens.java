class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<Integer> board = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        helper(result, board, 0, n);
        return result;
    }

    public void helper(List<List<String>> result, List<Integer> board, int row, int n){
        if(row == n){
            List<String> res =  new ArrayList<>();
            StringBuilder sb;
            for(int i=0;i<n;i++){
                sb = new StringBuilder("");
                for(int j=0;j<board.get(i);j++)
                    sb.append('.');
                sb.append('Q');
                for(int j=board.get(i)+1;j<n;j++)
                    sb.append('.');
                res.add(sb.toString());
            }
            result.add(res);
            return;
        }
        for(int i=0;i<n;i++){
            board.add(i);
            if(checkValid(board, row))
                helper(result, board, row+1, n);
            board.remove(board.size()-1);
        }

    }

    public boolean checkValid(List<Integer> board, int row){
        return checkRow(board, row) && checkDiag(board, row);
    }
    public boolean checkRow(List<Integer> board, int row){
        int valid = 0;
        int col;
        for(int i=0;i<=row;i++){
            col = board.get(i);
            if( (valid & (1 << col)) > 0 )
                return false;
            valid |= (1 << col);
        }
        return true;
    }
    public boolean checkDiag(List<Integer> board, int row){
        for(int i = 0;i<row;i++){
            for(int j=i+1;j<=row;j++){
                if(Math.abs(i-j) == Math.abs(board.get(i)-board.get(j)))
                    return false;
            }
        }
        return true;
    }
}