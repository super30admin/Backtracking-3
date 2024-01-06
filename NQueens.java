class Solution {

    List<List<String>> result = new ArrayList();

    public List<List<String>> solveNQueens(int n) {
        
        int[] left = new int[n];
        int[] left_top_diagonal = new int[2 * n];
        int[] left_bottom_diagonal = new int[2 * n];
        char[][] c = new char[n][n];

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                c[i][j] = '.';

        helper(n, 0, left, left_top_diagonal, left_bottom_diagonal, c);
        return result;
    }

    private void helper(int n, int col, int[] left, int[] left_top_diagonal, int[] left_bottom_diagonal, char[][] c)
    {
        if(col == n)
        {
            List<String> list = new ArrayList();

            for(int i = 0; i < n; i++) list.add(new String(c[i]));

            result.add(list);
            return;
        }

        for(int row = 0; row < n; row++)
        {
            if(left[row] == 0 && left_bottom_diagonal[row + col] == 0 && left_top_diagonal[n - 1 + col - row] == 0)
            {
                c[row][col] = 'Q';
                left[row] = 1;
                left_bottom_diagonal[row + col] = 1;
                left_top_diagonal[n - 1 + col - row] = 1;

                helper(n, col + 1, left, left_top_diagonal, left_bottom_diagonal, c);
                
                c[row][col] = '.';
                left[row] = 0;
                left_bottom_diagonal[row + col] = 0;
                left_top_diagonal[n - 1 + col - row] = 0;
            }
        }
    }
}