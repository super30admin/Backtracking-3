#Time Complexity: O(N!)
#Space Complexity: O(N*N)
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        row = n
        m = n
        board = [[False] * n for i in range(n)]

        result = []
        
        def issafe(r,c):
            #up
            for i in range(0,r):
                if board[i][c]:
                    return False
                
            i = r
            j = c
            while i >=0 and j < m :
                if board[i][j]:
                    return False
                i -=1
                j +=1
                
            i = r
            j = c
  
            while i >=0 and j >= 0 :
                if board[i][j]:
                    return False
                i -=1
                j -=1
                
            return True
                
            
        def backtrack(row):
            
            if row == m:
                temp = []
                for i in range(m):
                    li = ""
                    for j in range(m):
                        if board[i][j]:
                            li += 'Q'
                        else:
                            li += '.'
                    temp.append(li)
                result.append(temp)
                
            for col in range(m):
    
                if issafe(row,col):
                    board[row][col] = True
                    
                    backtrack(row + 1)
                    
                    board[row][col] = False
                    
                      
        backtrack(0)
        return result