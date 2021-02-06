#Time Complexity:O(exponential)
#Space Complexity:O(exponential)

#Approach:Backtracking
#The word is seached starting from every index, if the first letter of the word is found, the next letter is found in the adjacent 4 directions, if the letter is found it is replaced by a '#'
#if the next letters dont match the '#' is replaced by the original character and is backtrackeduntil the whole of the letter is found to return True else a false is returned
class Solution:
    global m,n
    def exist(self, board: List[List[str]], word: str) -> bool:      
        if len(board)==0:                                               
            return False
        self.m=len(board)
        self.n=len(board[0])
        for i in range(self.m):
            for j in range(self.n):
                if self.backtrack(board,word,i,j,0):
                    return True
        return False
    
    def backtrack(self,board: List[List[str]] , word:str , i:int, j:int,index:int)->bool:
        if index==len(word):
            return True
        if(i<0 or i==self.m or j<0 or j==self.n or board[i][j]=='#'):
            return False
        dirs=[[1,0],[-1,0],[0,-1],[0,1]]
        if word[index]==board[i][j]:
            temp=board[i][j]
            board[i][j]='#'
            for d in dirs:
                r=i+d[0]
                c=j+d[1]
                if self.backtrack(board,word,r,c,index+1):
                    return True
            board[i][j]=temp
        return False