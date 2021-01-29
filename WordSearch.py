'''
    Time Complexity:
        O(mn*3^l)
        (m = length of the board, n = width of the board, l = length of the word)
        (Because our in our DFS tree, each node with have at most 3 children,
        that is, from each cell, we will go in 3 possible directions (because we won't go back).
        And, this DFS will be run at most mn times.)

    Space Complexity:
        O(l)
        (l = length of the word)
        (because at the most, the stack trace will be searching for the l-1th char)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Backtracking approach.
        For each cell on the board:
            -> If the character at cell matches the starting character of the string:
                -> Mark this visited and check neighboring nodes for the next character.
                -> While backtracting, reset the marked character to its original.
'''

VISITED = '.'
DIRECTIONS = [
    (1, 0), (-1, 0), (0, 1), (0, -1)
]

class Solution:
    def __init__(self):
        self.board = []
        self.word = ''

    def exist(self, board: List[List[str]], word: str) -> bool:
        self.board = board
        self.word = word

        for i, row in enumerate(board):
            for j, char in enumerate(row):
                if self.is_char_match(i, j, 0):
                    return True

        return False

    def is_char_match(self, row, col, idx):
        if idx == len(self.word):
            return True

        if row not in range(len(self.board)):
            return False

        if col not in range(len(self.board[row])):
            return False

        char = self.board[row][col]
        if char != self.word[idx] or char == VISITED:
            return False

        self.board[row][col] = VISITED

        for i, j in DIRECTIONS:
            r = row + i
            c = col + j
            if self.is_char_match(r, c, idx + 1):
                return True

        self.board[row][col] = char
        return False
