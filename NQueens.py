#Time complexity : O(N!)
#Space Complexity: O(N)
#Run on Leetcode: Yes
#Any issues: No


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        
            self.n = n
            result = []
            board = [["." for _ in range(self.n)] for _ in range(self.n)]
            self.placeQueens(board, 0, result)
            return result

    def placeQueens(self, board, row, result):
            if row >= self.n:
                newResult = [''.join(x) for x in board]
                result.append(newResult)
                # print("result: {0}\n".format(result))
            # loop through each col, and check if we can place a queen
            for col in range(self.n):
                if self.isSafe(board, row, col):
                    board[row][col] = "Q"
                    self.placeQueens(board, row + 1, result)
                    board[row][col] = "."

    def isSafe(self, board, row, col):
            # check this whole col up down
            for r in range(row):
                if board[r][col] == "Q":
                    return False

            # check upper left diagonal
            for r, c in zip(range(row, -1, -1),
                           range(col, -1, -1)):
                if board[r][c] == "Q":
                    return False

            # check upper right diagonal
            for r, c in zip(range(row, -1, -1),
                           range(col, self.n)):
                if board[r][c] == "Q":
                    return False
            return True
