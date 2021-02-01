#Time Complexity :o(n!)
#Space Complexity :o(n) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
class Solution(object):
    board=None
    m=None
    result=None
    def getArray(self,n):
        arr=[0]*n
        for i in range(n):
            self.board.append(copy.deepcopy(arr))
        
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        self.m=n
        arr=[0]*n
        self.result=[]
        self.board=[]
        self.getArray(n)
        self.backtrack(0)
        return self.result
    
    def backtrack(self,r):
        #base
        #print(self.board)
        if(r==self.m):
            arr=[]
            for i in range(self.m):
                strt=""
                for j in range(self.m):
                    if(self.board[i][j]==1):
                        strt+='Q'
                    else:
                        strt+='.'
                arr.append(strt)
            self.result.append(arr)
            return 
        
        #logic
        for j in range(self.m):
            if(self.isSafe(r,j)):
                #action
                self.board[r][j]=1
                #recurse
                self.backtrack(r+1)
                #backtarck
                self.board[r][j]=0
                
        
        
    def isSafe(self,r,c):
        #column up
        for i in range(r):
            if(self.board[i][c]==1):
                return False
        
        #row up
        for i in range(c):
            if(self.board[r][i]):
                return False
            
        #Diagonal left
        i,j=r,c
        while(i>=0 and j>=0):
            if(self.board[i][j]==1):
                return False
            i-=1
            j-=1
        
        #Diagonal left
        i,j=r,c
        while(i>=0 and j<self.m):
            if(self.board[i][j]==1):
                return False
            i-=1
            j+=1
        return True