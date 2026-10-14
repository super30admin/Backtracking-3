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
    def exist(self, board: list[list[str]], word: str) -> bool:
        self.m = len(board)
        self.n = len(board[0])
        for i in range(self.m):
            for j in range(self.n):
                if self.helper(board, i, j, word, 0):
                    return True
        return False

    def helper(self, board, row, col, word, index):
        #base
        if index == len(word):
            return True
        if row < 0 or row >= self.m or col < 0 or col >= self.n or board[row][col] == 0:
            return False
        dirs = {(0,1), (1,0), (-1,0), (0,-1)}
        #logic
        #action
        if board[row][col] == word[index]:
            temp = board[row][col]
            board[row][col] = 0
            #recurse
            for dir in dirs:
                r = row + dir[0]
                c = col + dir[1]
                if self.helper(board, r, c, word, index+1):
                    board[row][col] = temp
                    return True
            board[row][col] = temp
        return False


        