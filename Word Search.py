# Time Complexity: O(n * 3**n) where n is rowlen * collen
# Space Complexity: O(l) where l is the len(word)
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        global dirs, flag, rowlen, collen
        rowlen = len(board)
        collen = len(board[0])
        flag = False
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]

        def recursion(idx, r, c, n):
            global dirs, flag, rowlen, collen
            # Base
            if idx == n:
                flag = True
                return
            # Logic
            if r < 0 or c < 0 or r >= rowlen or c >= collen or board[r][c] == '#':
                return

            if board[r][c] == word[idx]:
                # Action
                board[r][c] = '#'
                # Recurse
                for dirr in dirs:
                    nr = r + dirr[0]
                    nc = c + dirr[1]
                    recursion(idx + 1, nr, nc, n)
                # Backtrack
                board[r][c] = word[idx]

        for i in range(rowlen):
            for j in range(collen):
                recursion(0, i, j, len(word))
        return flag
