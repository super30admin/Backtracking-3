# time complexity is o(mn * 3^l), where m, n are the number of rows and columns of input respectively, l is the length of the word
# space complexity is o(l), l is the length of the word, o(l) is recursive stack space
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        r = len(board)
        c = len(board[0])
        direc = [[-1, 0], [1, 0], [0, 1], [0, -1]]
        for i in range(r):
            for j in range(c):
                if(board[i][j] == word[0]):
                    if(self.backtrack(board, i, j, 0, word, direc, r, c)):
                        return True
        return False
    
    def backtrack(self, board, i, j, ind, word, direc, r, c):
        if(ind == len(word)):
            return True
        if(i < 0 or j < 0 or i == r or j == c or board[i][j] == '#'):
            return False
        
        if(board[i][j] == word[ind]):
            board[i][j] = '#'
            for d in direc:
                nr = i + d[0]
                nc = j + d[1]
                if(self.backtrack(board, nr, nc, ind+1, word, direc, r, c)):
                    return True
            board[i][j] = word[ind]
        return False
            
        
                    
        
        
        
        
        
        
        
        
                
        
#         rows = len(board)
#         cols = len(board[0])
#         visited = set()

#         def bt(m, n, i):
#             if(i == len(word)):
#                 return True
                     
#             if(m < 0 or n < 0 or m >= rows or n >= cols or board[m][n] != word[i] or (m,n) in visited):
#                 return False
            
#             visited.add((m,n))
#             result = (bt(m-1, n, i+1) or bt(m, n-1, i+1)
#                       or bt(m+1, n, i+1) or bt(m, n+1, i+1))
#             visited.remove((m,n))
#             return result
        
#         for r in range(rows):
#             for c in range(cols):
#                 if(bt(r,c, 0)):
#                     return True
#         return False
    
    
        