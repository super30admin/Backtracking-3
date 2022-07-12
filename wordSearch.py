#Time Complexity :  O(N * 3^L)
#Space Complexity : O(L)

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if not word or not board:
            return True
        r = len(board)
        c = len(board[0])
        directions = [(1, 0), (0, 1), (0, -1), (-1, 0)]
        for i in range(r):
            for j in range(c):
                if board[i][j] == word[0]:
                    temp = board[i][j]
                    board[i][j] = "-1"
                    if self.helper(board, i, j, word[1:], directions):
                        return True
                    board[i][j] = temp
        return False

    def helper(self, board, r, c, word, directions):
        # base
        if len(word) == 0:
            return True

        # logic
        for x, y in directions:
            nr = r + x
            nc = c + y
            if 0 <= nr < len(board) and 0 <= nc < len(board[0]) and board[nr][nc] == word[0]:
                # action
                temp = board[nr][nc]
                board[nr][nc] = "-1"

                if self.helper(board, nr, nc, word[1:], directions):
                    return True

                # backtrack
                board[nr][nc] = temp

        return False


