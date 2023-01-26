#Time Complexity: O(m*n*3^Length of word)
#Space Complexity: O(L)
#Successfully ran on leetcode

class Solution:
    def __init__(self):
        self.m = 0
        self.n = 0
        self.dirs = [[-1,0],[1,0],[0,-1],[0,1]]
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.m = len(board)
        self.n = len(board[0])
        for i in range(self.m):
            for j in range(self.n):
                if self.recurse(board,word,0,i,j):
                    return True
        return False
    def recurse(self,board,word,index,row,col):
        #base
        if index==len(word):
            return True
        if row<0 or row==self.m or col<0 or col==self.n or board[row][col]=='#':
            return False
        #logic
        if board[row][col]==word[index]:
            ch = word[index]
            board[row][col]='#'
            for i in self.dirs:
                nr = row+i[0]
                nc = col+i[1]
                if self.recurse(board,word,index+1,nr,nc):
                    return True
            board[row][col]=ch
        return False
        
