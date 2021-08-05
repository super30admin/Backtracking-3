#Time Complexity: O(N!).
#Auxiliary Space: O(N*N)
#Did this code successfully run on Leetcode :Yes

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        result = []
        if n==2 or n==3:
            return result

        board = [[False for i in range(n)]for j in range(n)]
        
        
        def issafe(r,c):
            #column check
            for i in range(r):
                if board[i][c]:
                    return False
            
            #diagonal left 
            i = r
            col = c
            while(i>=0 and col>=0):
                if board[i][col]:
                    return False
                i-=1
                col-=1
            #diagonal right
            i = r
            col = c
            while(i>=0 and col<n):
                if board[i][col]:
                    return False
                i-=1
                col+=1
            return True
            
            
            
            
        def helper(row):
            
            #base
            if row==n:
                list_board = []
                for i in range(n):
                    row_string = ''
                    for j in range(n):
                        if board[i][j]:
                            row_string+='Q'
                        else:
                            row_string+='.'

                    list_board.append(row_string)

                result.append(list(list_board))
                return
            
            #logic
            for i in range(n):#column iterate
                if issafe(row,i):
                    board[row][i] = True #place queen
                    helper(row+1)
                    board[row][i] = False #backtrack

        
        helper(0) #start from row 0
        return result