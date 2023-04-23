# Time Complexity: O(m*n*(3^l)) where m is the number of rows, n is the number of columns and l is the length of the word
# Space Complexity: O(l) for the recursive stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
We see if a word exists in a 2D board by using DFS. We start by finding the first letter of the word in the board. 
When found we start a DFS to search for the next element in the word. At the same time we make sure to replace the 
found element with # to mark it visited, and to mark it back to the original value when we backtrack. Finally, 
if we reach the end of the word, we return True.
"""

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if board == None or len(board) == 0 or word == None: return False

        self.m = len(board)
        self.n = len(board[0])
        self.board = board
        self.word = word
        self.word_found = False
        self.directions = [[-1,0], [1,0], [0,-1], [0,1]]

        for i in range(self.m):
            for j in range(self.n):
                if board[i][j] == word[0]:
                    board[i][j] = '#'
                    self.dfs(i, j, 1)
                    board[i][j] = word[0] 
                    if self.word_found == True:
                        break
        return self.word_found

    def dfs(self, row, col, index):
        if index == len(self.word):
            self.word_found = True
            return

        for direction in self.directions:
            nr = row + direction[0]
            nc = col + direction[1]

            if nr >= 0 and nc >= 0 and nr < self.m and nc < self.n and self.board[nr][nc] == self.word[index]:
                self.board[nr][nc] = '#'
                self.dfs(nr, nc, index+1)
                self.board[nr][nc] = self.word[index]