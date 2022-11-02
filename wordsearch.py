'''
Time Complexity: O(3^L)
Space Complexity: O(M*N)+O(L)
'''
class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        row = len(board)
        col = len(board[0])
        direction = [[-1,0],[1,0],[0,-1],[0,1]]
        grid = [[False for j in range(col)] for i in range(row)]
        def backtrack(index, grid, r, c):
            if(index==len(word)):
                return True
            for i in direction:
                nr = r+i[0]
                nc = c+i[1]
                if(nr>=0 and nr<row and nc>=0 and nc<col and board[nr][nc]==word[index] and not grid[nr][nc]):
                    grid[nr][nc] = True
                    if(backtrack(index+1, grid, nr, nc)):
                        return True
                    grid[nr][nc] = False
            return False
        
        for i in range(row):
            for j in range(col):
                if(board[i][j]==word[0]):
                    grid[i][j] = True
                    if(backtrack(1, grid, i, j)):
                        return True
                    grid[i][j] = False
        return False
                    
                    
            
            
            
        