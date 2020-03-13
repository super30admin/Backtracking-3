// Place a queen at a safe column in a row 
	// Move to next row for next queen
	// If all are safe, result is found.
	// Backtrack
List<List<String>> output = new ArrayList();

public List<List<String>> solveNQueens(int n) {
	
    
    
	List<List<Integer>> result = new ArrayList<>();
    List<Integer> stack = new ArrayList<>();
	
    dfs(result, stack, n,0);
    
    createBoard(result);
    
    return output; 
}

private void dfs(List<List<Integer>> result, List<Integer> stack, int n, int row) {
    //goal
	if (row == n) {
        List<String> state = new ArrayList<>();
		result.add(state);
		return;
	}

	for (int col = 0; col < n; col++) {
		if (isValid(state, row, col,n)) {
			state.add(col);
			dfs(result, state, n, row+1);
			state.remove(state.size()-1);
		}
	}
}

private boolean isValid(List<Integer> state, int row, int col, int n) {
	
	int rv = row -1;
    while(r >= 0){
        if(state.get(i) == col){
            return false;
        }
        rv--;
    }
    
    int rpd = row -1, cpd = col -1;
    while(rpd >= 0 && cpd >= 0){
        if(state.get(rpd) == cpd){
            return false;
        }
        rpd--;
        cpd--;
    }
    
    int rsd = row -1, csd = col +1;
    
    while(rsd >= 0 && csd < n){
        if(state.get(rsd) == csd){
            return false;
        }
        rsd--;
        csd++;
    }
	
    return true;
}

 public void createBoard(List<List<Integer> result) {
    List<String> solution = new ArrayList<String>();
    for (int i = 0; i < n; ++i) {
      int col = result.get(i);
      StringBuilder sb = new StringBuilder();
      for(int j = 0; j < col; ++j) sb.append(".");
      sb.append("Q");
      for(int j = 0; j < n - col - 1; ++j) sb.append(".");
      solution.add(sb.toString());
    }
    output.add(solution);
  }
}




