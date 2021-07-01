'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 51. N-Queens

# The n-queens puzzle is the problem of placing n queens on an n x n 
# chessboard such that no two queens attack each other.

# Given an integer n, return all distinct solutions to the n-queens puzzle. 
# You may return the answer in any order.

# Each solution contains a distinct board configuration of the n-queens
# placement, where 'Q' and '.' both indicate a queen and an empty space,
#  respectively.


#-----------------
# Time Complexity: 
#-----------------
# O(N!) - Place at any of N columns at row == 0, 
#         Next row: N-2 , N-4, N-6 ... which is approx. N!

#------------------
# Space Complexity: 
#------------------
# O(N^2): Size of board . We need to store state of all previous rows...

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.board = [[0]*n for i in range(n)]
        self.result = []
        self.backtrack(0, n)
        return self.result
    
    def backtrack(self, r, n):
        #base
        if r == n: #when all rows (upto index(r)=n-1) have been considered
            li = []
            for i in range(n):
                sb = ""
                for j in range(n):
                    if self.board[i][j] == 1:
                        sb += "Q"
                    else:
                        sb += "."
                li.append(sb)
            self.result.append(li)
            return
        
        # logic
        for j in range(n):
            if self.isSafe(r,j,n):
                # Place queen at cell
                self.board[r][j]  = 1
                
                # Recurse next row
                self.backtrack(r+1, n)
                
                #backtrack
                self.board[r][j] = 0
    
    def isSafe(self, r, c, n):
        # Find if there is a queen 
        
        # in the same column at any previous row
        for i in range(r):
            if self.board[i][c] == 1:
                return False
        
        #diagonal up left

        i = r # start at current row
        j = c # start at current column
        
        #Iterate over the diagonal
        while(i>=0 and j>= 0):
            # If there's a queen there return false
            if self.board[i][j] == 1:
                return False
            i-=1
            j-=1
        
        #diagonal up right
        i=r
        j=c
        while(i >= 0 and j < n):
            if self.board[i][j] == 1:
                return False
            i-=1
            j+=1
        
        return True