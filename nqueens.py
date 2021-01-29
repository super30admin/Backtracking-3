# Time complexity: O(N!) we are starting with row go on n-2, n-4 which is in factorial
# Space complexity: O(M*N) make use of new board and N for keep track of values


class Solution:
    def __init__(self):
        self.ans = []
    
    def solveNQueens(self, n: int) -> List[List[str]]:
        board = [['.' for _ in range(n)] for _ in range(n)]
        self.backtrack(board, 0)
        return self.ans
    
    def backtrack(self, board, row):
        
        if len(board) == row:
            layout = [''.join(board[i]) for i in range(len(board))]
            self.ans.append(layout)
            return
        
        for c in range(len(board)):
            if not self.is_valid_pos(board, row, c):
                continue
            
            board[row][c] = 'Q'
            self.backtrack(board, row + 1)
            # pop this path end
            board[row][c] = '.'
    
    def is_valid_pos(self, board, row, col):
        
        # from top to bottom
        for r in range(len(board)):
            if board[r][col] == 'Q':
                return False
        
        # upper left
        i, j = row - 1, col - 1
        while i >= 0 and j >= 0:
            if board[i][j] == 'Q':
                return False
            i -= 1
            j -= 1
        
        # upper right
        i, j = row - 1, col + 1
        while i >= 0 and j < len(board):
            if board[i][j] == 'Q':
                return False
            i -= 1
            j += 1
        
        return True
        
        
