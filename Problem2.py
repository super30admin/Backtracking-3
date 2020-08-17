# Time Complexity :O(3^nl) where n is number of candidates
# Space Complexity : O(m*n) single temp list
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        # if board == None or len(board)== None:
        #     return False
        self.m = len(board)
        self.n = len(board[0])

        # (0,1)= right, (0,-1) = up , (1,0) =down, (-1,0) = left
        self.dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]

        for i in range(self.m):
            for j in range(self.n):
                if self.dfs(board, i, j, 0, word):
                    return True
        return False

    def dfs(self, board, r, c, index, word):

        # base case
        if index == len(word):
            return True

        if r < 0 or c < 0 or r >= self.m or c >= self.n or board[r][c] == '#':
            return False

        if word[index] == board[r][c]:

            temp = board[r][c]
            board[r][c] = '#'

            for dir in self.dirs:
                i = dir[0]+r
                j = dir[1]+c
                if self.dfs(board, i, j, index+1, word):
                    return True
            # backtrack
            board[r][c] = temp

        return False
