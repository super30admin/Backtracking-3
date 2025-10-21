# Space Complexity: O(n) 
# Time Complexity: O(3 ^ n)
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:

        m,n = len(board), len(board[0])
        dirs = [(-1,0), (1,0), (0,-1), (0,1)]

        def backtrack(board, word, r, c, idx, dirs):

            # Base Case
            if idx == len(word):
                return True
            
            if r < 0 or c < 0 or r == len(board) or c == len(board[0]):
                return False

            # Logic
            if board[r][c] == word[idx]:

                # Action
                board[r][c] = '#'

                # Recurse
                # check for neighbours

                for dx, dy in dirs: 
                    nr = r + dx
                    nc = c + dy

                    if backtrack(board, word, nr, nc, idx+1, dirs):
                        return True

                # Backtrack
                board[r][c] = word[idx]

            return False

        for i in range(m):
            for j in range(n):
                if backtrack(board, word, i, j, 0, dirs):
                    return True
        return False










        for i in range(m): 
            for j in range(n):
                if board[i][j] == word[0]:
                    if backtrack(board, word, i, j, 0, dirs):
                        return True
        return False


