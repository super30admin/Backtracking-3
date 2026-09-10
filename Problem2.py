# Problem2: Word Search(https://leetcode.com/problems/word-search/)
# Time Complexity: O(m * n * 4^L) where L = len(word)
# Space Complexity: O(L) recursion stack in the worst case
# Approach: For each cell in the grid, treat it as a possible starting point and launch a DFS. # The DFS checks if the current cell's letter matches the character we need at this step in the word. 
#If it matches,we mark the cell as visited ('#') so it can't be reused in the same path, then recurse into all 4 neighboring cells looking for the next character. 
# If a full match is found (idx reaches word length), we return True all the way up. 
# If none of the neighbors lead to a match, we backtrack by restoring the cell's original letter, so it remains available for other paths starting from different cells.

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.dirs = [(0,1),(0,-1),(1,0),(-1,0)]  # right, left, down, up
        self.m = len(board)   # number of rows
        self.n = len(board[0])  # number of columns

        # try every cell as a possible starting point
        for i in range(self.m):
            for j in range(self.n):
                if self.dfs(board,i,j,word,0):
                    return True
        return False
    
    def dfs(self, board: List[List[str]], i: int, j: int, word: str, idx: int) -> bool:
        if idx == len(word):
            return True  # matched all characters, word found

        # out of bounds or cell already used in this path
        if i<0 or j<0 or i == self.m or j == self.n or board[i][j]=='#':
            return False
        
        # current cell's letter doesn't match the required character
        if board[i][j] != word[idx]:
            return False
        
        board[i][j]='#'  # mark cell as visited for this path
        
        # explore all 4 neighbors for the next character
        for dir in self.dirs:
            r = dir[0]+i
            c = dir[1]+j

            if self.dfs(board,r,c,word,idx+1):
                return True
        
        board[i][j]=word[idx]  # backtrack: restore the original letter
        return False