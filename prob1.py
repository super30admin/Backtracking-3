# Time Complexity: O(n!)
# Space Complexity: O(n^2)
# Did this run successfully on Leetcode: Yes
# Any issues faced while coding: minor isues while coding
# Explain your approach: check if a particular (row, col) is safe and continue to next rows and cols
# if unsafe, backtrack, and at the end of each board, if add the combination to result


class Solution:

    def solveNQueens(n):

        board = [[False for _ in range(n)] for _ in range(n)]
        result = []

        def dfs(row):

            # base
            if row == n:
                li = []
                for i in range(n):
                    temp = []
                    for j in range(n):
                        if board[i][j] == True:
                            temp.append("Q")
                        else:
                            temp.append(".")
                    li.append("".join(temp))
                result.append(li)


            # logic
            for j in range(n):

                # action
                if isSafe(row, j):

                    board[row][j] = True
                    
                    # recurse
                    dfs(row+1)

                    # backtrack
                    board[row][j] = False

        def isSafe(r, c):

            # column check
            for i in range(r):
                if board[i][c] == True:
                    return False
                
            # diagonal up left check
            i, j = r, c
            while i >= 0 and j >= 0:
                if board[i][j] == True:
                    return False
                i -= 1
                j -= 1

            # diagonal up left check
            i, j = r, c
            while i >= 0 and j < len(board[0]):
                if board[i][j] == True:
                    return False
                i -= 1
                j += 1
            return True
                
        dfs(0)
        return result




