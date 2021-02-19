# // Time Complexity : O(n!)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# BACKTRACK 
# for each row we keep the queen considering attacks from above, diagonal right and diagonal left
# we keep at every colum of every row and check
# We backtrack when we can not place or when we successfully place n queens
# for backtracking we make changes in the board(which we have created)
# when we can place a queen we updated that place with 1
# while backtrack we update same place with 0
# in base condition of the backtracking we check if we reached final row
# and from the board we create array of string and append that to final res

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        
        def backtrack(r):
            #base
            
            if r == n:
                
                tmp = []
                for p in range(n):
                    ans = ""
                    for o in range(n):
                        if board[p][o] == 1:
                            ans += "Q"
                        else:
                            ans += "." 
                    tmp.append(ans)
                res.append(tmp)

            
            #logic
            for j in range(n): #itering in a single row
                if isValid(r,j):
                    
                    #action
                    board[r][j] = 1
                    
                    #recursion
                    backtrack(r+1)
                    
                    #backtrack
                    board[r][j] = 0
                    
            
            
        def isValid(r,j):
            tempr = r
            tempj = j
            #up
            for k in range(r):
                if board[k][j] == 1: return False
            
            #Diagonal Right
            while r>=0 and j<n:
                if board[r][j] == 1:return False
                r -= 1
                j += 1
            j = tempj
            r = tempr
                
            #Diagonal Left
            while r>=0 and j>=0:
                if board[r][j] == 1:return False
                r -= 1
                j -= 1
                
            return True
                
                    
        res= []
        board = [[0]*n for i in range(n)]
        backtrack(0)
        return res     