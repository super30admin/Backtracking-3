# Time Complexity : O(M*N*4^L) where M is the length of the word, N is the size of the board and L is the length of the word
# Space Complexity : O(L) where L is the length of the word
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using DFS to traverse the board starting from each cell.
# I am keeping track of the current index in the word and the current cell in the board.
# If the current index is equal to the length of the word, I return True.
# If the current cell is out of bounds or the character in the cell is not equal to the character in the word at the current index, I return False.
# I am marking the current cell as visited by changing its value to "#".
# I am then recursively calling the DFS function for the 4 adjacent cells (up, down, left, right) and incrementing the index in the word.
# If any of the recursive calls return True, I return True.
# After exploring all 4 directions, I backtrack by restoring the original value of the cell.
# Finally, if no starting cell leads to a successful match, I return False.


from typing import List
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        m = len(board)
        n = len(board[0])
        dirs = [(1,0),(0,1),(0,-1),(-1,0)]
        def dfs(i,j,idx):
            if idx == len(word):
                return True
            if i < 0 or j < 0 or i == m or j == n or board[i][j] == "#":
                return False
            if board[i][j] != word[idx]:
                return False
            board[i][j] = "#"
            for dr,dc in dirs:
                nr = dr + i
                nc = dc + j
                if dfs(nr,nc,idx+1):
                    return True
            board[i][j] = word[idx]
        for i in range(m):
            for j in range(n):
                if dfs(i,j,0):
                    return True
        return False

        