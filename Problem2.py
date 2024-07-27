#I defined a recursive function backtrack that explores all possible directions (up, down, left, right) from the current cell, checking if the characters match the word. To prevent revisiting cells within the same path, I temporarily mark cells as visited by setting them to an empty string. If I find the entire word, I return True; otherwise, I backtrack by restoring the cell's original value. I iterate over each cell in the board, initiating the backtracking process from each cell. The function returns True if the word is found and False otherwise.

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        def backtrack(i, j, k):
            if k == len(word):
                return True
            if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]) or board[i][j] != word[k]:
                return False
            temp = board[i][j]
            board[i][j] = ''
            if backtrack(i+1, j, k+1) or backtrack(i-1, j, k+1) or backtrack(i, j+1, k+1) or backtrack(i, j-1, k+1):
                return True
            board[i][j] = temp
            return False

        for i in range(len(board)):
            for j in range(len(board[0])):
                if backtrack(i, j, 0):
                    return True
        return False