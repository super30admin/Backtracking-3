
#Problem 2: N queens
#Time complexity: O(n!)
#Space complexity O(n^2), for the board

'''
We will go row by row and we do normal backtracking by 
recursing and placing att all the valid positions at every
step. To check if it's valid, we check if the column is taken, 
and if there are any queens in two diagonals above. No need to
check the diagonals below, since we will be checking in the next
steps. We will use the memory board (which we keep for the state)
and backtrack. Also it will be useful to check if the position is valid
'''
#Careful, copy of 2d array, you need to copy the outer array but
#also the arrays in side the array

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        memory=[["."]*n for i in range(n)]
        res=[]
        def is_valid(i,j):
            #check the column
            for r in range(i):
                if memory[r][j]=="Q": return False
            #diagonal right
            r,c=i,j
            while 0<=r<n and 0<=c<n:
                if memory[r][c]=="Q": return False
                r-=1
                c+=1  
            #diagonal left
            r,c=i,j
            while 0<=r<n and 0<=c<n:
                if memory[r][c]=="Q": return False
                r-=1
                c-=1
            return True
        
        def helper(i,j):
            #base case and logic
            if not is_valid(i,j):return
            
            if i==n-1:
                memory[i][j]="Q"
                res.append(["".join(row) for row in memory])
                memory[i][j]="."
                return

            #action
            memory[i][j]="Q"
            #recurse
            for c in range(n):
                helper(i+1,c)
            #backtrack
            memory[i][j]="."
        
        for c in range(n):
            helper(0,c)
        return res
