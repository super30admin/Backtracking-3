# Time Complexity : O(3^L)
# Space Complexity : O(L)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

# Your code here along with comments explaining your approach
# Using DFS Approach. Iterate over the board and recursively call the dfs every time for each letter in word to check if we can find the word
# If the word at index == board[i][j] then we store the letter in temp and update board[i][j] to 0 to prevent from visiting it again
# After we find the first character, we check its neighbors by calling the dfs with the index incremented by 1 and row and col of neighbors
# If all the characters are found that is index reaches the end of the word length then return True
# If at any point we dont find the letter then return False


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if not board:
            return None
        if not word:
            return True
        for i in range(len(board)):
            for j in range(len(board[0])):
                if self.dfs(board, i, j, word, 0):
                    return True

    def dfs(self, board, i, j, word, index):
        #base
        if index == len(word):
            return True
        if i < 0 or i >= len(board) or j < 0 or j >= len(
                board[0]) or board[i][j] == 0:
            return False

        #logic
        neighbors = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        if word[index] == board[i][j]:
            temp = board[i][j]
            board[i][j] = 0
            for neighbor in neighbors:
                row = i + neighbor[0]
                col = j + neighbor[1]
                if self.dfs(board, row, col, word, index + 1):
                    return True

            board[i][j] = temp

        return False
