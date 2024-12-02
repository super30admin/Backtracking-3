class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:

        m = len(board)
        n = len(board[0])

        direction_array = [(-1,0), (1,0), (0,1), (0,-1)]

        def dfs(i,j,index):
            if index == len(word):
                return True
            
            #logic
            if (0<=i<m and 0<=j<n and board[i][j]==word[index]):
                temp = board[i][j]
                board[i][j] = '#'

                for dx, dy in direction_array:
                    nr = dx + i
                    nc = dy + j
                    dfs(nr, nc, index+1)
                board[i][j] = temp

        for i in range(m):
            for j in range(n):
                if board[i][j] == word[0]:
                    if dfs(i,j,0):
                        return True

        return False
        

        