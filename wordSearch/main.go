// time : o(mn)*3^L where L is len(word)
// space: O(L)
func exist(board [][]byte, word string) bool {
    
    
    m := len(board)
    n := len(board[0])
    dirs := [][]int{{1,0},{-1,0},{0,1},{0,-1}}
    
    var backtrack func(idx, r, c int) bool
    backtrack = func(idx, r, c int) bool {
        
        // base
        if idx == len(word) {return true}
        if r < 0 || r == m || c < 0 || c == n || board[r][c] == '#' {
            return false
        }
        
        
        // logic
        if word[idx] == board[r][c] {
            // action
            tmp := board[r][c]
            board[r][c] = '#'
            // recurse
            for _, dir := range dirs {
                if backtrack(idx+1, r+dir[0], c+dir[1]) {return true}
            }
            // backtrack
            board[r][c] = tmp
        }
        return false
    }
    
    
    for i := 0; i < m ; i++ {
        for j := 0; j < n; j++ {
            if board[i][j] == word[0] {
                if backtrack(0, i, j) {
                    return true
                }
            } 
        }
    }
    
    
    
    return false
}
