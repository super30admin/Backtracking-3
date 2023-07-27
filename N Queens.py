# Time Complexity : O(n^2 * n!)
# Space Complexity : O(n^2)

# The code ran on LeetCode

# Traverse the board row wise, check if a Queen can be placed at a particular index by making sure there are no Queens in the left diagonal, right diagonal and in the current column. If it is safe to place a Queen, move to the next row since there can be only one Queen in a row. Repeat the process until the end of board is reached. At any point, if it is not possible to add a queen after a certain row, backtrack by removing the queen at the current row.

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        board = [[0 for _ in range(n)] for _ in range(n)]
        
        def get_board(board):
            out = []
            for i in range(n):
                temp = ''
                for j in range(n):
                    if board[i][j] == 1:
                        temp+='Q'
                    else:
                        temp+='.'
                out.append(temp)
            return out

        def check_diagonals(board, row, col):
            # Left diagonal
            x, y = row, col
            while x >= 0 and y >= 0:
                if board[x][y] == 1:
                    return False
                x -= 1
                y -= 1
                
            
            # Right diagonal
            x, y = row, col
            while x >= 0 and y < n:
                if board[x][y] == 1:
                    return False
                x -= 1
                y += 1
                
            # Check same column
            for i in range(row):
                if board[i][col] == 1:
                    return False
            return True
            
                

        def helper(n, board, row):
            # Base
            if row == n:
                # copy = [p for p in path]
                b = get_board(board)
                res.append(b)
                return

            for i in range(n):
                if check_diagonals(board, row, i):
                    board[row][i] = 1
                    helper(n, board, row+1)
                    board[row][i] = 0
        helper(n, board, 0)
        return res
