'''
Solution:
1.  This can be solved using Backtracking on the given board by placing N-Queens one row after the other
2.  First start placing queen on a particular cell and explore valid cells in the below rows and backtrack once the
    board is explored
3.  Add all the valid configurations to the final result.

Time Complexity:    O(n!)
Space Complexity:   O(n x n) - we have one extra board that we check

--- Passed all testcases on Leetcode successfully
'''

class NQueens(object):

    def __isValid(self, board, row, col, n):

        #   check whether we can place queen in the current cell or not

        #   check all rows and same column above the current cell
        for r in range(row):
            if board[r][col] == 1:
                return False

        #   check diagonally top left above the current cell
        r = row - 1; c = col - 1
        while (r >= 0 and c >= 0):
            if (board[r][c] == 1):
                return False
            r -= 1; c -= 1

        #   check diagonally top right above the current cell
        r = row - 1; c = col + 1
        while (r >= 0 and c < n):
            if (board[r][c] == 1):
                return False
            r -= 1; c += 1

        #   return true if everything is fine
        return True

    def __convertBoardToString(self, board, n):

        #   function to convert board of 0s and 1s to the specified string format of '...Q..'

        stringQ = ['' for _ in range(n)]

        for r in range(n):
            for c in range(n):
                if (board[r][c] == 1):
                    stringQ[r] += 'Q'
                else:
                    stringQ[r] += '.'

        return stringQ

    def __placeQueens(self, board, row, n, finalList):

        #   base case to add valid board configuration
        if (row == n):
            finalList.append(self.__convertBoardToString(board, n))
            return

        #   for each column in the current row
        for col in range(n):

            #   place the queen only if the current cell is valid
            if self.__isValid(board, row, col, n):

                #   action -- mark the cell as 1 and check for below rows
                board[row][col] = 1

                #   recursion -- place queen on below rows
                self.__placeQueens(board, row + 1, n, finalList)

                #   backtrack -- mark the cell 0 again once all the below rows are explored
                board[row][col] = 0

        return

    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        #   edge case check
        if (n == 0):
            return []

        finalList = []

        #   initialize the board
        board = [[0 for c in range(n)] for r in range(n)]

        #   start placing the queen on the first row
        self.__placeQueens(board, 0, n, finalList)

        #   return final result
        return finalList