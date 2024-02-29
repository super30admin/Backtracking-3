#
# @lc app=leetcode id=51 lang=python3
#
# [51] N-Queens
#

# @lc code=start
'''
Time Complexity - O(n!). The number of options to place a queen decrease by 2 at every subsequent level
Space Complexity - O(n). We are maintaining a recursive stack in this case.

This code works on Leetcode.
'''

class Solution:
    def __init__(self):
        self.col = set() 
        self.posDiag = set() 
        self.negDiag = set() 
        self.result = []

    def solveNQueens(self, n: int) -> List[List[str]]:
        board = [[False for j in range(n)] for i in range(n)]
        self.helper(board, 0, n)
        return self.result
    
    def helper(self, board, row, n):
        #base
        if row == n:
            boardStr = []
            for i in range(n): #create a string matrix of the scenario and add to final result
                rowStr = ""
                for j in range(n):
                    if board[i][j]:
                        rowStr+="Q"
                    else:
                        rowStr+="."
                boardStr.append(rowStr)
            self.result.append(boardStr)

        #logic
        for c in range(n):
            if c in self.col or (row+c) in self.posDiag or (row-c) in self.negDiag: #if column is occupied in any rows above or if a diagonal is occupied by a previous queen
                continue

            #action
            self.col.add(c)
            self.posDiag.add(row+c) #sum of row and column remains constant along each diagonal
            self.negDiag.add(row-c) #difference between row and column values remain constant along each diagonal
            board[row][c] = True

            #recurse
            self.helper(board, row+1, n)

            #backtrack
            self.col.remove(c)
            self.posDiag.remove(row+c)
            self.negDiag.remove(row-c)
            board[row][c] = False



        
# @lc code=end

