# Time O(n ^ n)
# Space : O(n*n) board size, recurse stack space: O(n)
# Time O()
class Solution:

    def solveNQueens(self, n: int) -> List[List[str]]:
        board = [["."] * n for i in range(n)]
        result = []
        self.placeQueen(board, n, 0, result)
        return result
    
    def isValidPlacement(self, board: List[List[str]], n: int, row: int, col: int) -> bool:
        #column check
        for i in range(row):
            if board[i][col] == "Q": return False
        
        # left diagonal
        i = row - 1
        j = col - 1
        while i > -1 and j > -1:
            if board[i][j] == "Q": return False
            i -= 1
            j -= 1

        # right diagonal
        i = row - 1
        j = col + 1
        while i > -1 and j < n:
            if board[i][j] == "Q": return False
            i -= 1
            j += 1
        
        return True

    def placeQueen(self, board: List[List[str]], n: int, row: int, result: List[List[str]]) -> None:
        if row >= n: 
            res = ["".join(board[i]) for i in range(n)]
            result.append(res)

        for col in range(n):
            if self.isValidPlacement(board, n, row, col): 
                board[row][col] = "Q"
                self.placeQueen(board, n, row+1, result)
                board[row][col] = "."

