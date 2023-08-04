# Time Complexity : O(m*n * 3^L). mn is the size of the matrix, L is the word length -> cause at each character in string you'll have 3 options
# Space Complexity : O(L) for the recursive stack
# Here, we do a DFS starting from 0,0 (intially). Then, when curr character of string matches the curr grid character, we mark it as visited and DFS from this point. If, at any point the characters don't meet we go back to previous recursion call and remove the curr grid element from visited.

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        m = len(board)
        n = len(board[0])
        self.flag = False
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]

        def dfs_backtrack(board, word, i, j, idx):
            # base
            if idx == len(word):
                self.flag = True
                return
            if i < 0 or j < 0 or i >= len(board) or j >= len(board[0]) or board[i][j] == '#':
                return

            # logic
            if word[idx] == board[i][j]:
                # action
                board[i][j] = "#" #mark as visited
                # recurse
                for d in dirs:
                    nr = d[0] + i
                    nc = d[1] + j
                    if not self.flag:
                        dfs_backtrack(board, word, nr, nc, idx + 1)
                    if self.flag:
                        break  # break out of the for loop immediately if flag is true
                # backtrack
                board[i][j] = word[idx] #unmark it

        for i in range(m):
            for j in range(n):
                if not self.flag:
                    dfs_backtrack(board, word, i, j, 0)

        return self.flag
