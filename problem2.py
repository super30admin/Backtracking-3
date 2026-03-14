# problem 2 

#https://leetcode.com/problems/word-search/

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.m = len(board)
        self.n = len(board[0])
        self.word = word
        for i in range(self.m):
            for j in range(self.n):
                if self.helper(board,i,j,0):
                    return True
        return False

    

    def helper(self,board,i,j,idx):
        if idx == len(self.word):
            return True 
        if i<0 or j <0 or i>=self.m or j>=self.n or board[i][j] == '#':
            return False 
        if self.word[idx] != board[i][j]:
            return False
        dirs = [[-1,0],[0,-1],[1,0],[0,1]]
        board[i][j] = '#'
        for dir_s in dirs:
            r = dir_s[0] + i
            c = dir_s[1] + j
            if self.helper(board,r,c,idx+1):
                return True
        board[i][j] = self.word[idx]
        return False