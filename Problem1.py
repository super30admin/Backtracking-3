#Time complexity is: O(n!)
#Space complexity is:O(n!)
#Program ran successfully on leetcode
#No issues faced while coding
class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        #creating an empty result list
        self.result=[]
        #creating a two dimensional array of size nxn
        self.board=[[0 for i in range(n)] for j in range(n)]
        self.backtrack(self.board,0,n)
        #Finally returning the result array as output
        return self.result
    
    def backtrack(self,board,i,n):
        #base case
        #If i is equal to n, then we will be traversing throught the board
        if(i==n):
            li=[]
            for r in range(0,n):
                #Creating an empty string
                sb=""
                for c in range(0,n):
                    #if board[r][c]==1, we will append Q to the string
                    if(board[r][c]):
                        sb+="Q"
                    #else we will add "." to the sub string
                    else:
                        sb+="."
                #We will add that substring to li
                li.append(sb)
            #Once the iteration is completed over the entire matrix, we will ad that to the result
            self.result.append(li)
            return

        #logic
        for j in range(0,n):
            #We will check whether to add queen in that particular row and column
            if(self.isSafe(board,i,j,n)):
                #action
                #if safe, we will update board[i][j] to 1
                board[i][j]=1
                #recurse
                # We will do recursion 
                self.backtrack(board,i+1,n)
                #backtrack
                #backtracking by updating the matrix value to previous value
                board[i][j]=0
    
    def isSafe(self,board,r,c,n):
        #column up
        #Checking all the top columns and if 1 is already there, we will return 0
        for i in range(0,r):
            if(board[i][c]):
                return 0
        #diagonal up left
        #Checking all the deiagonal up left values and if 1 is already there, we will return 0
        i=r
        j=c
        while(i>=0 and j>=0):
            if(board[i][j]):
                return 0
            i-=1
            j-=1
        #diagonal up right
        #Checking all the deiagonal up right values and if 1 is already there, we will return 0
        i=r
        j=c
        while(i>=0 and j<n):
            if(board[i][j]):
                return 0
            i-=1
            j+=1
        #If the execution reaches this step, we will return since it passes all the above conditions
        return 1