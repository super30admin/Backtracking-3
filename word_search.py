"""
Problem: 79. Word Search
Leetcode: https://leetcode.com/problems/word-search/
Solution: Backtracking
Time Complexity: O(N * 3^L) where NN is the number of cells in the board and LL is the length of the word to be matched.
    - For the backtracking function, initially we could have at most 4 directions to explore, but further the choices are reduced into 3 (since we won't go back to where we come from)
    - We iterate through the board for backtracking, i.e. there could be N times invocation for the backtracking function in the worst case.
Space Complexity: O(L) where L is the length of the word to be matched.
    - The main consumption of the memory lies in the recursion call of the backtracking function. The maximum length of the call stack would be the length of the word.
Does this code run on Leetcode: Yes
"""


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        # base case
        if board is None or len(board) is 0 or len(board[0]) is 0 or len(word) is 0:
            return False

        # find the first matching char in grid and then apply DFS backtrack
        for row in range(0, len(board)):
            for col in range(0, len(board[0])):
                if board[row][col] == word[0]:
                    if self.backtracking(board, row, col, word, 0):
                        return True
        return False

    def backtracking(self, board, row, col, word, index):
        directions = [[0, -1], [0, 1], [-1, 0], [1, 0]]
        # base case
        if index >= len(word) - 1:
            return True

        prev = board[row][col]
        board[row][col] = '#'

        # recursive case
        for dirs in directions:
            new_row = row + dirs[0]
            new_col = col + dirs[1]
            if new_row >= 0 and new_row < len(board) and new_col >= 0 and new_col < len(board[0]) and board[new_row][
                new_col] == word[index + 1]:
                if self.backtracking(board, new_row, new_col, word, index + 1):
                    return True

        board[row][col] = prev
        return False


