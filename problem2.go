// Time Complexity : O(mxnx3^L)
// Space Complexity : O(L) where L is length of word/stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//TC - (mxnx3^L)
//SC - O(L)

var visited [][]bool
var isValid bool
func exist(board [][]byte, word string) bool {
    if len(board) == 0 && len(word) != 0{
        return false
    }
    
    isValid = false
    m:= len(board)
    n := len(board[0])
    visited  = make([][]bool,m)
    for i:=0;i<len(visited);i++{
        visited[i] = make([]bool,n)
    }
    
    for i:=0;i<m;i++{
        for j:=0;j<n;j++{
            if string(board[i][j]) == string(word[0]){
                visited[i][j] = true
                dfs(board,word,1,i,j)
                visited[i][j] = false
            }
        }
    }
    
    return isValid
}

func dfs(board [][]byte,word string,index,row,col int){
    
    if index == len(word){
        isValid = true
        return
    }
    
    dirs := [][]int{{-1,0},{1,0},{0,-1},{0,1}}
    for _,dir := range dirs{
        nr := row + dir[0]
        nc := col + dir[1]
        if nr >= 0 && nr < len(board) && nc >=0 && nc < len(board[0]) && string(board[nr][nc]) == string(word[index]) && visited[nr][nc] == false{
            visited[nr][nc] = true
            dfs(board,word,index+1,nr,nc)
            visited[nr][nc] = false
        } 
        
    }
    
}


//Without Visited Array
func exist(board [][]byte, word string) bool {
    if len(board) == 0 && len(word) != 0{
        return false
    }
    
    isValid = false
    m:= len(board)
    n := len(board[0])
    
    for i:=0;i<m;i++{
        for j:=0;j<n;j++{
            if string(board[i][j]) == string(word[0]){
                c := board[i][j]
                board[i][j] = '#'
                dfs(board,word,1,i,j)
                board[i][j] = c
            }
        }
    }
    
    return isValid
}

func dfs(board [][]byte,word string,index,row,col int){
    
    if index == len(word){
        isValid = true
        return
    }
    
    dirs := [][]int{{-1,0},{1,0},{0,-1},{0,1}}
    for _,dir := range dirs{
        nr := row + dir[0]
        nc := col + dir[1]
        if nr >= 0 && nr < len(board) && nc >=0 && nc < len(board[0]) && string(board[nr][nc]) == string(word[index]) && board[nr][nc] != '#'{
            c := board[nr][nc]
            board[nr][nc] = '#'
            dfs(board,word,index+1,nr,nc)
            board[nr][nc] = c
        } 
        
    }
    
}


//With return

func exist(board [][]byte, word string) bool {
    if len(board) == 0 && len(word) != 0{
        return false
    }
    
    isValid = false
    m:= len(board)
    n := len(board[0])
    
    for i:=0;i<m;i++{
        for j:=0;j<n;j++{
            if dfs(board,word,0,i,j){
                return true
            }
        }
    }
     
    return false
}

func dfs(board [][]byte,word string,index,row,col int) bool{
    
    if index == len(word){
        
        return true
    }
    
    if row < 0 || col < 0 || row == len(board)  || col == len(board[0]) || board[row][col] == '#'{
        return false
    }
    
    if board[row][col] == word[index]{
        c := board[row][col]
        board[row][col] = '#'
        dirs := [][]int{{-1,0},{1,0},{0,-1},{0,1}}
        for _,dir := range dirs{
            nr := row + dir[0]
            nc := col + dir[1]
            
            if dfs(board,word,index+1,nr,nc){
                return true
            }
            
        }
        board[row][col] = c    
    }
    
    return false
}
