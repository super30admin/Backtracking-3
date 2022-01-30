# // Time Complexity : O(mn * 3^L) where L is the length of the word and mn is the size of the board.
# // Space Complexity : O(L) where L is the length of the word
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Class Solution.

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        def dfs(board,word,i,j,index):
            if index == len(word):
                return True
            if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]) or board[i][j] == "1" or board[i][j] != word[index]:
                return False
            temp = board[i][j]
            board[i][j] = "1"
            case1 = dfs(board,word,i,j-1,index + 1)
            case2 = dfs(board,word,i,j+1,index + 1)
            case3 = dfs(board,word,i-1,j,index + 1)
            case4 = dfs(board,word,i+1,j,index + 1)
            board[i][j] = temp
            return case1 or case2 or case3 or case4
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == word[0]:
                    result = dfs(board,word,i,j,0)
                    if result == True:
                        return True
        return False
