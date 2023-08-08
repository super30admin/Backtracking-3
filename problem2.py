# Time Complexity: O(N * M * 4^L) N : number of rows, M :number of columns ,L : length of the word
# Space Complexity: O(L)
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.n = len(board)
        self.m = len(board[0])
        self.dirs = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        for r in range(self.n):
            for c in range(self.m):
                if self.helper(board, word, r, c, 0, set()):
                    return True
        return False

    def helper(self, board, word, r, c, i, path):
        # base
        if i == len(word):
            return True

        if (r < 0 or r >= self.n or 
           c < 0 or c >= self.m or 
           word[i] != board[r][c] or 
           (r, c) in path):
            return False

        # logic
        # action
        path.add((r, c))

        # recurse
        for dr, dc in self.dirs:
            new_r, new_c = r + dr, c + dc
            if self.helper(board, word, new_r, new_c, i + 1, path):
                return True

        # backtrack
        path.remove((r, c))
        return False
