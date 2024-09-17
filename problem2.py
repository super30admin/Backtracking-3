'''
Time Complexity: O(m*n(m*n))
Space Complexity: O(m*n)
Did this code successfully run on Leetcode : Yes
Explanation: Iterate through each character and backtrack if we don't reach the character, mark the character if we found it
along the way
'''


class Solution:
    def isValid(self, board: List[List[str]], i: int, j: int) -> bool:
        return i >= 0 and i < len(board) and j >= 0 and j < len(board[0])

    def backtrack(self, board: List[List[str]], word: str, row: int, col: int, cursor: int) -> bool:
        if cursor == len(word):
            return True

        dx = [-1, 0, 1, 0]
        dy = [0, 1, 0, -1]

        # iterate on neighbor only if character matches

        if self.isValid(board, row, col) and board[row][col] == word[cursor]:

            # remember visited characters
            remember = board[row][col]
            board[row][col] = '$'

            # visit the 4 neighbors

            for i in range(0, 4):
                x = row + dx[i]
                y = col + dy[i]
                # we found all words
                if self.backtrack(board, word, x, y, cursor + 1):
                    return True
            # restore the state
            board[row][col] = remember
        return False

    def exist(self, board: List[List[str]], word: str) -> bool:

        # starting point
        for i in range(0, len(board)):
            for j in range(0, len(board[0])):
                # anytime backTract returns True
                if self.backtrack(board, word, i, j, 0):
                    return True
        return False