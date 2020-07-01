# leetcode: not accepted - wrong output
# no doubts
# explination: we traverse through each character and check for the characters around the directions. you have a condition of not using the character again. so you go to the character according to the input given

# you need to make a choice fom the grid for valid neighbour lookingat the given word. Thenneighbours here are top, down left and right

# all the characteres we visited should be marked.


#      A
#     X/\      A B C C E D
#     S B
#      X/\
#       F C
#         /\X
#         C E
class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        self.board = board
        self.nrows = len(board)
        self.ncols = len(board[0])
        # for i in range(len(board)):
        #    for j in range(len(board[0])):
        for i, rows in enumerate(board):
            for j, val in enumerate(rows):
                # value=board[i][j]
                if self.board[i][j] == word[0]:
                    self.board[i][j] = '-'
                    if (self.backtrack(i, j, 1, word)):
                        return True
                    self.board[i][j] = val
        return False

    def backtrack(self, row, col, curr, word):
        if curr == len(word):
            return True
        for rowindex, colindex in self.neighbours(row, col):
            if self.board[rowindex][colindex] == word[curr]:
                self.board[rowindex][colindex] = '-'
                if (self.backtrack(row, col, curr + 1, word)):
                    return True
                self.board[rowindex][colindex] = word[curr]
        return False

    def neighbours(self, rw, cl):
        for r, c in ((rw + 1, cl), (rw, cl + 1), (rw - 1, cl), (rw, cl - 1)):
            if r < self.nrows and r >= 0 and c < self.ncols and c >= 0 and self.board[r][c] != '-':
                yield (r, c)
                # word[i][j]
