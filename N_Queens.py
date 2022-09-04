'''
Time Complexity - O(n!)
Space Complexity - O(n^2)
'''


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.result = []
        board = [[False for i in range(n)] for j in range(n)]
        self.helper(board, 0)
        return self.result

    def helper(self, board, r):
        if r == len(board):
            path = []
            for i in range(len(board)):
                temp = ""
                for j in range(len(board)):
                    if board[i][j] == True:
                        temp += 'Q'
                    else:
                        temp += "."
                path.append(temp)
            self.result.append(path)
            return

        for c in range(len(board)):
            if self.isSafe(board, r, c) == True:
                board[r][c] = True
                self.helper(board, r+1)
                board[r][c] = False

    def isSafe(self, board, r, c):
        for i in range(r):
            if board[i][c] == True:
                return False
        i = r
        j = c

        while (i >= 0 and j >= 0):
            if board[i][j] == True:
                return False
            i -= 1
            j -= 1
        i = r
        j = c
        while (i >= 0 and j < len(board)):
            if board[i][j] == True:
                return False
            i -= 1
            j += 1
        return True
