# Time complexity - O(nm*4^l)
# Space complexity - O(l + nm) # O(nm) - visited array, O(l) - recursive call stack
# Did this solution run on leetcode? - yes
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        n = len(board)
        # edge case
        if not board or n==0:
            return True
        m = len(board[0])
        
        # # visited array
        # self.visited = [[False for _ in range(m)] for _ in range(n)]
        
        # backtracking
        for r in range(n):
            for c in range(m):
                if self.backtrack(board, word, 0, r, c):
                    return True
        
        return False
    
    # backtrack solution
    # Time complexity - O(4l)
    def backtrack(self, board, word, word_idx, r, c):
        # return False, if the pointer gets out of bound or the current location has been visited ("#"-visited) or the current board location is not the same as current alphabet of the word.
        if r<0 or r>=len(board) or c<0 or c>=len(board[0]) or board[r][c]!=word[word_idx]:
            return False
        
        # if we have found the word, return True.
        if word_idx==len(word)-1:
            return True
        
        dirs = [[1,0], [0,1], [-1,0], [0,-1]]
        
        # action
        # set the current grid location as visited.
        # self.visited[r][c]=True
        board[r][c] = "#"
        
        for d in dirs:                  # O(4)
            if self.backtrack(board, word, word_idx+1, r+d[0], c+d[1]):
                return True
            
        # set the current grid location as not visited.
        board[r][c] = word[word_idx]


# Time complexity - O(4l*nm)
# Space complexity - O(n^2 * m^2 + l) # O(l) recursive call stack
# Did this solution run on leetcode? - no (Time limit exceeded)
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        n = len(board)
        # edge case
        if not board or n==0:
            return True
        m = len(board[0])
        
        # visited array
        visited = [[False for _ in range(m)] for _ in range(n)]
        
        # backtracking
        for r in range(n):
            for c in range(m):
                if self.backtrack(board, word, 0, visited, r, c):
                    return True
        
        return False
    
    # recursive solution
    # Time complexity - O(4l)
    def backtrack(self, board, word, word_idx, visited, r, c):
        # return False, if the pointer gets out of bound or the current location has been visited or the current board location is not the same as current alphabet of the word.
        if r<0 or r>=len(board) or c<0 or c>=len(board[0]) or visited[r][c] or board[r][c]!=word[word_idx]:
            return False
        
        # if we have found the word, return True.
        if word_idx==len(word)-1:
            return True
        
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        
        # create a copy of the visited array
        # set the current grid location as visited.
        v = copy.deepcopy(visited)
        v[r][c]=True
        
        for d in dirs:                  # O(4)
            if self.backtrack(board, word, word_idx+1, v, r+d[0], c+d[1]):
                return True

