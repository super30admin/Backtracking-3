## Problem1 
# N Queens(https://leetcode.com/problems/n-queens/)


# N -- No. of Rows and No. of Cols
# Time Complexity : O(N * N!) = O((N + 1)!) = O(N!)
# For each row we have N * (N - 2) * (N - 4) * (N - 6) =  N factorial = N! options
# For each cell we check isSafe function. TC for isSafe function = O(N) -- Linear
# TC for is safe function --- O(2 * N) * All possible combinations
# So O(N) --- to check queen in same column above
# O(N) --- Right diagonal up + Left Diagonal Up

# Space Complexity : O(N^2) -- storing the grid
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# We exhaustively explore all possible combinations to place the queen. We know only one queen can come in a single row. So exhautively
# for each row we go through all the cells(columns) and check if it is safe to put a queen there. If it is safe we put the queen at that cell
# and recurse to the next row. When we have completed all the rows, it means all the queens have been placed. Then we make our valid matrix
# as required in the question and append to the result. The isSafe function checks if the queen can be placed at the given cell or not. There
# are 3 cases to check -- same column all the above rows from the current row, diagonaly right up and diagonally left up.

class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        # check if we can place the queen at cell (i, j) safely
        def isQueenSafe(rowNo, colNo, board):
            # check same column above
            for i in range(rowNo):
                if(board[i][colNo] == "Q"):
                    return False

            # check diagonal up left
            r = rowNo - 1
            c = colNo - 1
            while((r >= 0) and (c >= 0)):
                if(board[r][c] == "Q"):
                    return False
                r -= 1
                c -= 1

            # check diagonal up right
            r = rowNo - 1
            c = colNo + 1
            while((r >= 0) and (c < len(board[r]))):
                if(board[r][c] == "Q"):
                    return False
                r -= 1
                c += 1

            return True

        # exhaustive function to place the queens
        def helper(board, rowNo, allPossRes):
            # base case
            if(rowNo == len(board)):
                # we have placed all the queens successfully
                newRes = []
                for m in range(len(board)): #O(N) -- rows
                    newRes.append("".join(board[m])) # O(N) for each join

                allPossRes.append(newRes)
                return

            # logic
            # for a row checking each cell(column) if we can place the queen
            for k in range(len(board)):
                if(isQueenSafe(rowNo, k, board)):
                    # yes it is safe

                    # action
                    board[rowNo][k] = "Q"
                    # so recurse in the next row
                    helper(board, rowNo + 1, allPossRes)
                    # backtrack
                    board[rowNo][k] = "."

        # create the chess board
        board = []
        for i in range(n):
            row = []
            for j in range(n):
                row.append(".")

            board.append(row)

        allPossRes = []
        helper(board, 0, allPossRes)
        return allPossRes


sol = Solution()
print(sol.solveNQueens(1))
print(sol.solveNQueens(2))
print(sol.solveNQueens(3))
print(sol.solveNQueens(4))
print(sol.solveNQueens(5))