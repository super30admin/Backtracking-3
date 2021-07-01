# Time Complexity : O(m*n*3**len(string))
# Space Complexity : O(len(string))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


#if first letter is matching then start backtracking function from next letter in string
class Solution:
    def __init__(self):
        self.dirs = [[0,1],[1,0],[-1,0],[0,-1]]
        self.m = 0
        self.n = 0
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.m = len(board)
        self.n = len(board[0])
        for i in range(self.m):
            for j in range(self.n):
                if board[i][j] == word[0]:
                    if self.backtrack(board, word, i, j, 1):
                        return True
        return False
    
    def backtrack(self,board,word,r,c,index):
        #base
        if index == len(word):
            return True
        #logic
        temp = board[r][c]
        board[r][c] = "#"
        for d in range(len(self.dirs)):
            i = r + self.dirs[d][0]
            j = c + self.dirs[d][1]
            if i >= 0 and i< self.m and j>=0 and j < self.n and board[i][j] == word[index]:
                if self.backtrack(board,word,i,j,index+1) == True:
                    return True
        board[r][c] = temp
        return False
        
    
    