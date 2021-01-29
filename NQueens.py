'''
    Time Complexity:
        O(n!) (because we checking all possible ways of checking placement)

    Space Complexity:
        O(n) (because at the most, the stack trace will have all n rows)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Backtracking approach.
        Start with the first row.
            Start with the frist col:
                -> Check if we can add a Queen at this row and column.
                    -> Add a Queen
                    -> Check for the next row
                    -> Remove the queen (because we have to return all possible ways)

        To check if we can add a Queen at a particular row and column:
            -> Check if there a Queen at any row (above this row) in the current column.
            -> Check if there a Queen at any cell diagonally above this row and left of this column.
            -> Check if there a Queen at any cell diagonally above this row and right of this column.
'''

QUEEN = 'Q'
EMPTY = '.'

class Solution:
    def __init__(self):
        self.board = []
        self.n = 0
        self.result = []


    def solveNQueens(self, n: int) -> List[List[str]]:
        self.board = [[EMPTY] * n for _ in range(n)]
        self.n = n
        self.add_queen(0)

        return self.result


    def add_queen(self, row):
        if row == self.n:
            self.build_result()
            return

        for col in range(self.n):
            if not self.can_add_at(row, col):
                continue

            self.board[row][col] = QUEEN
            self.add_queen(row + 1)
            self.board[row][col] = EMPTY


    def can_add_at(self, row, col):
        if not self.is_col_safe(row, col):
            return False

        if not self.is_left_up_safe(row, col):
            return False

        if not self.is_right_up_safe(row, col):
            return False

        return True


    def is_col_safe(self, row, col):
        while row >= 0:
            if self.board[row][col] == QUEEN:
                return False

            row -= 1

        return True


    def is_left_up_safe(self, row, col):
        while row >= 0 and col >= 0:
            if self.board[row][col] == QUEEN:
                return False

            row -= 1
            col -= 1

        return True


    def is_right_up_safe(self, row, col):
        while row >= 0 and col < self.n:
            if self.board[row][col] == QUEEN:
                return False

            row -= 1
            col += 1

        return True


    def build_result(self):
        res = []

        for row in self.board:
            r = ''.join(row)
            res.append(r)

        self.result.append(res)
