#Time Complexity :O(m*n*3^l)
#Space Complexity :O(l) where l in len(word)
#Did this code successfully run on Leetcode : yes
class Solution:      
    def _helper(self, board, word, i, j, idx):
        # Base Case
        if idx == len(word):
            return True
        if 0 > i or i == len(board) or 0 > j or j == len(board[0]) or board[i][j] == '#':
            return False
        
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        
        if board[i][j] == word[idx]:
            temp = board[i][j]
            board[i][j] = '#'
            
            for _dir in dirs:
                newRow = i + _dir[0]
                newCol = j + _dir[1]

                if self._helper(board, word, newRow, newCol, idx+1):
                    return True

            board[i][j] = temp
        
        return False
        
        
    def exist(self, board, word):
        n = len(board)
        m = len(board[0])
        
        for i in range(n):
            for j in range(m):
                if self._helper(board, word, i, j, 0):
                    return True
        return False