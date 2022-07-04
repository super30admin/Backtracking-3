"""
Leetcode-https://leetcode.com/problems/n-queens/ (submitted)
TC- O(permutations), SC- O(N^2) for creating board; It can be argued that if the permutation is successful, the board
will be refactored in O(N^2) which is a limited event.
Challenges-Understanding backtracking when the queen isn't safe to put in a current row.
Lecture-https://youtu.be/7cZkbmXlRjM
FAQ-
Can a solution exists without backtracking? Yes, we can send a deep copy of board at every recursion call. Refer
solution below.
What if queen cannot be placed in a row? It will go to the parent and that parent will backtrack parent queen and put
it in a new location by backtracking.


The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a
queen and an empty space, respectively.


Example 1:
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

Example 2:
Input: n = 1
Output: [["Q"]]


Constraints:
1 <= n <= 9
"""


class Solution:
    """
    *most optimized*
    Ideation- Recursion w/ backtracking, TC- O(permutations), SC- O(N^2) for creating board

    To have a successful permutation, i.e., N queen placed on N*N board, there has to be a queen placed on each row.
    So we start of with iterating each row in the board to see if a queen can be placed. If the queen is placed in that
    row, we can increment the row counter and place the next queen, If the queen cannot be placed in that row, we
    return to the parent row and change the position of the queen (backtrack).

    Remember, we are only moving right on each row and only moving row + 1 if the queen is place at the row 'row'.
    So, our successful combination will be when our row pointer reaches outside the row, i.e. row == n (base case).

    Also, while checking if it's safe to put a queen at index i, j in board, we will check if the queen is at index
    above i, or if there is any elements on the diagonal left and right. We don't need to check down of board, since,
    we are moving down of the board with our solution, so there will be no queen at the bottom of the row, so we don't
    need to check the bottom of the row.
    """

    def solveNQueens(self, n: int):
        board = [[0 for i in range(n)] for j in range(n)]
        result = []
        self.helper(board, 0, n, result)
        return result

    def helper(self, board, i, n, result):
        # base - when
        if i == n:
            # refactor board into desired format
            rboard = []
            for i in range(n):
                temp = ''
                for j in range(n):
                    if board[i][j] == 1:
                        temp += 'Q'
                    else:
                        temp += '.'
                rboard.append(temp)
            # append the refactored board to result
            result.append(rboard)
            return

        # logic - put queen in each safe row. If the queen is safe to put on board, place the queen and increment row,
        # or if queen cannot be put in that row, increment row.
        for j in range(n):
            if self.isSafe(board, i, j, n):
                # action
                board[i][j] = 1
                self.helper(board, i + 1, n, result)
                # backtrack
                board[i][j] = 0

    def isSafe(self, board, x, y, n):
        # check top - row changes column stays same
        for i in range(x):
            if board[i][y] == 1:
                return False

        # check left diagonal
        i, j = x - 1, y - 1
        while i >= 0 and j >= 0:
            if board[i][j] == 1:
                return False
            i -= 1
            j -= 1

        # check right diagonal
        i, j = x - 1, y + 1
        while i >= 0 and j < n:
            if board[i][j] == 1:
                return False
            i -= 1
            j += 1

        # if none of the checks returns falls, the position is safe to place the queen
        return True

    """
    Ideation- Recursion w/ no backtracking, TC- O(permutations * N^2), SC- O(N^2) for creating board
    
    The idea remains the same except at every recursion call we send a fresh copy of board which will be O(N^2) for 
    each recursion call.
    """

    def solveNQueens1(self, n: int):
        board = [[0 for i in range(n)] for j in range(n)]
        result = []
        self.helper1(board, 0, n, result)
        return result

    def helper1(self, board, i, n, result):
        # base
        if i == n:
            # refactor board into desired format
            rboard = []
            for i in range(n):
                temp = ''
                for j in range(n):
                    if board[i][j] == 1:
                        temp += 'Q'
                    else:
                        temp += '.'
                rboard.append(temp)
            # append the refactored board to result
            result.append(rboard)
            return
