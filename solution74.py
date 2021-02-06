#Time Complexity:Exponential
#Space Complexity:Exponential

class Solution:
    global board,result                                         #declaring global variables board result and m
    global m
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.result=[]                                          #initializing result a board of size nxn and column size m
        self.board=[[0 for i in range(n)] for i in range(n)]
        self.m=n
        self.backtrack(0)                                       #calling the backtracking function 
        return self.result                                      #returning the result array
        
    def backtrack(self,r:int)->None:
        if r==self.m:                                           #when r is the last column
            l=[]                                                #decalre a list
            for i in range(self.m):                             #for i iterating through each row 
                s=''                                            #create a string
                for j in range(self.m):                         # iterate every column of a given row
                    if self.board[i][j]==1:                     #if at any position value is one append q to the string else append a '.'
                        s+='Q'
                    else:
                        s+='.'
                l.append(s)                                     #append the string to the list l
            self.result.append(l)                               #append the list to the result array and return 
            return
            
        for j in range(self.m):                                 # for every column check if it is safe to add the rth queen in aposition using isSafe function
            if(self.isSafe(r,j)):
                self.board[r][j]=1                              # if it is safe change value on the board to 1 and call backtrack function for next queen
                self.backtrack(r+1)
                self.board[r][j]=0                              #backtrack by replacing the 1 to 0 if the queen positions conflict
        
    def isSafe(self,r:int,c:int)->bool:                         #is Safe function to check if queens dont conflict
        for i in range(r):                                      #if conflict in column return false
            if self.board[i][c]==1:
                return False
        i=r
        j=c
        while i>=0 and j>=0:                                   #if conflict in diagonal right or diagonal left retrurn false
            if self.board[i][j]==1:
                return False
            i-=1
            j-=1
        i=r 
        j=c
        while i>=0 and j<self.m:
            if self.board[i][j]==1:
                return False
            i-=1
            j+=1
        return True                                             #if no conflict found return true