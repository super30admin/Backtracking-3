"""

Given a 2 d array of letters see if a word can be formed as a sequence of adjacent
characters such that no letter is reused once visited

Runs on leet code. Missed edge case od single letter board [[a]]

Time complexity O(3^N)
Space complexity O(N)
"""
class Solution(object):
    n_row = 0
    n_col = 0
    board = []
    s = ''
    
    def search(self, board, s):
        self.n_row = len(board)
        self.n_col = len(board[0])
        self.board = board
        self.s = s

        if (self.n_row == 1) and (self.n_col == 1) :
            return board[0][0] == s
        
        for row in range(self.n_row):
            for col in range(self.n_col):
                if self.is_valid(row, col, 0):
                    return True
        return False
    
    def is_valid(self, row, col, id):
        
        if id == len(self.s):
            return True
        
        if self.s[id] != self.board[row][col]:
            return False
        
        self.board[row][col] = '-'
        id += 1
        for test_row, test_col in self.neighbour(row, col):
            if self.is_valid(test_row, test_col, id):
                return True
        
        id -=1
        self.board[row][col] = self.s[id]
        
        return False
    
    def neighbour(self, row, col):
        for row_inc, col_inc in zip([-1, 1, 0, 0], [0, 0, -1, 1]):
            new_row = row + row_inc
            new_col = col + col_inc
            if (new_row < self.n_row) and (new_row >= 0) and (new_col < self.n_col) and (new_col >= 0):
                yield new_row, new_col


if __name__ == "__main__":
    sol = Solution()
    print(sol.search([["A"]], "A"))
