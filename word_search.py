# Time Complexity : O(M*3**L) where M is size of matrix and L is length of target word
# Space Complexity : O(M)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I recursively search all the neighboring cells for the current letter in the word and return if they dont match
# and return True only if index is at the end of the word

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.dirs = [(0,-1),(1,0),(0,1),(-1,0)]
        visited = [[False for x in y] for y in board]

        def helper(x, y, index, word, board, visited):
            rows = len(board)
            columns = len(board[0])
            if  index == len(word): return True
            
            if x < 0 or y < 0 or x >= rows or y >= columns or visited[x][y] or board[x][y] != word[index]:
                return False
            
            visited[x][y] = True

            for direction in self.dirs:
                new_x = x + direction[0]
                new_y = y + direction[1]
                found = helper(new_x, new_y, index+1, word, board, visited)
                if found:
                    return True
                
            visited[x][y] = False 
            return False  
        
        rows = len(board)
        columns = len(board[0])
        for r in range(rows):
            for c in range(columns): 
                found = helper(r, c, 0, word, board, visited)
                if found:
                    return True