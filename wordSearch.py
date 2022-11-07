"""
Approach --
1. We move in 4 directions T, D, L, R
2. Start with the 1st char of the given string, check in 4 dirs.
3. if the next char in string is found, continue to search the 3rd char in 4 directions.
4. Maintain another boolean matrix of same row and cols. Every tie a char is found from string,
mark the position as T in the boolean matrix
5. If you reach the end of the string, then the string is found.
6. While traversing if a char is not found, go back to previous character and search in remaining 3 dirs.
Note, here DFS fails since the boolean matrix we have already marked the previously found char as T
Hence, it is a Backtracking problem since DFS fails
Note- to save space we are just replacing chars in original matrix with '#'


TC - O(2^n)
SC - O(l) -- where l is length of string

if visited array was use -
sc - O(mxn) or O(l) -- whichever is bigger
"""

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.ROWS = len(board)
        self.COLS = len(board[0])
        self.board = board

        for row in range(self.ROWS):
            for col in range(self.COLS):
                if self.backtrack(row, col, word):
                    return True

        # if no matches found
        return False


    def backtrack(self, row, col, suffix):
        # check bottom case - given word is empty
        if len(suffix) == 0:
            return True

        # 1. check invalid state i.e. 1st suffix word does not match currrent cell or crrent cell position
        # is out of boundry
        if row < 0 or row == self.ROWS or col < 0 or col == self.COLS or self.board[row][col] != suffix[0]:
            return False

        ret = False
        self.board[row][col] = "#"

        # 2. check valid state - explore via backtracking using DFS
        for rowoffset, coloffset in [(0, 1), (1, 0), (0, -1), (-1, 0)]:
            ret = self.backtrack(row + rowoffset, col + coloffset, suffix[1:])

            # break instead of returning directly
            if ret: break

        # clean slate
        self.board[row][col] = suffix[0]

        return ret