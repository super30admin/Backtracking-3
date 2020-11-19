#Time Complexity : O((mn)*3^l) where m is number of rows, n is number of cols and l is length of the word to be found
#Space Complexity : O(l) where l is the length of the word to be found
#Did this code successfully run on Leetcode : Yes
#Three line explanation of solution in plain english:

class Solution:
    def helper(self, board, r, c, ind, word):
        if len(word) == ind:
            return True
        if r < 0 or r >= len(board) or c < 0 or c >= len(board[0]) or word[ind] != board[r][c] or board[r][c] == "*":
            return False
        curr = board[r][c]
        board[r][c] = '*'
        dirs = [[0,1], [1,0], [0,-1], [-1,0]]
        for x, y in dirs:
            if self.helper(board, x+r, y+c, ind+1, word):
                return True
        board[r][c] = curr
        return False


    def exist(self, board: List[List[str]], word: str) -> bool:
        if (not board or len(board) == 0) and word:
            return False

        for r in range(len(board)):
            for c in range(len(board[0])):
                if word[0] == board[r][c]:
                    if self.helper(board, r, c, 0, word):
                        return True
        return False
