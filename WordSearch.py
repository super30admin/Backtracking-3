# TC: O(M x N x 3 ^ L) where M = rows of matrix, N = columns of matrix and L = length of the word string. 
# SC: O(L) where L = length of input string, which will also be the height of the recursive stack.

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        rows = len(board)
        cols = len(board[0])
        if len(word) == 0:
            return True
        
        if not board or rows == 0 or cols == 0:
            return False
        
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        
        def backtrack(index, i, j):
#             base
            if index == len(word):
                return True
            
            if i < 0 or j < 0 or i >= rows or j >= cols or board[i][j] == '#':
                return False
#             logic 
            if word[index] == board[i][j]:
                temp = board[i][j]
                board[i][j] = '#'
                for x, y in dirs: 
#                   action
                    new_x, new_y = i + x, j + y
#                   recurse
                    if backtrack(index + 1, new_x, new_y):
                        return True
#                   backtrack 
                board[i][j] = temp
            return False
        
        for i in range(rows):
            for j in range(cols):
                if backtrack(0, i, j):
                    return True
        return False
