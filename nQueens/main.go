// time: o(n!)
// space: o(n^2)
func solveNQueens(n int) [][]string {
    if n == 0 {return nil}
    var result [][]string
    
    board := make([][]bool, n)
    for i := 0; i < len(board); i++ {
        board[i] = make([]bool, n)
    }
    
    var backtrack func(row int)
    backtrack = func(row int) {
        //base
        if row == n {
            var tmp []string
            for i := 0; i < n; i++ {
                tmpRow := ""
                for j := 0; j < n; j++ {
                    if board[i][j] == true{
                        tmpRow += "Q"
                    } else {
                        tmpRow += "."
                    }
                }
                tmp = append(tmp, tmpRow)
            }
            result = append(result, tmp)
            return
        }
        
        // logic
        for i := 0; i < n; i++ {
            // check
            if canBePlaced(board, row, i) {
                // action
                board[row][i] = true
                // recurse
                backtrack(row+1)
                // backtrack
                board[row][i] = false
            }
        }
    } 
    
    backtrack(0)
    
    return result
}


func canBePlaced(board [][]bool, r, c int) bool {
    dirs := [][]int{{-1, 0}, {-1,-1}, {-1,1}}
    n := len(board)
    for _, dir := range dirs {
        newR := r + dir[0]
        newC := c + dir[1]
        for newR >= 0 && newR < n && newC >= 0 && newC < n {
            if board[newR][newC] == true{
                return false
            }
            newR = newR + dir[0]
            newC = newC + dir[1]
        }
    }
    return true
}
