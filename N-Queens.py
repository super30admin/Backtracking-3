class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        
        # Time Complexity: O(N!) --> N choices at first row, N-1 choices at second row and so on.
        # Space Complexity: O(N^2) --> Space occupied by the board.
        
        board = [[0]*n for _ in range(n)]
        result = []
        
        def generateBoard():
            r_board = []
            for i in range(n):
                r_array = []
                for j in range(n):
                    if board[i][j]:
                        r_array.append('Q')
                    else:
                        r_array.append('.')
                r_board.append("".join(r_array))
            return r_board
                    
        
        def isSafe(row,col):

            # Check if column is safe
            r,c = row,col
            while r>=0:
                if board[r][c]:
                    return False
                r -= 1 
            
            # Check if upper-left diagonal is safe
            r,c = row,col
            while r>=0 and c>=0:
                if board[r][c]:
                    return False
                r -= 1
                c -= 1
                
            # Check if upper-right diagonal is safe
            r,c = row,col
            
            while r>=0 and c<n:
                if board[r][c]:
                    return False
                r -= 1
                c += 1
            
            return True
        
        
        def helper(row=0):
            if row == n:
                result.append(generateBoard())
                return
                
            for col in range(n):
                if isSafe(row,col):
                    board[row][col] = 1     # Action
                    helper(row+1)       # Recurse
                    board[row][col] = 0     # BackTrack
                    
        
        helper()
        return result     


### Complexity Analysis ###

# Time Complexity: O(N!) --> N choices at first row, N-1 choices at second row and so on.
# Space Complexity: O(N^2) --> Space occupied by the board.
