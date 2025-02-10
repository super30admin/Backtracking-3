# Tc - O(m*n) -> to search the start point in grid and O(M8N)#^L in 3 directions bcoz we are coming from one direction  we are searching for the next char and L is length of word to be searched
#Sc - O(L) for recursive call
class Solution:
    def __init__(self):
        self.dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        self.m = None
        self.n = None
    def exist(self, board: List[List[str]], word: str) -> bool:
        ## null check
        if not board or not board[0]:
            return False
        self.m = len(board)
        self.n = len(board[0])    

        for i in range(self.m):
            for j in range(self.n):
                if board[i][j] == word[0]:
                    if self.backtrack(board,i,j,word,0):
                        return True
        return False


    def backtrack(self,board,i,j,word,index):
        ## base case
        if len(word) == index:
            return True
        if i <0 or i >= self.m or j<0 or  j>=self.n or board[i][j] == '#':
            return False   


        ## logic
        if board[i][j] == word[index]:
            ## action
            temp = board[i][j]
            board[i][j] ='#'
             ## recurse logic
            for r,c in self.dirs:
                nr = r+i
                nc = c+j
                if self.backtrack(board,nr,nc,word,index+1):
                    return True
            ## backtrack
            board[i][j] = temp          
