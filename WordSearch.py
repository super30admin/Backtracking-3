#All TC passed on leetcode

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:

        #Here we use dfs approach. Whenever we find a cell that matches word[0] we begin dfs. We begin dfs on a cell and traverse the directions, once we find the word[i] in a cell in one of the 4 directions we move forward in that direction.
        #Time complexity - O(m*n*3^L) where m=rows, n=cols, L=length of word. Each cell after the 1st has 3 choices to choose and move forward
        #Space complexity: O(L) - stack space (stack tree) can go max length of word
        m = len(board)
        n = len(board[0])

        visit = set()
        directions = [[1,0], [-1,0], [0,1], [0,-1]]

        for i in range(m):
            for j in range(n):
                if board[i][j]==word[0]:
                    if self.dfs(board, m, n, i, j, 0, word, directions):
                        return True
        return False

    def dfs(self, board, m, n, r, c, idx, word, directions):

        if idx==len(word):
            return True

        if r<0 or c<0 or r>=m or c>=n or board[r][c]==0:
            return False

        if board[r][c]==word[idx]:
            ch = board[r][c]
            board[r][c] = 0
            for dr, dc in directions:
                nr = dr+r
                nc = dc+c
                if self.dfs(board, m, n, nr, nc, idx+1, word, directions):
                    return True
            board[r][c] = ch
        
        return False


        