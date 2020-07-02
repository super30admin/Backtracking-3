#79. Word Search
# Time Complexity : O(m x n x 3^n) 
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.m = len(board)
        self.n = len(board[0])
        for i in range(self.m):
            for j in range(self.n):
                if self.backtrack(board,word,i,j,0):
                    return True
        return False
    def backtrack(self,board,word,i,j,indx):
        #base
        if indx == len(word):
            return True
        if i < 0 or i >= self.m or j < 0 or j >= self.n or board[i][j] == '#':
            return False
        #logic
        dirs = [[1,0],[-1,0],[0,1],[0,-1]]
        if word[indx] == board[i][j]:
            temp = word[indx]
            board[i][j] = '#'
            for d in dirs:
                r = i + d[0]
                c = j + d[1]
                if self.backtrack(board,word,r,c,indx+1):
                    return True
            board[i][j] = temp
        return False