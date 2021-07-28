# Time Complexity: O(N. 3^L), where N - mn (rows x cols) and L - length of the word
# Space Complexity: O(L), where L - length of the word (height of the tree)
# Did this code successfully run on Leetcode: Yes

# Solution:

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if not board or len(board) == 0:
            return False

        self.rows = len(board)
        self.cols = len(board[0])

        # Iterate through the board
        for i in range(self.rows):
            for j in range(self.cols):
                # Return true if the word is found, else continue searching the other chars in the board
                if self.dfs(board, word, i, j, 0):
                    return True

        return False

    def dfs(self, board: List[List[str]], word: str, i: int, j: int, index: int) -> bool:
        # base
        # If the word is found
        if index == len(word):
            return True

        # If row or col goes out of bounds or if the char is already visited
        if i < 0 or j < 0 or i == self.rows or j == self.cols or board[i][j] == '#':
            return False

        # logic - If the char in matrix matches with the char in word
        if board[i][j] == word[index]:

            # Mark visited
            temp = board[i][j]
            board[i][j] = '#'

            # Explore the neighbors
            dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
            for d in dirs:
                r = i + d[0]
                c = j + d[1]
                if self.dfs(board, word, r, c, index + 1):
                    return True

            # backtrack
            board[i][j] = temp

        return False


