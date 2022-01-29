# time complexity: O(n!)
# space complexity: O(n^2)

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        result=[]
        if n==0: return result
        
        def isSafe(row, col):
            #check column
            for i in range(row, -1, -1):
                if board[i][col]==True: return False
                
            #upper left diagonal
            i=row
            j=col
            
            while i>=0 and j>=0:
                if board[i][j]==True: return False
                i-=1
                j-=1
                
            #upper right diagonal
            i=row
            j=col
                
            while i>=0 and j<len(board):
                if board[i][j]==True: return False
                i-=1
                j+=1
                
            return True
        
        def backtrack(row):
            #base
            if row==len(board):
                answer=[]
                for i in range(len(board)):
                    bs=""
                    for j in range(len(board)):
                        if board[i][j]==True:
                            bs+='Q'
                        else:
                            bs+="."
                            
                    answer.append(bs)
                    
                print(answer)
                    
                result.append(answer)
                return
            #logic
            for j in range(len(board)):
                if isSafe(row, j):
                    #action
                    board[row][j]=True
                    #recurse
                    backtrack(row+1)
                    #bactrack
                    board[row][j]=False
        
        board=[[None for i in range(n)] for j in range(n)]
        backtrack(0)
        return result