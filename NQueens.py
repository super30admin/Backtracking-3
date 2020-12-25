class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]

        """
        # Time complexity : There is N possibilities to put the first queen, not more than           #(N - 2) to put the second one, not more than (N - 4) for the third one etc. In            #  total that results in O(N!) time complexity.
        # Space complexity : O(N) to keep an information about diagonals and rows.
        #
#         #exhaustive >>recursion
#         #rethink>>backtrack
#         1)r,c=(0,0)
#         2)no queen in same column, diagonal upper left, upper right>>safe
#         3)place queen
#         4)all 4 Q>take snapshot of chessboard
#         5)backtrack

        # make a grid
        self.board = [[0 for i in range(n)]for i in range(n)]
        self.res = []

        # check if placing Q at particular index is safe
        def safeMove(row, col, n):
            # check for same column in previous rows>if filled with Q >return
            for i in range(row, -1, -1):
                if self.board[i][col] == 1:
                    return False

            # reset and check for upperleft diagonal elements in previous rows>if filled with Q >return
            i = row
            j = col
            while i >= 0 and j >= 0:
                if self.board[i][j] == 1:
                    return False
                i -= 1
                j -= 1

            # reset and check for upperright diagonal elements in previous rows>if filled with Q >return
            i = row
            j = col
            while i >= 0 and j < n:
                if self.board[i][j] == 1:
                    return False
                i -= 1
                j += 1
            return True

        # backtrack function
        def backtrack(row, n):
            # if all rows finished up with valid Q placement>take snapshot with Qs
            if row == n:
                temp = []
                for i in range(n):
                    s = ""
                    for j in range(n):
                        if self.board[i][j] == 1:
                            s += "Q"
                        else:
                            s += "."
                    temp.append(s)
                self.res.append(temp)
                return
            # for each row, I have to check all col combinations for Q placement
            for col in range(n):
                # check validity
                if safeMove(row, col, n):
                    self.board[row][col] = 1  # action >set Q position
                    backtrack(row+1, n)  # recurse>place Q in next row
                    self.board[row][col] = 0  # if base>backtrack Q position
        # start with 1st row
        backtrack(0, n)
        return self.res
