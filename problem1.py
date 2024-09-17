'''
Time Complexity: O(N!)
Space Complexity: O(N)
Did this code successfully run on Leetcode : Yes
Explanation: Create a complete space of all possible combinations and backtrack whenever we find a valid solution.
The valid condition here is to check if there are no queens vertically or horizontally or to its diagonal.
We check horizontally using the for loop as we can place only 1 queen at a time and we check vertically and diagonal
using the canplace function
'''
import copy


class Solution:
    def convertToBoard(self, n, result):
        row = ['.'] * n
        boards = []
        for placement in result:
            board = []
            for col in placement:
                row[col] = 'Q'
                board.append("".join(row))
                row[col] = '.'
            boards.append(board)
        return boards

    def backTrack(self, solution: list, state: list, n: int, row: int):
        # goalState
        if row == n:
            solution.append(copy.deepcopy(state))

        for j in range(0, n):
            if self.canPlace(state, n, row, j):
                # place the queen, here the index in state refers to the row position ie [0] of state
                # and the value ie j is the column position
                state.append(j)
                # backTrack
                self.backTrack(solution, state, n, row + 1)
                # put it back
                # print(solution)
                state.pop()

    def canPlace(self, state: list, n: int, row: int, col: int) -> bool:
        # check vertical self and diagonal

        return self.vertical(state, row, col, n) and self.diagonal(state, row, col, n)

    def vertical(self, state: list, row: int, col: int, n: int) -> bool:
        i = row - 1
        while i >= 0:
            # i is the row and state[i] gives the column
            if state[i] == col:
                return False
            i -= 1

        return True

    def diagonal(self, state: list, row: int, col: int, n: int) -> bool:
        i = row - 1
        j = col - 1

        while i >= 0 and j >= 0:
            if state[i] == j:
                return False
            i -= 1
            j -= 1

        i = row - 1
        j = col + 1

        while i >= 0 and j < n:
            if state[i] == j:
                return False
            i -= 1
            j += 1

        return True

    def solveNQueens(self, n: int) -> List[List[str]]:
        solution = []
        state = []
        self.backTrack(solution, state, n, 0)
        print(solution)
        return self.convertToBoard(n, solution)