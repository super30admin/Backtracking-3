
N-Queens

public List<List<String>> solveNQueens(int n) {
    List<List<String>> ret = new ArrayList<>();
    dfs(n, 0, new int[n], new ArrayList<>(), ret);
    return ret;
}

private void dfs(int n, int idx, int[] valid, List<String> path, List<List<String>> ret) {
    if (path.size() == n) {
        ret.add(path);
    }
    for (int j = 0; j < n; j++) {
        if (checkValid(valid, idx, j)) {
            valid[idx] = j;
            String s = String.join("", Collections.nCopies(j, "."))+"Q"+
            String.join("", Collections.nCopies(n-j-1, "."));
            List<String> p = new ArrayList<>(path);
            p.add(s);
            dfs(n, idx+1, valid, p, ret);
        }
    }
    
}

private boolean checkValid(int[] valid, int r, int c) {
    for (int i = 0; i < r; i++) {
        if (valid[i] == c || (r-i) == Math.abs(c-valid[i])) {
            return false;
        }
    }
    return true;
}


TC:O(N!)
SC:O(N^2)


Word Search

class Solution {
    public boolean exist(char[][] b, String word) {
        /*Find word's first letter.  Then call method to check it's surroundings */
        for(int r=0; r<b.length; r++)
            for(int c=0; c<b[0].length; c++)
                if(b[r][c]==word.charAt(0) && help(b,word,0,r,c))
                    return true;
        
        return false;
    }
    
    public boolean help(char[][] b, String word, int start, int r, int c){
        /* once we get past word.length, we are done. */
        if(word.length() <= start)
            return true;
        
        /* if off bounds, letter is seen, letter is unequal to word.charAt(start) return false */
        if(r<0 ||c<0 || r>=b.length || c>=b[0].length || b[r][c]=='0' || b[r][c]!=word.charAt(start))
            return false;
        
        /* set this board position to seen. (Because we can use this postion) */
        char tmp = b[r][c];
        b[r][c] = '0';
        
        /* recursion on all 4 sides for next letter, if works: return true */
        if(help(b,word,start+1,r+1,c) ||
          help(b,word,start+1,r-1,c) ||
          help(b,word,start+1,r,c+1) ||
          help(b,word,start+1,r,c-1))
            return true;
        
        //Set back to unseen
        b[r][c] = tmp;
        
        return false;
    }
}


