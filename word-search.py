# Time Complexity : O(mn * 3^l) l -> length of the word
# Space Complexity : O(l)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : yes

from typing import List


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.rows = len(board)
        self.cols = len(board[0])
        self.board = board

        for row in range(self.rows):
            for col in range(self.cols):
                if self.backtrack(row, col, word):
                    return True

        # no match found after all exploration
        return False

    def backtrack(self, row, col, suffix):
        # the matched letter in the board would be marked with "#".

        # bottom case: we find match for each letter in the word
        if len(suffix) == 0:
            return True

        # check the current status, before backtracking
        if row < 0 or row == self.rows or col < 0 or col == self.cols or self.board[row][col] != suffix[0]:
            return False

        # mark the choice as # before moving forward
        self.board[row][col] = '#'

        # explore the 4 neighbor in 4 different directions
        for rowOffset, colOffset in [(0, 1), (-1, 0), (0, -1), (1, 0)]:

            if self.backtrack(row + rowOffset, col + colOffset, suffix[1:]):
                return True

        # revert the marking if the visited word isnt used
        self.board[row][col] = suffix[0]

        # if did not find any match in any direction
        return False
