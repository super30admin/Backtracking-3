#79. Word Search

#code:
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        
        for i in range(len(board)):
            for j in range(len(board[i])):
                if board[i][j]==word[0]:
                    if self.dfs(board, word[1:], i, j, dirs):
                        return True
        return False
    
    def dfs(self, board, word, i, j, dirs):
        if not word:
            return True
        
        # Mark visited and store the copy
        temp = board[i][j]
        board[i][j] = '#'
        for r,c in dirs:
            nr = i+r
            nc = j+c
            
            if nr>=0 and nc>=0 and nr<len(board) and nc<len(board[0]) and board[nr][nc]==word[0]:
                if self.dfs(board, word[1:], nr,nc, dirs):
                    return True
                
                
        #Restoring the value
        board[i][j] = temp
        
        return False
        
    
        
# Time Complexity: O(n*m)
# Space Complexity: O(n)
# Acceppted on Leetcode: Yes