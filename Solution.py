class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        1. Perform dfs from each cell of the grid which mathces the first char of the word.
        2. For each dfs, maintain a visited set of points to avoid inifite loop.
        3. We cannot maintain a global visited set as, we do want to revisit the points covered in the previous dfs.
        4. One important thing to note is, once we finish a dfs from a point, we should remove it from visited. This is because we can get to the ans from that node if it was part of some other dfs.
        5. time: From each point, we do a full dfs. so it is 3^W, at each point we can go in 3 directions (not 4 as we wont go back to the direction from where we are coming) and we can go till W depth where W is the length of the word. Since there are M*N points, it is M*N*3^W.
        """
        def dfs(idx, x, y):      
            if idx == len(word):
                return True   
            if not (0<=x<len(board) and 0<=y<len(board[0])):
                return False

            if word[idx] == board[x][y]:
                board[x][y] = "."
                for dx, dy in [(0,1),(0,-1),(1,0),(-1,0)]:
                    nx, ny = x+dx, y+dy
                    if dfs(idx+1, nx, ny):
                        return True                
                board[x][y] = word[idx]
            return False
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == word[0]:
                    if dfs(0, i, j):
                        return True
        return False
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        time: O(N!)
        space: O(N*N)
        """
        res = []
        def can_put(r, c):
            #up column
            for i in range(r):
                if board[i][c]:
                    return False
            
            # up left diagonal
            i, j = r-1, c-1
            while i >=0 and j >= 0:
                if board[i][j]:
                    return False
                i -= 1
                j -= 1
            # up right diagonal
            i, j = r-1, c+1
            while i >=0 and j < n:
                if board[i][j]:
                    return False
                i -= 1
                j += 1
            return True
        
        board = [[False] * n for _ in range(n)]
        def helper(r):
            if r == n:
                local_res = []
                for i in range(n):
                    row = ""
                    for j in range(n):
                        if board[i][j]:
                            row += "Q"
                        else:
                            row += "."
                    local_res.append(row)
                res.append(local_res)
                return         

            for c in range(n):
                if can_put(r, c):
                    board[r][c] = True
                    helper(r+1)
                    board[r][c] = False
        
        helper(0)
        return res
        