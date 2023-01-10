#time complexity: O(n!)
#space complexity: O(n^2)
#ran on leetcode: Yes
#each queen has to be placed in a row. For each queen, place it in the first position and recurse for the rest of the queens from the next row. Then backtrack: remove this queen from first position and place it in the second position. The loop runs from 0 till column size. If a valid board position is obtained then add it to result.
class Solution:
    def isValid(self,board,row,col):
        #up direction
        i=row-1
        j=col
        while(i>=0):
            if(board[i][j]=='Q'):
                return False
            i-=1
        

        #up left
        i=row-1
        j=col-1
        while(i>=0 and j>=0):
            if(board[i][j]=='Q'):
                return False
            i-=1
            j-=1
        

        #up right
        i=row-1
        j=col+1
        while(i>=0 and j<len(board[0])):
            if(board[i][j]=='Q'):
                return False
            i-=1
            j+=1
        return True
    def backtrack(self,row,board,n):
        if(row==n):
            #convert the current board to a possible solution
            res=[]
            for k in board:
                st=""
                for temp in k:
                    st+=temp
                res.append(st)
            self.ans.append(res)

        for i in range(n):
            if(self.isValid(board,row,i)):
                board[row][i]='Q'
                self.backtrack(row+1,board,n)
                board[row][i]='.'
        
    def solveNQueens(self, n: int) -> List[List[str]]:
        board=[]
        self.ans=[]
        for i in range(n):
            temp=[]
            for j in range(n):
                temp.append('.')
            board.append(temp)
        self.backtrack(0,board,n)
        return self.ans
