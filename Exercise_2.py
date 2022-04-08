# Time Complexity: O(n*m *2^len(word))
# Space Complexity: O(L) Recursive stack

class Solution(object):
    m=0
    n=0
 
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        self.m=len(board)
        self.n=len(board[0])
        #  edge case check
        if (board == None or len(board) == 0 or len(word) == 0):
            return False
        
        for i in range(self.m):
            for j in range(self.n):
                if self.dfs(board, word, i, j, 0):
                    return True
        return False
            
    def dfs(self, board, word, i, j, curr):
        # base case
        if i<0 or j<0 or i>=self.m or j >= self.n or board[i][j] == '#':
            return

        # logic
        board_dir = [[0,1],[1,0],[0,-1],[-1,0]]
        if board[i][j] == word[curr]:
            if curr == len(word)-1:
                return True
            curr_word= board[i][j]
            board[i][j] = '#'
            for d in board_dir:
                r = i + d[0]
                c = j + d[1]
                if self.dfs(board, word, r, c, curr+1):
                    return True
            board[i][j] = curr_word
        return False
