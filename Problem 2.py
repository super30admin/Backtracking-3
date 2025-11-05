ROWS, COLS = len(board), len(board[0])
    sofar = set()

    def dfs(i, j, index):
        if index >= len(word):
            return True

        if not 0 <= i < ROWS or not 0 <= j < COLS:
            return False

        if board[i][j] != word[index]:
            return False

        if (i, j) in sofar:
            return False

        sofar.add((i, j))
        res = (
            dfs(i + 1, j, index + 1) or
            dfs(i - 1, j, index + 1) or
            dfs(i, j + 1, index + 1) or
            dfs(i, j - 1, index + 1)
        )

        if not res:
            sofar.remove((i, j))

        return res

    for i in range(ROWS):
        for j in range(COLS):
            if dfs(i, j, 0):  # dfs with backtracking
                return True

    return False
