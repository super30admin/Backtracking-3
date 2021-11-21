// Time Complexity : O(N!)
// Space Complexity : O(n^2)
// Any problem you faced while coding this : No

class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
          result=new ArrayList<>();
        char[][] mat=new char[n][n];
        List<String> list=new ArrayList<>();
        helper(mat,n, 0,list);
        return result;
    }
    
    public void helper(char[][] mat,int n, int index, List<String> currList){
        if(index==n){
             result.add(new ArrayList(currList));
            return;
        }
        char[] arr=new char[n];
        Arrays.fill(arr,'.');
        for(int i=0; i<n;i++){
            if(isSafe(mat,n,index,i)){
                  mat[index][i]='Q';
                  arr[i]='Q';
                  currList.add(String.valueOf(arr));
                  helper(mat,n, index+1, currList);
                  arr[i]='.';
                  mat[index][i]='.';
                  currList.remove(currList.size()-1);
            }
        }
    
    }
    
    public boolean isSafe(char[][] board, int n, int row, int col) {
	// check in the column
	for(int i = 0; i <= row; i++) {
		if(board[i][col] == 'Q') {
			return false;
		}
	}

	// check left diagonal
	for(int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
		if(board[i][j] == 'Q')
			return false;
	}

	// check for right diagonal
	for(int i = row, j = col; i >= 0 && j < n; i--, j++) {
		if(board[i][j] == 'Q')
			return false;
	}

	return true;
}
