"""
N Queens(https://leetcode.com/problems/n-queens/)
"""


class Solution:
    """
    Time complexity: O(N!)O(N!)

Unlike the brute force approach, we will only place queens on squares that aren't under attack. For the first queen, we have NN options. For the next queen, we won't attempt to place it in the same column as the first queen, and there must be at least one square attacked diagonally by the first queen as well. Thus, the maximum number of squares we can consider for the second queen is N - 2N−2. For the third queen, we won't attempt to place it in 2 columns already occupied by the first 2 queens, and there must be at least two squares attacked diagonally from the first 2 queens. Thus, the maximum number of squares we can consider for the third queen is N - 4N−4. This pattern continues, resulting in an approximate time complexity of N!N!.

While it costs O(N^2)O(N
2
 ) to build each valid solution, the amount of valid solutions S(N)S(N) does not grow nearly as fast as N!N!, so O(N! + S(N) * N^2) = O(N!)O(N!+S(N)∗N
2
 )=O(N!)

Space complexity: O(N^2)O(N
2
 )

Extra memory used includes the 3 sets used to store board state, as well as the recursion call stack. All of this scales linearly with the number of queens. However, to keep the board state costs O(N^2)O(N
2
 ), since the board is of size N * N. Space used for the output does not count towards space complexity.


    """

    def solveNQueens(self, n: int) -> List[List[str]]:
        self.result = []
        self.board = [[0 for x in range(n)] for y in range(n)]
        print(self.board)
        self.backtrack(0)
        return self.result

    def backtrack(self, row):
        ###base
        if row >= len(self.board):
            ls = []
            for i in range(len(self.board)):
                sb = ""
                for j in range(len(self.board)):
                    if self.board[i][j] == True:
                        sb += "Q"
                    else:
                        sb += "."
                ls.append(sb)
            self.result.append(ls)
            return

        for j in range(len(self.board)):
            if self.isSafe(row, j):
                ##action to put queen over there
                self.board[row][j] = True
                ##recurse
                self.backtrack(row + 1)
                ###backtrack
                self.board[row][j] = False

    def isSafe(self, row, col):
        ###column check if in the same column upwards there is existing queen or not
        for i in range(row):
            if self.board[i][col] == True:
                return False

        ###diagonal check
        ###diagonal up left and diagonal up right
        i = row
        j = col
        while i >= 0 and j >= 0:
            ###diagonal up left
            if self.board[i][j] == True:
                return False
            i -= 1
            j -= 1

        i = row
        j = col
        while i >= 0 and j < len(self.board):
            ###diagonal up right
            if self.board[i][j] == True:
                return False
            i -= 1
            j += 1
        return True


