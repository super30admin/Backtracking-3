"""
FAANMG Problem #75 {Medium}

51. N-Queens

       Using backtracking and checking for each row.
        Time Complexity:O(N!) N = the no n given queens
        Space Complexity :O(N^2)


Did this code successfully run on Leetcode : Yes


@name: Rahul Govindkumar_RN27JUL2022
"""  


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        
     
        res = []
        if n == 0: return res
        # Creating the board
        board = [[False for i in range(n)]for j in range(n)]

        def helper_bck(board, row):
            # BAse case
            if row == len(board):
                path = []
                for i in range(len(board)):
                    row_str = ""
                    for j in range(len(board)):
                        if board[i][j] == True:
                            row_str += "Q"   
                        else:
                            row_str += "."

                    path.append(row_str)

                res.append(path)

                return     


            # Logic
            for col in range(len(board)):
                if self.isSafe(board, row, col) == True:

                    # Action
                    board[row][col] = True
                    # Recurse
                    helper_bck(board, row + 1)
                    # back track
                    board[row][col] = False


        helper_bck(board, 0)
        return res


    def isSafe(self, board, r, c):
        # Checking the upward rows
        for i in range(r):
            if board[i][c]: return False

        # Checking the diagonals
        i , j = r, c
        # left diag
        while i >= 0 and j >= 0:
            if board[i][j]:
                return False
            i -= 1
            j -= 1

        # Right diag
        i , j = r, c
        while i >= 0 and j <len(board):
            if board[i][j]:
                return False
            i -= 1
            j += 1

        return True


