# Created by Aashish Adhikari at 4:42 PM 2/2/2021


'''
Time Complexity:
O(n !)

Space Complexity:
O(n^2) for the board that we created.
'''

class Solution(object):


    def isSafe(self, board, row, col):

        # check the column
        for idx in range(0, row):
            if board[idx][col] == 1:
                return False


        # check upper left from topright upto this element
        i = row
        j = col
        while i >= 0 and j >= 0:
            if board[i][j] == 1:
                return False
            i -= 1
            j -= 1

        # check upper right from topright upto this element
        i = row
        j = col
        while i >= 0 and j < len(board[0]) :
            if board[i][j] == 1:
                return False
            i -= 1
            j += 1

        # if no condition fails, the return True
        return True







    def recurse(self, board, row):
        # base case when you reach beyond the last row
        if row == len(board):



            one_sol = []

            for i in range(0,len(board)):
                sol_row = ""
                for j in range(0,len(board[0])):

                    if board[i][j] == 1:
                        sol_row = sol_row + "Q"
                    else:
                        sol_row = sol_row + "."

                one_sol.append(sol_row)

            self.result.append(one_sol)

        else:
            # logic:
            for col in range(0, len(board)):
                if self.isSafe(board, row, col): #  check upt the row above the current row

                    # action
                    board[row][col] = 1



                    # recurse
                    self.recurse(board, row+1) # go to the next row since the current row is done

                    # backtrack
                    board[row][col] = 0



    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """


        if n == 0:
            return []
        if n == 1:
            return [["Q"]]

        self.result = []
        board = [[0 for idx in range(n)] for idxx in range(n)]

        self.recurse(board, 0,)

        return self.result


