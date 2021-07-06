"""
Approach: 1) use DFS traversal and move in all 4 directions to look for the string in the board.
2) note that the traversal can start again from the current cell so you have to mark it visited
    a) instead of maintaining another board for keep track of visited cells, we'll chang the char value to indicate that
    it is visited

TC: O(n*3^L) n = number of cells, L = len of string
SC: O(L) the recursion stack can have all the chars in the string

"""

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        for r, row in enumerate(board):
            for c, cell in enumerate(row):
                if self.backtrack(board, word, 0, r, c):
                    return True
        return False

    def backtrack(self, board, word, index, r, c):
        # base
        if index == len(word):
            return True
        if r < 0 or r >= len(board) or c < 0 or c >= len(board[0]) or board[r][c] != word[index]:
            return False

        # action
        temp = board[r][c]
        board[r][c] = '#'

        # logic
        dirs = [[0, 1], [0, -1], [-1, 0], [1, 0]]
        for roff, coff in dirs:
            new_row = r + roff
            new_col = c + coff
            if self.backtrack(board, word, index + 1, new_row, new_col):
                return True

        # backtrack
        board[r][c] = temp