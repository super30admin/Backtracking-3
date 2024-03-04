# https://leetcode.com/problems/word-search/

# Time Complexity : O(M * N * 3^L) where M is number of rows and N is the number of columns in the board and
# L is length of the word to be matched.
# Space Complexity : O(L)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None


# Your code here along with comments explaining your approach in three sentences only
# Approach : We first start the approach by matching the first character. If the string is visited we replace it by '*'
# and then we backtrack in all the directions if we match a character, we increment the index. If we reach the length
# of the word, then we will return True.

from typing import List


class Solution:
    dir_x = [1, -1, 0, 0]
    dir_y = [0, 0, 1, -1]

    def exist(self, board: List[List[str]], word: str) -> bool:
        max_row, max_col = len(board), len(board[0])
        for row in range(max_row):
            for col in range(max_col):
                if board[row][col] == word[0]:
                    if self.backtrack(board, word, row, col, 0):
                        return True
        return False

    def backtrack(self, board, word, row, col, index):
        if index == len(word):
            return True

        if row < 0 or col < 0 or row == len(board) or col == len(board[0]) or board[row][col] == '*':
            return False

        if board[row][col] == word[index]:
            board[row][col] = '*'

            for i in range(4):
                new_row = row + self.dir_x[i]
                new_col = col + self.dir_y[i]

                if self.backtrack(board, word, new_row, new_col, index + 1):
                    return True

            board[row][col] = word[index]

        return False
