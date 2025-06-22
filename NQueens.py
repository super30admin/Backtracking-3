# time o(n!)

from typing import List
# class Solution:
#     def solveNQueens(self, n: int) -> List[List[str]]:
#         self.res = []
#         board = [[False for _ in range(n)] for _ in range(n)]
#         def isSafe(board, r, c):
#             #column up check column remains same
#             for i in range(r):
#                 if board[i][c] : return False
#             #column up left diagonal
#             # dont reduce r and c but take into variables and then reduce
#             i , j= r, c
#             while i>=0 and j>=0:
#                 if board[i][j] : return False
#                 i-=1
#                 j-=1
#             # up right diagonal
#             i,j= r,c
#             while i>=0 and j <len(board):
#                 if board[i][j] : return False
#                 i-=1
#                 j+=1
#             return True

#         def backtrack(board, r):
#             #base
#             if r == len(board):
#                 li = []
#                 for i in range(len(board)):
#                     currStr = ""
#                     for j in range(len(board[0])):
#                         if board[i][j]:     
#                             currStr+="Q"
#                         else:
#                             currStr+="."
#                     li.append(currStr)
#                 self.res.append(li)

#             #logic
#             for j in range(len(board)):
#                 if isSafe(board, r, j):
#                     #action
#                     board[r][j] = True
#                     #recurse
#                     backtrack(board, r+1)
#                     # backtrack
#                     board[r][j] = False

#         backtrack(board,0)
#         return self.res

from typing import List

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.res = []
        board = [[False for _ in range(n)] for _ in range(n)]

        def isSafe(board, r, c):
            # Check column
            for i in range(r):
                if board[i][c]:
                    return False
            # Check upper-left diagonal
            i, j = r, c
            while i >= 0 and j >= 0:
                if board[i][j]:
                    return False
                i -= 1
                j -= 1
            # Check upper-right diagonal
            i, j = r, c
            while i >= 0 and j < len(board):
                if board[i][j]:
                    return False
                i -= 1
                j += 1
            return True

        def backtrack(board, r):
            if r == n:
                li = []
                for i in range(n):
                    row = ""
                    for j in range(n):
                        row += "Q" if board[i][j] else "."
                    li.append(row)
                self.res.append(li)
                return

            for j in range(n):
                if isSafe(board, r, j):
                    board[r][j] = True
                    backtrack(board, r + 1)
                    board[r][j] = False

        backtrack(board, 0)
        return self.res

        