#TC: O(n!)
#SC: O(n x n)

class Solution(object):

    def __isValid(self, board, row, col, n):
        for r in range(row):
            if board[r][col] == 1:
                return False
        r = row - 1; c = col - 1
        while (r >= 0 and c >= 0):
            if (board[r][c] == 1):
                return False
            r -= 1; c -= 1
        r = row - 1; c = col + 1
        while (r >= 0 and c < n):
            if (board[r][c] == 1):
                return False
            r -= 1; c += 1
        return True

    def __convertBoardToString(self, board, n):
        stringQ = ['' for _ in range(n)]
        for r in range(n):
            for c in range(n):
                if (board[r][c] == 1):
                    stringQ[r] += 'Q'
                else:
                    stringQ[r] += '.'
        return stringQ

    def __placeQueens(self, board, row, n, finalList):
        if (row == n):
            finalList.append(self.__convertBoardToString(board, n))
            return
        for col in range(n):
            if self.__isValid(board, row, col, n):
                board[row][col] = 1
                self.__placeQueens(board, row + 1, n, finalList)
                board[row][col] = 0
        return

    def solveNQueens(self, n):
        if (n == 0):
            return []
        finalList = []
        board = [[0 for c in range(n)] for r in range(n)]
        self.__placeQueens(board, 0, n, finalList)
        return finalList