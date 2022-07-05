"""
Leetcode- https://leetcode.com/problems/word-search/ (submitted)
TC- O(permutation path * mn (for traversal)), SC- O(1)
Challenges-NA
Lecture-https://youtu.be/7cZkbmXlRjM
FAQ-Why no BFS? In BFS, once the element is out, it's out from the queue, so we can't backtrack the path.
Can it be done without backtracking? No, since we could go back to the parent neighbor and our DFS will go in infinite
recursion.


Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
vertically neighboring. The same letter cell may not be used more than once.



Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false


Constraints:
m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.


Follow up: Could you use search pruning to make your solution faster with a larger board?
"""


class Solution:
    """
    Ideation- DFS w/ backtracking (mark visited inplace), TC- O(permutation path * mn (for traversal)), SC- O(1)

    The idea is to explore all possible permutation paths that starts with first char of word.
    We prune the permutation path branch if the current char in word doesn't match the neighbor or if the node is
    already visited to avoid any loops in our recursion.
    We also prune recursion if the word was found in one of the DFS by our found flag.
    To account visited nodes, we can either do in place replacement in board or maintain an m*n visited matrix.
    Make sure to maintain the original state of the board and visited when the path does not work, and we backtrack.
    """

    def exist(self, board, word):
        # idea is to make all the dfs aware if the board was found earlier, so they can quit looking.
        # we can achieve this by either keep it a global variable or send as reference.
        found = [False]
        m, n = len(board), len(board[0])
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        # search for all word[0] to do dfs on
        for i in range(m):
            for j in range(n):
                if found[0] == False and board[i][j] == word[0]:
                    # since we already matched first char of word, mark it as visited and call dfs from second char in
                    # word.
                    temp = board[i][j]
                    board[i][j] = '.'
                    self.dfs(board, i, j, word, 1, m, n, found, dirs)
                    board[i][j] = temp

        return found[0]

    def dfs(self, board, r, c, word, index, m, n, found, dirs):
        # base
        if index == len(word):
            found[0] = True
            return
        if found[0]:
            return
        # logic
        for dir in dirs:
            nr = r + dir[0]
            nc = c + dir[1]
            if 0 <= nr < m and 0 <= nc < n and board[nr][nc] == word[index] and board[nr][nc] != '.':
                # action - mark visited
                temp = board[nr][nc]
                board[nr][nc] = '.'
                self.dfs(board, nr, nc, word, index + 1, m, n, found, dirs)
                # backtrack
                board[nr][nc] = temp

    """
    Ideation- DFS w/ backtracking (using visited matrix), TC- O(permutation path * mn (for traversal)), SC- O(mn) for 
    visited matrix

    The idea remains the same except here we are maintaining a separate visited matrix instead of doing in place 
    manipulation in board.
    """

    def exist1(self, board, word):
        # idea is to make all the dfs aware if the board was found earlier, so they can quit looking.
        # we can achieve this by either keep it a global variable or send as reference.
        found = [False]
        m, n = len(board), len(board[0])
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        visited = [[False] * n for i in range(m)]
        # search for all word[0] to do dfs on
        for i in range(m):
            for j in range(n):
                if found[0] == False and board[i][j] == word[0]:
                    # since we already matched first char of word, mark it as visited and call dfs from second char in
                    # word.
                    visited[i][j] = True
                    self.dfs1(board, i, j, word, 1, m, n, found, dirs, visited)
                    # change it back to false for another dfs to explore it
                    visited[i][j] = False

        return found[0]

    def dfs1(self, board, r, c, word, index, m, n, found, dirs, visited):
        # base
        if index == len(word):
            found[0] = True
            return
        if found[0]:
            return
        # logic
        for dir in dirs:
            nr = r + dir[0]
            nc = c + dir[1]
            if 0 <= nr < m and 0 <= nc < n and board[nr][nc] == word[index] and visited[nr][nc] is False:
                # action - mark visited
                visited[nr][nc] = True
                self.dfs1(board, nr, nc, word, index + 1, m, n, found, dirs, visited)
                # backtrack - unmark visited if the path doesn't work out - backtrack
                visited[nr][nc] = False

    """
    Ideation- DFS w/ no backtracking (using visited matrix), TC- O(permutation path * (mn)^2 (for traversal)), 
    SC- O(mn) for visited matrix

    The idea remains the same except here we are maintaining a fresh copy of visited matrix instead of doing in place 
    manipulation in board.
    """

    def exist2(self, board, word):
        # idea is to make all the dfs aware if the board was found earlier, so they can quit looking.
        # we can achieve this by either keep it a global variable or send as reference.
        found = [False]
        m, n = len(board), len(board[0])
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        # search for all word[0] to do dfs on
        for i in range(m):
            for j in range(n):
                if found[0] == False and board[i][j] == word[0]:
                    # since we already matched first char of word, mark it as visited and call dfs from second char in
                    # word.
                    # sending fresh copy of visited for every DFS.
                    visited = [[False] * n for i in range(m)]
                    visited[i][j] = True
                    self.dfs2(board, i, j, word, 1, m, n, found, dirs, visited)

        return found[0]

    def dfs2(self, board, r, c, word, index, m, n, found, dirs, visited):
        # base
        if index == len(word):
            found[0] = True
            return
        if found[0]:
            return
        # logic
        for dir in dirs:
            nr = r + dir[0]
            nc = c + dir[1]
            if 0 <= nr < m and 0 <= nc < n and board[nr][nc] == word[index] and visited[nr][nc] is False:
                temp = [visited[i][:] for i in range(m)]
                temp[nr][nc] = True
                self.dfs2(board, nr, nc, word, index + 1, m, n, found, dirs, temp)
