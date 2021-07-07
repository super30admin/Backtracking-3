class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        row = 0  # intitialise the row
        result = []  # get all the viable solution's here

        # create n X n matrix
        board = [[0 for i in range(n)] for j in range(n)]
        self.place_queen(board, row, n, result)
        return result

    def place_queen(self, board, row, n, result):
        # base case
        if row == n:  # case when the complete board is filled appending to the result
            temp = []
            for i in range(n):
                s = ""
                for j in range(n):
                    if board[i][j] == 1:
                        s += 'Q'
                    else:
                        s += '.'
                temp.append(s)
            result.append(list(temp))  # How come direct append works here
            return False
        # case when we have to place the queen
        for i in range(n):
            if self.issafe(board, row, i):
                board[row][i] = 1
                if self.place_queen(board, row+1, n, result):  # if the queen at a particular position works
                    return True
            board[row][i] = 0  # make it 0 for other cases
        return False

    def issafe(self, board, row, col):
        for i in range(row):  # if there is a queen already in any place in the column
            if board[i][col] == 1:
                return False
        row_new = row - 1  # as we are coming top to bottopm , quuens will be place only in rows above us soo row - 1
        col_new = col - 1  # and col -1  as we are cheking ony for the left half
        while row_new >= 0 and col_new >= 0:  # left half
            if board[row_new][col_new] == 1:
                return False
            row_new = row_new - 1
            col_new = col_new - 1

        row_new = row - 1  # reinitiating the values
        col_new = col + 1  # as this time w e go to the righ side of the col where we are supoosed to place the queen

        while (row_new >= 0 and col_new < len([board][0])):  # right up diagonal
            if board[row_new][col_new] == 1:
                return False
            row_new = row_new - 1
            col_new = col_new + 1
        return True









