# Time Complexity : O(mn . 3^L) L = length of string
# Space Complexity : O(L)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        dirs = [(0,1),(1,0),(-1,0),(0,-1)]

        boardDic = defaultdict(int)

        def backtrack(board, i, j, word, idx):
            #base
            if idx == len(word):
                return True
            
            if i < 0 or i == len(board) or j < 0 or j == len(board[0]) or board[i][j] == "#":
                return False
            #logic
            if board[i][j] == word[idx]:
                board[i][j] = "#"
                for di in dirs:
                    if backtrack(board, i+di[0], j+di[1], word, idx+1):
                        return True
                board[i][j] = word[idx]
            return False

        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == word[0]:
                    if backtrack(board, i, j, word, 0):
                        return True
        return False

        
        

        
