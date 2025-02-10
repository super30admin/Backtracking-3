# tc O(m*n*3^l), sc O(l).
ROWS, COLUMNS = len(board), len(board[0])
def dfs(row, column, idx):
    if idx == len(word):
        return True
    if not (0 <= row < ROWS and 0 <= column < COLUMNS):
        return
    if board[row][column] != word[idx]:
        return
    char = board[row][column]
    board[row][column] = "."
    ans = dfs(row-1, column, idx+1) or dfs(row, column+1, idx+1) or dfs(row+1, column, idx+1) or dfs(row, column-1, idx+1)
    board[row][column] = char
    return ans

for row in range(ROWS):
    for column in range(COLUMNS):
        if dfs(row, column, 0):
            return True

return False