# Run a loop through the colums (0 to col). If the queen can be placed in the specific 
# index, of the row and col, make board[row][col] as true and then recursively call the helper 
# function for row=row+1.then backtrack making board[row][col] as false. if the row == n, print
# and append the result

# time: O(n!)
# space: O(n)

class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        self.result=[]
        self.board = [[None for j in range(n)]for i in range(n)]
        self.helper(n,self.board,0)
        return self.result


    def helper(self, n, board,r):
        if r==n:
            l=[]
            
            for i in range(n):
                st=''
                for j in range(n):
                    if board[i][j]==True:
                        st=st+'Q'
                    else:
                        st=st+'.'
                l.append(st)
            self.result.append(l)
            return True

        
        for c in range(n):
            if self.isSafe(n,board,r,c):
                board[r][c]=True
                self.helper(n, board, r+1)
                board[r][c]=False
    
    def isSafe(self, n, board, r, c):
        #top
        for i in range(r):
            if board[i][c]==True:
                return False
        #top left
        i=r-1; j=c-1
        while i>=0 and j>=0:
            if board[i][j]==True:
                return False
            i-=1
            j-=1
        #top right
        i=r-1; j=c+1
        while i>=0 and j<n:
            if board[i][j]==True:
                return False
            i-=1
            j+=1
        return True      
        