// Time Complexity : O(n!)
// Space Complexity : O(nxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
var result [][] string
var grid [][]bool
var m int

func solveNQueens(n int) [][]string {
    if n == 0{
        return result
    }
    
    result = [][]string{}
    grid = make([][]bool,n)
    for i:=0;i<n;i++{
        grid[i] = make([]bool,n)
    }
    
    m = n
    
    backtrack(0)
    
    return result
}


func backtrack(row int){
    
    // base
    if row == m{
        newlist := []string{}
        for i:=0;i<m;i++{
            word := ""
            for j:=0;j<m;j++{
                if grid[i][j] == true{
                    word += "Q"
                }else{
                    word+="."
                }
                
            }
            newlist = append(newlist,word)
            
        }
        
        result = append(result,newlist)
        
        return
    }
    
    
    //logic 
    for i:=0;i<m;i++{
        if isSafe(row,i){
            grid[row][i] = true
            
            backtrack(row+1)
            
            grid[row][i] = false
        }
    }
}

func isSafe(r,c int) bool{
    
    for i:=r-1;i>=0;i--{
        if grid[i][c]{
            return false
        }      
    }
    
    i := r
    j := c
    
    for i >=0 && j >=0{
        if grid[i][j]{
            return false
        } 
        
        i--
        j--
    }
    
    i = r
    j = c
    
    for i >=0 && j <m {
        if grid[i][j]{
            return false
        } 
        
        i--
        j++
    }
    
    return true
}
