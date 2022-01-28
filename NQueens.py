# Time Complexity : O(N!)
# Space Complexity : O(N^(2))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        
        def canPlaceDia(row, col):
            i = row
            j = col
            while i - 1 > -1 and j - 1 > -1:
                i, j = i - 1, j - 1
                if board[i][j] == 'Q':
                    return False
            i = row
            j = col
            while i - 1 > -1 and j + 1 < n:
                i, j = i - 1, j + 1
                if board[i][j] == 'Q':
                    return False
            
            return True
        
        result = []
        def prepSolution(board):
            nonlocal result
            temp = []
            for row in range(n):
                temp.append("".join(board[row]))
            result.append(temp)
              
                
        def recur(row):
            # base
            if row == n:
                prepSolution(board)
            # logic
            
            for col in range(n):
                if not colSet[col] and canPlaceDia(row, col):
                    board[row][col] = 'Q'
                    colSet[col] = True
                    recur(row + 1)
                    board[row][col] = '.'
                    colSet[col] = False

        board = [['.'] * n for _ in range(n)]
        colSet = [False] * n
        recur(0)
        return result