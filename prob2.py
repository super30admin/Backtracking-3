# Time Complexity : O(mn3**L)
# Space Complexity :O(L)
# Passed on Leetcode: yes

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        def backtrack(board, i, j, word, idx):

            #base
            if idx == len(word):
                return True

            if (i < 0 or i >= m or j < 0 or j >= n or board[i][j] == '#'):
                return False

            #logic
            if word[idx] == board[i][j]:
                #action
                board[i][j] = '#'
                for direc in [[1,0], [0,1], [-1, 0], [0,-1]]:
                    nr = direc[0] + i
                    nc = direc[1] + j
                    #recurse
                    if backtrack(board, nr, nc, word, idx+1):
                        return True
                
                #backtrack
                board[i][j] = word[idx]
            return False

        m = len(board)
        n = len(board[0])

        for i in range(m):
            for j in range(n):
                if backtrack(board, i, j, word, 0):
                    return True
        return False