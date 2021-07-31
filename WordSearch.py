# Time Complexity: O(n. 2^n)
# Space Complexity: O(n) - n is length of string
class Solution(object):
    #     Created backtrack function where we will be checking the  if current index next possible children have the word next character until we reach end of the word and during traversing we will make current row and col as any value and after exploring path we will backtrack it to its original value
    def backtrack(self, board, row, col, word, index):
        direc = [[-1, 0], [0, 1], [1, 0], [0, -1]]

        if index == len(word):
            return True
        if len(board) == row < 0 and len(board[0]) == col < 0 and board[row][col] != word[index]:
            return False

        result = False
        curr = board[row][col]
        board[row][col] = "True"

        for d in direc:
            r = row + d[0]
            c = col + d[1]

            if len(board) > r >= 0 and len(board[0]) > c >= 0 and board[r][c] == word[index]:
                result = self.backtrack(board, r, c, word, index + 1)

            if result:
                break

        board[row][col] = curr

        return result

    #   Driver function where we will be iterating over each element in matrix and calling backtrack function only if the current element iis equal to first elemnet in the word
    def exist(self, board, word):
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                if board[i][j] == word[0]:
                    if self.backtrack(board, i, j, word, 1):
                        return True
        return False
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
