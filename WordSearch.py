""""
Time Complexity : O(n*3^L)
Space Complexity : O(L)
"""
class Solution:
    dirs = [[0, 1],[1, 0],[0, -1],[-1, 0]]

    def helper(self, board, i, j, word, idx):
        #base
        if(i < 0 or j < 0 or i >= len(board) or j >= len(board[0]) or board[i][j] == "#"):
            return False

        if idx == len(word)-1 and board[i][j] == word[idx]: #
            return True

        #logic
        if board[i][j] == word[idx]:
            board[i][j] = "#"

            for d in self.dirs:
                nr = i + d[0]
                nc = j + d[1]

                if (self.helper(board, nr, nc, word, idx+1 )):
                    return True

            board[i][j] = word[idx]

        return False

    def exist(self, board: List[List[str]], word: str) -> bool:
        #go till we find first char of word
        m = len(board)
        n = len(board[0])
        idx = 0
        print("len word", len(word))
        for i in range(0, m):
            for j in range(0, n):
                if board[i][j] == word[0]:
                    result = self.helper(board, i, j, word, idx)

                    if result == True:
                        return result


        return False