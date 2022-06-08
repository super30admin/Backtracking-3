# Time Complexity:    O(3^N) as we are checking three sides except the already visited side
# Space Complexity:   O(N) recursive stack


class Solution:
    found = False
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.found = False
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        
        m = len(board)
        n = len(board[0])
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == word[0]:
                    self.helper(board, word, i, j, 0, m, n, dirs)
        return self.found
    
    def helper(self, board, word, i, j, index, m, n, dirs):
        if index == len(word):
            self.found = True
            return
        
        if  i < 0 or j < 0 or i >= m or j >= n or board[i][j] == '#':
            return
        
        if board[i][j] == word[index]:
            board[i][j] = '#'
            
            for di in dirs:
                r = i + di[0]
                c = j + di[1]
                self.helper(board, word, r,c , index+1, m, n, dirs)
            
            board[i][j] = word[index]
