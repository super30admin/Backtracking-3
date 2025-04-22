# Time Complexity: O(n* n!)
# Space Complexity: O(n^2)
# Does this code run on Leetcode? Yes
# Did you face any problems while coding this? No


from typing import List


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        board = [[0 for i in range(n)] for j in range(n)]
        result = []
        self.helper(board, n, 0, result)
        return result
    def helper(self, board, n, row, result):

        if row == n:
            list = []
            for i in range(n):
                listStr = ""
                for j in range(n):
                    if board[i][j]:
                        listStr += 'Q'
                    else:
                        listStr += '.'
                list.append(listStr)
            result.append(list)
            return

        for j in range(n):
            if self.isValid(board, row, j, n):
                board[row][j] = True
                self.helper(board,n, row+1, result)
            board[row][j] = False

    def isValid(self, board, i, j, n):
        r = i
        c = j
        # straight above
        while r>=0:
            if board[r][c]:
                return False
            r -= 1
        # diagonal left up
        r = i
        c = j
        while r>=0 and c>= 0:
            if board[r][c]:
                return False
            r -= 1
            c -=1
        # diagonal right up
        r = i
        c = j
        while r>=0 and c<n:
            if board[r][c]:
                return False
            r -= 1
            c += 1
        return True
       