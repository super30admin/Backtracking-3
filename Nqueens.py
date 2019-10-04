# leetcode: partial error
# explaination: we are backtracking here
# check for comments
# time complexity: n*n


class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """

        board = [[0 for i in range(n)] for j in range(n)]
        for row in range(0, n):
            for col in range(0, n):
                board[row][col] = '.'  # take a n * n matrix, and mark everything has .
        result = []
        self.dfs(board, 0, result)  # carry out dfs, coloumnwsie,
        return result

    def dfs(self, board, colIndex, result):
        if colIndex == len(board):  # if we have reached the end of the coloumn
            result.append(self.construct(board))  # add it to result. WE arecalling construct to  add each row as string
            return

        for i in range(0, len(board)):  # iterating all the rows in a coloumn
            if self.validate(board, i, colIndex):  # if validate returns true
                board[i][colIndex] = 'Q'  # place Q there
                self.dfs(board, colIndex + 1, result)  # call dfs again
                board[i][colIndex] = '.'  # else backtrack and place .

    def validate(self, board, r, c):
        for i in range(0, len(board)):
            for j in range(0, c):
                if board[i][j] == 'Q' and (
                        r + j == c + i or r + c == i + j or i == r):  # validate to check if the rookie can be placed in down or diagonally
                    return False
        return True

    def construct(self, board):  # ERROR IN THIS SECTION
        result = []

        for i in range(len(board)):
            s = str((board[i]))
            print(s)
            s.replace("''", "")
            result.append(str(s))

        return result
