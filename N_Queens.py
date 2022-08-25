# Time Complexity: O(n! * n^2) The additional n^2 is for isSafe function
# Space: O(n^2)

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        result = []
        if not n:
            return result
        board = [[False for _ in range(n)] for _ in range(n)]
        
        def helper(board,row):
            #Base
            if row == n:
                # print(board)
                temp = []
                for i in range(n):
                    temp2 = [] # Build string with this
                    for j in range(n):
                        if board[i][j]:
                            temp2.append('Q')
                        else:
                            temp2.append('.')
                    temp.append(''.join(temp2))
                result.append(temp)
                return
            
            #Logic
            for col in range(n):
                if isSafe(board,row,col):
                    #Action
                    board[row][col] = True
                    #Recurse
                    helper(board,row+1)
                    #Backtrack
                    board[row][col] = False
        
        
        def isSafe(board,row,col):
            # Column Up
            for i in range(row+1):
                if board[i][col]:
                    return False
            # Diagonal Up Right
            i = row
            j = col
            while i >= 0 and j<n:
                if board[i][j]:
                    return False
                i -= 1
                j += 1
            # Diagonal Up Left
            i = row
            j = col
            
            while i >= 0 and j >= 0:
                if board[i][j]:
                    return False
                i -= 1
                j -= 1
            
            return True
        
        helper(board,0)
        return result
                    