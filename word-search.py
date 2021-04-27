class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                if board[i][j] == word[0]:
                    res = self.bcktrk(board, m, n, i, j, word[1:])
                    if res:
                        return True
        return False

    def bcktrk(self, board, m, n, i, j, tar):
        temp = board[i][j]
        if len(tar) == 0:
            return True
        board[i][j] = "$"
        for x, y in (i + 1, j), (i - 1, j), (i, j + 1), (i, j - 1):
            if 0 <= x < m and 0 <= y < n and tar[0] == board[x][y]:
                rec = self.bcktrk(board, m, n, x, y, tar[1:])
                if rec:
                    return True
        board[i][j] = temp
        return False
