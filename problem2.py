# time: O(N*3**l)
# space: O(l)

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        rows, cols = len(board), len(board[0])
        dirs = [ [0,1], [1,0], [0,-1], [-1,0] ]

        def dfs(r,c, index):
            if index==len(word):
                return True

            if r<0 or c<0 or r>=rows or c>=cols or word[index] != board[r][c]:
                return False
            
            temp = board[r][c]
            board[r][c] = None

            for x,y in dirs:
                nx, ny = r+x, c+y
                if dfs(nx, ny, index+1):
                    return True

            board[r][c] = temp

        for r in range(rows):
            for c in range(cols):
                if dfs(r,c, 0):
                    return True
        

        