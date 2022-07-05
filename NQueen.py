#51. N-Queens
"""
Time Complexity : O(n!)
Space Complexity : O(n*n)

"""
class Solution:
    result = []
    
    def safe(self, board, r, c, n):
        #function to find is it is safe to place queen at current location r, c or not.
        #we have to check current column, and two diagonals
        
        #up columns
        for i in range(0, r):
            if board[i][c] == True: #same column.
                return False
        
        #up left diagonal
        nr, nc = r, c
        while nr >= 0 and nc >= 0:
            if board[nr][nc] == True:
                return False
            nr = nr - 1
            nc = nc - 1
        
        #up right diagonal
        nr, nc = r, c
        while nr >= 0 and nc < n:
            if board[nr][nc] == True:
                return False
            nr = nr - 1
            nc = nc + 1
        
        return True
    
    def helper(self, board, r, n):
        
        #base here we checl base case as well as convert into required output
        if (r == n ): #we are at last row, means we are done with placing queens in all above rows
            temp_list = []
            #print("h1")
            for i in range(0, n): #i = row
                sb = ""
                for j in range(0, n): #j = column
                    if board[i][j] == True:
                        sb = sb + 'Q'
                    else:
                        sb = sb + '.'
                temp_list.append(sb)
            
            self.result.append(temp_list)        
        
        #logic
        for j in range(0, n): #iterating over columns. n = no. of columns and j = current column, r = current row
            #print("hhh", board[r][j], r,j)
            if (self.safe(board, r, j, n)): #process only if it is safe to place a queen at location r,j   
                
                #action
                board[r][j] = True #it is safe so will place queen there by making element True
                #print(board[r][j], r,j)
                
                #recurse
                #print("in")
                self.helper(board, r+1, n) #done with current row so increment row
                #print("out")
                

                #backtrack
                board[r][j] = False #remove queen while back tracking to explore other possibilities
                #print(board[r][j], r,j)
            
        
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.result = []
        
        #creating n*n board
        #board = [[False]*n]*n #False in board denotes that no queen is present. True represents opposite
        board = [[False] * n for _ in range(n)]
        #null
        
        #logic
        #calling function for backtracking
        self.helper(board, 0, n) #board, row, n
        return self.result
        
